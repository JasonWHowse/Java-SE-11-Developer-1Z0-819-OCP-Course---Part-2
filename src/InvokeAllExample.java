/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Using ExecutorService, InvokeAll method
*/

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class InvokeAllExample {

    public static void main(String[] args) {

        // Create a collection of Callable lambda expressions
        Collection<Callable<IntSummaryStatistics>> tasks = List.of(
                () -> InvokeAllExample
                        .doSomething(3, 7),
                () -> InvokeAllExample
                        .doSomething(5, 5),
                () -> InvokeAllExample
                        .doSomething(75, 5),
                () -> InvokeAllExample
                        .doSomething(100, 5)
        );

        ExecutorService executorService = null;

        // Following variable will hold results
        List<Future<IntSummaryStatistics>> results = null;

        try {
            executorService = Executors.newFixedThreadPool(2);
            // Invoke them all.
            results = executorService.invokeAll(tasks, 2, TimeUnit.SECONDS);

        } catch (InterruptedException e) {//try {
            e.printStackTrace();
        } finally {//catch (InterruptedException e) {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 2 seconds for completion confirmation
//                    executorService.awaitTermination(2, TimeUnit.SECONDS);

                    if (results != null) {
                        // Print out results of each task
                        for (Future<IntSummaryStatistics> f : results) {
                            System.out.println(f);
                            System.out.println(f.get());
                        }//for (Future<IntSummaryStatistics> f : results) {
                    }//if (results != null) {

                } catch (InterruptedException | ExecutionException e) {//try {
                    e.printStackTrace();
                }//} catch (InterruptedException | ExecutionException e) {
            }//if (executorService != null) {

        }//finally {

    }//public static void main(String[] args) {

    private static IntSummaryStatistics doSomething(int seed, int limit) {
        return Stream.iterate(seed, (t) -> t + seed)
                .limit(limit)
                .mapToInt((s) -> s)
                .peek((s) -> {
                    System.out.print("[" + seed + "'s] " + s + ", ");
                    if (s == limit * seed) System.out.println("");
                })
                .summaryStatistics();

    }//private static IntSummaryStatistics doSomething(int seed, int limit) {
}