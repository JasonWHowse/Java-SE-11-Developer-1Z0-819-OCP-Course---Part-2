/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Method clashing
*/

interface FirstInterface {
    // private method
    private void methodA() {
        System.out.println("FirstInterface's default method A");
    }//private void methodA() {
}//interface FirstInterface {

interface SecondInterface {
    // static (and public) method
    static void methodA() {
        System.out.println("SecondInterface's default method A");
    }//static void methodA() {
}//interface SecondInterface {

public class ClashingMethods {
    public static void main(String[] args) {
        ClashingMethods first = new ClashingMethods();
        // Calling static method on an interface
        SecondInterface.methodA();

    }//public static void main(String[] args) {
}//public class ClashingMethods {