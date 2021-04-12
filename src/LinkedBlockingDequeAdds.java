/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  LinkedBlockingDequeAdds
*/

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeAdds {
    public static void main(String[] args) throws InterruptedException {

        // Create a blocking deque with an initial capacity
        BlockingDeque<String> dequeBlocked = new LinkedBlockingDeque<>(4);

        // Test various Offer Methods
        useOfferMethods(dequeBlocked);
        dequeBlocked.clear();

        // Test various Add Methods
        useAddMethods(dequeBlocked);
        dequeBlocked.clear();

        // Test Push Method, returns void, available for deque
        usePushMethod(dequeBlocked);
        dequeBlocked.clear();
    }//public static void main(String[] args) throws InterruptedException {

    // This method uses offer, offerFirst, offerLast methods and tests
    // what happens when queue capacity is reached.
    private static void useOfferMethods(
            BlockingDeque<String> dequeBlocked) {

        // Adding data with offer, adds data to the tail of the queue
        boolean wasSuccessful = dequeBlocked.offer("Jane");
        wasSuccessful = dequeBlocked.offer("Anne");

        // offerLast is equivalent to offer, adds data to the tail
        wasSuccessful = dequeBlocked.offerLast("John");

        // offerFirst adds data to the head
        wasSuccessful = dequeBlocked.offerFirst("Mary");
        System.out.println(dequeBlocked);

        // Any offer method will return a false if unable to add element
        wasSuccessful = dequeBlocked.offer("Harold");
        if (wasSuccessful)
            System.out.println("Harold was added successfully");
        else System.out.println("Harold could not be added");
    }//private static void useOfferMethods(

    // This method uses add, addFirst, addLast methods and tests what
    // happens when queue capacity is reached.
    private static void useAddMethods(BlockingDeque<String> dequeBlocked) {
        // Adding data with add, adds data to the tail of the queue,
        // returns boolean
        boolean wasSuccessful = dequeBlocked.add("Jane");
        wasSuccessful = dequeBlocked.add("Anne");

        // addLast is similar to add, adds data to the tail,
        // but does NOT return a boolean, is void
        dequeBlocked.addLast("John");

        // addFirst adds data to the head, void return
        dequeBlocked.addFirst("Mary");
        System.out.println(dequeBlocked);

        try {

            // Any of the add methods will throw exception
            wasSuccessful = dequeBlocked.add("Harold");
            if (wasSuccessful) System.out.println("Harold was added");

        } catch (IllegalStateException ise) {//try {
            System.out.println("Harold could not be added: " + ise);
        }//catch (IllegalStateException ise) {
    }//private static void useAddMethods(BlockingDeque<String> dequeBlocked) {

    // This method uses push (a deque only method) which returns void
    // and tests what happens when queue capacity is reached.
    private static void usePushMethod(
            BlockingDeque<String> dequeBlocked) {

        // Adding data with push, adds data to the head of the queue
        dequeBlocked.push("Mary");
        dequeBlocked.push("Jane");
        dequeBlocked.push("Anne");
        dequeBlocked.push("John");

        System.out.println(dequeBlocked);
        try {
            // push method returns void, throws exception if not successful
            dequeBlocked.push("Harold");
            System.out.println("Harold was added");

        } catch (IllegalStateException ise) {//try {
            System.out.println("Harold could not be added: " + ise);
        }//catch (IllegalStateException ise) {
    }

}//public class LinkedBlockingDequeAdds {