/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generic Methods
*/

// Apple class, equal if val is same int
class Apple implements Comparable<Apple> {
    private int val;

    Apple(int val) {
        this.val = val;
    }//Apple(int val) {

    public int compareTo(Apple o) {
        return o.val - this.val;
    }//public int compareTo(Apple o) {
}//class Apple implements Comparable<Apple> {

// Orange class, equal if val is same int
class Orange implements Comparable<Orange> {
    private int val;

    Orange(int val) {
        this.val = val;
    }//Orange(int val) {

    public int compareTo(Orange o) {
        return o.val - this.val;
    }//public int compareTo(Orange o) {
}//class Orange implements Comparable<Orange> {

// GreenApple will equal Apple if val is same
class GreenApple extends Apple {
    GreenApple(int val) {
        super(val);
    }//GreenApple(int val) {
}//class GreenApple extends Apple {

public class GenericMethods {

    // Method to compare any type of object passed
    public int compareObjects(Object a, Object b) {

        // Include custom type checking, not extensible or easily maintainable
        if (a instanceof Comparable && b instanceof Comparable) {
            return compareComparables((Comparable) a, (Comparable) b);
        }//if (a instanceof Comparable && b instanceof Comparable) {
        return -1;
    }//public int compareObjects(Object a, Object b) {

    // Method to compare any object implementing Comparable
    public int compareComparables(Comparable a, Comparable b) {
        // Include custom type checking, but does not work with subclasses
        if (a instanceof Apple)
            return ((Apple) a).compareTo((Apple) b);
        else if (a instanceof Orange)
            return ((Orange) a).compareTo((Orange) b);
        else
            return -1;
    }//public int compareComparables(Comparable a, Comparable b) {

    // Method type parameters used in arguments enforce objects passed are
    // the same (or subclasses of) the same type and implement Comparable
    public <T extends Comparable> int compareMatchingTypes(T a, T b) {
        return a.compareTo(b);
    }//public <T extends Comparable> int compareMatchingTypes(T a, T b) {

    public static void main(String[] args) {
        GenericMethods g = new GenericMethods();

        System.out.println("-------- Compare Apple to Apple -----");
        // Compare Apple to Apple with all three Methods
        System.out.println("compareObjects(Apple, Apple): Match = " +
                (g.compareObjects(
                        new Apple(1), new Apple(1)) == 0));

        System.out.println("compareComparables(Apple, Apple): Match = "
                + (g.compareComparables(
                new Apple(1), new Apple(1)) == 0));

        System.out.println("compareMatchingTypes(Apple, Apple): Match = "
                + (g.<Apple>compareMatchingTypes(
                new Apple(1), new Apple(1)) == 0));

        // Compare Apple and Green Apple
        System.out.println("\n-------- Compare Apple to GreenApple -----");
        System.out.println("compareObjects(Apple, GreenApple): Match = "
                + (g.compareObjects(
                new Apple(1), new GreenApple(1)) == 0));

        System.out.println("compareComparables(Apple, GreenApple): Match = "
                + (g.compareComparables(
                new Apple(1), new GreenApple(1)) == 0));

        System.out.println("compareMatchingTypes(Apple, GreenApple): Match = "
                + (g.<Apple>compareMatchingTypes(
                new Apple(1), new GreenApple(1)) == 0));
    }//public static void main(String[] args) {
}//public class GenericMethods {