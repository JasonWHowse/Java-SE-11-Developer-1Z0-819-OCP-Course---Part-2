/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic: Default, Static, Private methods
*/

// Example of simple class with a public static method
class TestStatic {
    public static void doClassPublicAndStatic() {
        System.out.println("This is a class's public and static method");
    }//public static void doClassPublicAndStatic() {
}//class TestStatic {

// This interface has new features for interfaces:
interface PrivateAndDefaultTestable {
    // default method
    default void doInterfaceSomethingPublic() {
        System.out.println("This is interface's public default method");
        // Accesses a private method
        doInterfaceSomethingPrivate();
        doInterfaceSomethingPublicAndStatic();
        doInterfaceSomethingPrivateAndStatic();
    }//default void doInterfaceSomethingPublic() {

    // private method consolidates code
    private void doInterfaceSomethingPrivate() {
        System.out.println("\tThis is private interface instance method");
    }//private void doInterfaceSomethingPrivate() {

    // static method
    public static void doInterfaceSomethingPublicAndStatic() {
        System.out.println("This is an interface's public and" +
                " static method");
        doInterfaceSomethingPrivateAndStatic();
    }//public static void doInterfaceSomethingPublicAndStatic() {

    // private static method accessible by static method
    private static void doInterfaceSomethingPrivateAndStatic() {
        System.out.println("\tThis is private and static interface " +
                " method");
    }//private static void doInterfaceSomethingPrivateAndStatic() {
}//interface PrivateAndDefaultTestable {

// This class tests ways to call interface methods (default, static, etc)
public class TestPrivateInterfaceMethods extends TestStatic implements PrivateAndDefaultTestable {
    public static void main(String[] args) {
        // Accessing static method on a class (when current class is subclass)
        // from a static method
        doClassPublicAndStatic();

        // Access static method on class with class qualifier
        TestStatic.doClassPublicAndStatic();

        // Access static method on interface with interface qualifier
        PrivateAndDefaultTestable.doInterfaceSomethingPublicAndStatic();

        // Call non-static method using instance of current class
        new TestPrivateInterfaceMethods().testNonStatic();
    }//public static void main(String[] args) {


    void testNonStatic() {
        System.out.println("\n---- Executing interface methods in " +
                "instance method ---");

        // Accessing static method on a class (when current class is subclass)
        // from an instance method
        doClassPublicAndStatic();

        // Access static method on class with class qualifier
        TestStatic.doClassPublicAndStatic();

        // Access static method on interface with interface qualifier
        PrivateAndDefaultTestable.doInterfaceSomethingPublicAndStatic();

        // Can call default method on interface
        doInterfaceSomethingPublic();

        // Can use default method with super in a non-static method
        PrivateAndDefaultTestable.super.doInterfaceSomethingPublic();
    }//void testNonStatic() {
}//public class TestPrivateInterfaceMethods extends TestStatic implements PrivateAndDefaultTestable {