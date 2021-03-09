/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Anonymous classes
*/

abstract class AnAbstractClass {
    int i;

    protected abstract void doSomething();
}//abstract class AnAbstractClass {

interface Doable {
    void doSomething();
}//interface Doable {

public class AnonymousInnerExample {
    String name = "Default";

    public void testAnonymous() {

        // Declare a variable of type AnAbstractClass and immediately
        // define the class body
        AnAbstractClass a = new AnAbstractClass() {
            // Implementing the abstract method on AnAbstractClass
            public void doSomething() {
                System.out.println("Anonymous AnAbstractClass " +
                        "will doSomething with " + i);
            }//public void doSomething() {
        };  // Declaration occurs in an expression and must end with ';'

        a.doSomething();
        // Anonymous class extending Object

        Object b = new Object() {
            public String toString() {
                return "Anonymous object";
            }//public String toString() {
        };

        System.out.println(b);

        // Anonymous class implements interface Doable
        new Doable() {
            public void doSomething() {
                System.out.println("Anonymous Doable " +
                        "will doSomething with " + b);
            }//public void doSomething() {
        }.doSomething();



        // If you want to pass parameters to your anonymous
        // class, you can extend abstract class using a local
        // class
        abstract class ConcreteClass extends AnAbstractClass {
            ConcreteClass(int i) {
                this.i = i;
            }//abstract class ConcreteClass extends AnAbstractClass {
        }//ConcreteClass(int i) {

        // This example shows an anonymous class created with an
        // instance initializer and passing a value to the constructor
        AnAbstractClass c = new ConcreteClass(5) {
            {
                i = 2 * this.i;
            }

            public void doSomething() {
                System.out.println("Anonymous AnAbstractClass " +
                        "will doSomething with " + i);
            }//public void doSomething() {
        };
        c.doSomething();
    }//public void testAnonymous() {

    public static void main(String[] args) {
        new AnonymousInnerExample().testAnonymous();
    }//public static void main(String[] args) {
}//public class AnonymousInnerExample {