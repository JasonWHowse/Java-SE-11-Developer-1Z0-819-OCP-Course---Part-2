/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Comparator interface
*/

import java.util.Arrays;
import java.util.Comparator;

// Create a comparator to sort names using last names
class LastNameComparator implements Comparator<String> {

    // Do not want natural order, want to sort by the last name if one
    // exists. Assume no titles and suffixes in the names
    public int compare(String o1, String o2) {
        // Deal with nulls
        if (o1 == null || o2 == null) return -1;

        // Split names on whitespace
        String[] names1 = o1.split("\\s");
        String[] names2 = o2.split("\\s");

        // Assumption is last String is the last name, leverage
        // compareTo method of String which implements Comparable
        return names1[names1.length - 1].compareTo(names2[names2.length - 1]);
    }//public int compare(String o1, String o2) {
}//class LastNameComparator implements Comparator<String> {

public class ComparatorExample {
    public static void main(String[] args) {

        // Create an array of different names to test the compare method
        String[] names = {
                "Ralph Smith",
                "Martha G. Jones",
                "Anne Margaret Caroline Green",
                "Owen White",
                "Irene Funk",
                "Philip",
                "Joe Ford"};

        System.out.println("------ Unsorted initial List ------");
        for (String name : names) {
            System.out.println(name);
        }//for (String name : names) {

        // Uses natural order... Strings implement Comparable
        Arrays.sort(names);
        System.out.println("------ Arrays.sort(String[]) ------");

        for (String name : names) {
            System.out.println(name);
        }//for (String name : names) {
    }//public static void main(String[] args) {
}//public class ComparatorExample {