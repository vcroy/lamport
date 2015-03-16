package edu.bits.dc;

/**
 * This class represents a packet to be exchanged between processes in distributed computing environment.
 */
public class Packet {
	
	/**
	 * Message to be delivered.
	 */
	private final Object message;
	
	/**
	 * Id of the receiving process.
	 */
	private final int processId;
	
	/**
	 * Piggyback time from sender process.
	 */
	private final int time;

	/**
	 * Constructs an immutable packet with initialized values.
	 * @param message
	 * @param processId
	 * @param time
	 */
	public Packet(Object message, int processId, int time) {
		this.message = message;
		this.processId = processId;
		this.time = time;
	}

	/**
	 * Get the message.
	 * @return
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * Id of receiver process. 
	 * @return
	 */
	public int getProcessId() {
		return processId;
	}

	/**
	 * Piggyback time from sender process.
	 * @return
	 */
	public int getTime() {
		return time;
	}

	@Override
	public String toString() {
		return String.format("Packet [message=%s, receiving processId=%s, piggyback time=%s]", message, processId, time);
	}
}
