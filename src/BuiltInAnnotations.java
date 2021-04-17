/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Built In Annotations
*/

@FunctionalInterface
interface Functionable {
    void performSomeFunction();
}

public class BuiltInAnnotations implements Functionable {
    public static void main(String[] args) {
        new BuiltInAnnotations().performSomeFunction();
    }//public static void main(String[] args) {

    @Override
    public void performSomeFunction() {
        System.out.println("Overrode Functionable's method");
    }//public void performSomeFunction() {
}//public class BuiltInAnnotations implements Functionable {