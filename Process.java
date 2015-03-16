package edu.bits.dc;

/**
 * This class represents an independent process within distributed computing environment.
 * Once started, it performs events (local, send, receive) randomly until stopped.
 */
public class Process implements Runnable {
	
	/**
	 * Local clock time.
	 */
	private int clockTime;
	
	/**
	 * Process Id, starts with 0 to n-1, where n is the number of processes.
	 */
	private final int processId;
	
	/**
	 * Reference to randomly send messages within distributed computing environment. 
	 */
	private final DCSystem dcSystem;
	
	/**
	 * Randomizer.
	 */
	private final java.util.Random random;

	/**
	 * Create a new process.
	 * 
	 * @param dcSystem
	 * @param processId
	 */
	public Process(DCSystem dcSystem, int processId) {
		clockTime = 0; // initialize clock time with 0 
		this.processId = processId;
		this.dcSystem = dcSystem;
		random = new java.util.Random();
	}
	
	@Override
	public void run() {
		System.out.println("Process [P" + processId + "] starts ...");
		while (true) {
			// Perform a random event (local or send).
			int randomEvent = random.nextInt(2);
			switch (randomEvent) {
				case 0: {
					// Perform a local event.
					localEvent();
					break;
				}
				case 1: {
					// Perform a send event.
					sendEvent();
					break;
				}
			}
			try {
				// Add some random delay between events
				long randomDelay = System.currentTimeMillis() % (random.nextInt(1000) + 1000);
				Thread.sleep(randomDelay);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}

	/**
	 * Performs a local event.
	 */
	public void localEvent() {
		// Increment local clock time by 1, no piggyback time so pass -1
		int time = increamentClockTime(-1);
		System.out.println("Process [P" + processId + "] performs a local event and clock time is: " + time);
	}

	/**
	 * Performs a send event to any other random process.
	 */
	public void sendEvent() {
		Object message = "anyThing";
		
		// Gets a random process Id to send event, excluding its own Id.
		int randomProcessId = random.nextInt(dcSystem.numberOfProcesses);
		while(randomProcessId == processId){
			randomProcessId = random.nextInt(dcSystem.numberOfProcesses);
		}
		
		// Increment local clock time by 1, no piggyback time so pass -1
		int time = increamentClockTime(-1);
		System.out.println("Process [P" + processId + "] sends an event to process [P"+ randomProcessId +"] with piggyback time as: " + time);
		Packet packet = new Packet(message, randomProcessId, time);
		
		// Sending packet for delivery.
		dcSystem.deliverSendMessage(packet, processId);
	}

	/**
	 * This message gets executed when the process receives any event from other processes within distributed computing environment.
	 * @param packet
	 * @param senderProcessId
	 */
	public void receiveEvent(Packet packet, int senderProcessId) {
		// Increment local clock time by 1, with respect to piggyback time coming from sender process
		int time = increamentClockTime(packet.getTime());
		System.out.println("Process [P" + processId + "] receives an event from process [P"+ senderProcessId +"] and clock time is: " + time);
	}
	
	/**
	 * Increments the local clock time, applying rules as mentioned below:
	 * 		1. Sets the local clock time to max of local time and piggyback time.
	 * 		2. Increments the calculated local clock by 1 and return.
	 * 
	 *  NOTE: This is a synchronized method to thread-safely increase the time. 
	 * @param piggybackTime
	 * @return
	 */
	public synchronized int increamentClockTime(int piggybackTime){
		clockTime = clockTime > piggybackTime ? clockTime : piggybackTime;
		return ++clockTime;
	}

}
