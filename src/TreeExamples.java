/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Sorting TreeSet
*/

import java.util.*;

// Class implements both Comparable & Comparator
class TreeElement implements
        Comparable<TreeElement>, Comparator<TreeElement> {

    private int id;
    private String value;

    // Constructor
    public TreeElement(int id, String value) {
        this.id = id;
        this.value = value;
    }//public TreeElement(int id, String value) {

    // overriding Comparable.compareTo
    public int compareTo(TreeElement o) {
        // "Natural Order" = sorted by id ascending
        return this.id - o.id;
    }//public int compareTo(TreeElement o) {

    // overriding Comparator.compare
    public int compare(TreeElement o1, TreeElement o2) {
        // Order by value - descending, assume for now value is not null
        return o2.value.compareToIgnoreCase(o1.value);
    }//public int compare(TreeElement o1, TreeElement o2) {

    public String toString() {
        return "{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }//public String toString() {

    public int getId() {
        return id;
    }//public int getId() {

    public String getValue() {
        return value;
    }//public String getValue() {
}//class TreeElement implements

// Test TreeSet ordering with Comparable and Comparator
public class TreeExamples {
    public static void main(String[] args) {

        List<TreeElement> setTestData = List.of(
                new TreeElement(2, "Sam"),
                new TreeElement(5, "Carol"),
                new TreeElement(1, "Mary"),
                new TreeElement(10, "Tim"));

        // Create TreeSet passing data to constructor and print data
        TreeSet<TreeElement> treeSet = new TreeSet<>(setTestData.get(0));
        treeSet.addAll(setTestData);
        System.out.println("---- TreeSet Values ----");
        treeSet.forEach(System.out::println);
        System.out.println("---- Element lower than Sam ----");
        System.out.println(treeSet.lower(setTestData.get(0)));

    }//public static void main(String[] args) {
}//public class TreeExamples {