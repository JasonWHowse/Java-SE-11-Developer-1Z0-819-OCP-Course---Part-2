/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Local Class
*/

abstract class AbstractClass {
    public abstract void doSomething();
}//abstract class AbstractClass {

interface Executable {
    void doSomething();
}//interface Executable {

public class LocalClassExample2 {
    String name = "Doe";

    public static void main(String[] args) {
        String name = "Smith";

        // Local class can extend any class, including abstract one
        class A extends AbstractClass {
            public void doSomething() {
                System.out.println("name = " + name);
            }//public void doSomething() {
        }//class A extends AbstractClass {


        // Local class can implement interfaces
        class B implements Executable {
            public void doSomething() {
                System.out.println("name = " + name);
            }//public void doSomething() {
        }//class B implements Executable {

        // Declaring a local abstract class
        abstract class C extends AbstractClass {

        }//abstract class C extends AbstractClass {

        // Create a local class extending another local class
        class D extends C {
            public void doSomething() {
                System.out.println("name = " + name);
            }//public void doSomething() {
        }//class D extends C {

        // Execute code on instances of local classes
        new A().doSomething();
        new B().doSomething();
        new D().doSomething();
    }//public static void main(String[] args) {
}//public class LocalClassExample2 {