/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Passing Runnable to a Thread Constructor
*/

import java.util.stream.Stream;

// Class does NOT subclass a Thread, instead implements Runnable
// and can be passed to a new instance of a Thread
class NumberGenerator extends Number implements Runnable {
    private int seed = 1;

    NumberGenerator(int seed) {
        this.seed = seed;
    }

    public void run() {
        Stream<Integer> infiniteStream =
                Stream.iterate(this.seed, (t) -> t + this.seed);
        try {
            infiniteStream.forEach(s -> {
                // must satisfy catch/specify for InterruptedException
                try {
                    // numbers printed every half a second
                    Thread.sleep(500);
                } catch (InterruptedException ie) {//try {
                    // throws an unchecked method when interrupted
                    throw new RuntimeException("interrupted");
                }//catch (InterruptedException ie) {
                // print numbers and include thread name
                System.out.print(": " + s + " ");
            });

        } catch (RuntimeException re) {//try {
            // Print a statement and terminate cleanly
            System.out.println("\nInterrupted the thread's execution");
        }//catch (RuntimeException re) {
    }//public void run() {

    // Overriding methods on Number..
    public int intValue() {
        return this.seed;
    }//public int intValue() {

    public long longValue() {
        return this.seed;
    }//public long longValue() {

    public float floatValue() {
        return this.seed;
    }//public float floatValue() {

    public double doubleValue() {
        return this.seed;
    }//public double doubleValue() {
}//class NumberGenerator extends Number implements Runnable {

public class RunnableThreadCreation {
    public static void main(String[] args) throws InterruptedException {

        // Create a Thread, pass a Runnable object, in this case an instance
        // of NumberGenerator class
//        Thread n = new Thread(new NumberGenerator(100));
        // Creating a Thread and passing it a Runnable object, in this
        // case an instance of NumberGenerator class
        Thread n = new Thread( new NumberGenerator(100)::run);

        // Now we call start() which executes NumberGenerator's run()
        n.start();

        // Pause current thread and let new asynchronous thread do a
        // little work in the mean time
        Thread.sleep(3000);

        // Interrupt third asynchronous thread
        n.interrupt();

        // Wait until it is confirmed that last thread is terminated.
        while (n.isAlive()) {

            System.out.println("\nWaiting for " + n.getName() +
                    " to terminate");
            Thread.sleep(150);
        }//while (n.isAlive()) {

        System.out.println("\nAll threads interrupted, " +
                "Terminating main thread");
    }//public static void main(String[] args) throws InterruptedException {
}//public class RunnableThreadCreation {