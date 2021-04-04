/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, Confusing type parameters
*/

// class Container, a generic class with one type parameter
class Container<Number> {

    // instance variable
    Number myNumber;

    // Constructor
    Container(Number myNumber) {
        this.myNumber = myNumber;
        System.out.println(this);
    }//Container(Number myNumber) {

    // overridden toString() method
    public String toString() {
        return myNumber.toString();
    }//public String toString() {

}//class Container<Number> {

public class GenericsConfusion {
    public static void main(String[] args) {
        // Declare Container with String type argument
        Container<String> c1 = new Container<>("Hello");

        // Declare Container with String type argument
        Container<Integer[]> c2 = new Container<>(new Integer[]{1, 2, 3, 4});

        // Declare Container with UnknownError type argument
        Container<UnknownError> c3 =
                new Container<>(new UnknownError("Testing"));

        CardboardContainer<String> n1 =
                new CardboardContainer<String>("Hello");

        CardboardContainer<String> n2 =
                new CardboardContainer<>(3);

        CardboardContainer<String> n3 =
                new <Integer>CardboardContainer<String>(3);


    }//public static void main(String[] args) {
}//public class GenericsConfusion {

class CardboardContainer<T> {
    T myField;

    CardboardContainer(T myField) {
        System.out.println("In T constructor");
        this.myField = myField;
    }//CardboardContainer(T myField) {

    <V extends Number> CardboardContainer(V myField) {
        System.out.println("In T2 constructor");
//        this.myField = myField;
    }//<V extends Number> CardboardContainer(V myField) {
}//class CardboardContainer<T> {
