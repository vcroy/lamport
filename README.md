# lamport
Lamport's logical clocks (scalar time) for a distributed computing system

This is a Java Jar file and need JRE 7 or above to run this.
Usage:

java -jar lamport.jar 3 5

Where 3 is the number of processes and simulation will run for 5 seconds.

A sample output of this program:
-------------------------------


Seeting up the distributed computing environment simulation with [] processes and simulation will run for [] seconds.
Process [P0] starts ...
Process [P1] starts ...
Process [P1] performs a local event and clock time is: 1
Process [P2] starts ...
Process [P0] sends an event to process [P1] with piggyback time as: 1
Process [P2] performs a local event and clock time is: 1
Process [P1] receives an event from process [P0] and clock time is: 2
Process [P1] sends an event to process [P2] with piggyback time as: 3
Process [P2] receives an event from process [P1] and clock time is: 4
Process [P0] sends an event to process [P1] with piggyback time as: 2
Process [P1] receives an event from process [P0] and clock time is: 4
Process [P2] performs a local event and clock time is: 5
Process [P1] performs a local event and clock time is: 5
Process [P1] performs a local event and clock time is: 6
Process [P0] performs a local event and clock time is: 3
Process [P1] sends an event to process [P0] with piggyback time as: 7
Process [P0] receives an event from process [P1] and clock time is: 8
Process [P1] performs a local event and clock time is: 8
Process [P0] sends an event to process [P1] with piggyback time as: 9
Process [P1] receives an event from process [P0] and clock time is: 10
Process [P1] performs a local event and clock time is: 11
Process [P2] sends an event to process [P0] with piggyback time as: 6
Process [P0] receives an event from process [P2] and clock time is: 10
Process [P1] sends an event to process [P2] with piggyback time as: 12
Process [P2] receives an event from process [P1] and clock time is: 13
Process [P0] sends an event to process [P2] with piggyback time as: 11
Process [P2] receives an event from process [P0] and clock time is: 14
Process [P1] sends an event to process [P0] with piggyback time as: 13
Process [P0] receives an event from process [P1] and clock time is: 14
Process [P0] performs a local event and clock time is: 15
Process [P2] sends an event to process [P1] with piggyback time as: 15
Process [P1] receives an event from process [P2] and clock time is: 16
Process [P1] sends an event to process [P2] with piggyback time as: 17
Process [P2] receives an event from process [P1] and clock time is: 18
Process [P1] sends an event to process [P0] with piggyback time as: 18
Process [P0] receives an event from process [P1] and clock time is: 19
Process [P2] sends an event to process [P0] with piggyback time as: 19
Process [P0] receives an event from process [P2] and clock time is: 20
Terminating distributed computing environment simulation.
