package edu.bits.dc;

/**
 * This is simulated distributed computing environment to create specified number of processes and start them to perform events (local, send, receive).
 */
public class DCSystem {
	
	/**
	 * Number of processes to simulate.
	 */
	public final int numberOfProcesses;
	
	/**
	 * List of participating processes.
	 */
	private final java.util.List<Process> processes;
	
	/**
	 * Setup the distributed computing environment with specified number of processes and create them.
	 * @param numberOfProcesses
	 */
	public DCSystem(int numberOfProcesses) {
		this.numberOfProcesses = numberOfProcesses;
		this.processes = new java.util.ArrayList<Process>();
		for (int i = 0; i < numberOfProcesses; i++) {
			this.processes.add(new Process(this, i));
		}
	}
	
	/**
	 * Delivers the event messages as per packet details.
	 * @param packet
	 * @param senderProcessId
	 */
	public synchronized void deliverSendMessage(Packet packet, int senderProcessId) {
		Process process = processes.get(packet.getProcessId());
		process.receiveEvent(packet, senderProcessId);
	}
	
	/**
	 * Main method to start the simulation.
	 * Parameters are:
	 * 		Integer - Number of processes.
	 * 		Integer - Duration to run the simulation in seconds.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Two integer parameters are required
		if(args.length < 2){
			System.out.println("Usage: provide number of parameters and duration to run simulation in seconds.");
			System.exit(0);
		}
		int processCount = Integer.parseInt(args[0]);
		int duration = Integer.parseInt(args[1]);
		
		long timestamp = System.currentTimeMillis();
		System.out.println("Setting up the distributed computing environment simulation with [" + processCount + "] processes and simulation will run for [" + duration + "] seconds.");
		DCSystem dcSystem = new DCSystem(processCount);
		
		// Starting individual processes
		for(Process process : dcSystem.processes) {
			new Thread(process).start();
		}
		
		// Wait till specified duration to run the simulation and then terminate.
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println("Terminating distributed computing environment simulation, duration [" + ((System.currentTimeMillis() - timestamp) / 1000) + "] seconds.");
		System.exit(0);
	}
}
