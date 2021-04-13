/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Collect and Reduce
*/

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParallelExtras {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(Set.of("b", "c", "d"));

        // Using reduce with StringBuilder
        StringBuilder firstResult = set
                .stream()
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder(),
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));

        System.out.println("firstResult = " + firstResult);

        // Using collect with StringBuilder
        StringBuilder secondResult = set
                .stream()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));

        System.out.println("secondResult = " + secondResult);
    }//public static void main(String[] args) {
}//public class ParallelExtras {