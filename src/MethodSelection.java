/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Class, Extras
*/

class SuperClass {
    public void doSomething() {
        System.out.println("SuperClass: doSomething");
    }//public void doSomething() {
}//class SuperClass {

interface LessSpecificInterface {
    default void doSomething() {
        System.out.println("LessSpecific: doSomething");
    }//default void doSomething() {
}//interface LessSpecificInterface {

interface MoreSpecificInterface  {
    default void doSomething() {
        System.out.println("MoreSpecific: doSomething");
    }//default void doSomething() {
}//interface MoreSpecificInterface extends LessSpecificInterface {

public class MethodSelection implements LessSpecificInterface,MoreSpecificInterface {
    public static void main(String[] args) {
        MethodSelection methodSelection = new MethodSelection();
        methodSelection.callDoSomething();
    }//public static void main(String[] args) {

    public void callDoSomething() {
        doSomething();
    }//public void callDoSomething() {

    public void doSomething() {

    }//public void doSomething() {

}//public class MethodSelection implements MoreSpecificInterface {