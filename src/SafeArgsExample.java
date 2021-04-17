/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Using @SafeArgs
*/

import java.util.Arrays;

// Create a simple generic class
class MyClass<T> {
    T name;

    MyClass(T name) {
        this.name = name;
    }//MyClass(T name) {
}//class MyClass<T> {

public class SafeArgsExample {
    public static void main(String[] args) {

        // Generic Array creation is not allowed
        MyClass[] myArray = {
                new MyClass<>("jane"),
                new MyClass<>("joe")
        };

        // Yet you can do this...
        doSomething(new MyClass<>("jane"), new MyClass<>("joe"));
    }//public static void main(String[] args) {

    @SafeVarargs
    // Method with parameterized typed MyClass varargs
    public static void doSomething(MyClass<String>... myStuff) {
        Arrays.stream(myStuff)
                .forEach(System.out::println);
    }//public static void doSomething(MyClass<String>... myStuff) {
}//public class SafeArgsExample {