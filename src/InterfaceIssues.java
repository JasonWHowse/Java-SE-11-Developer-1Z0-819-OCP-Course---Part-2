/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Limitations of default methods
*/

import java.util.Objects;


interface ProblematicInterface {
    // default methods overriding Object's public, non-final
    default Object clone() throws CloneNotSupportedException {
        System.out.println("Default method CAN override clone()");
        return null;
    }//default Object clone() throws CloneNotSupportedException {

}//interface ProblematicInterface {


// This interface demonstrates overriding and declaring Object's 3
// public methods abstract
interface ProblemFreeInterface {

    // abstract methods overriding Object's non-private, non-final
    // methods is ok
    String toString();

    boolean equals(Object obj);

    int hashCode();

    public Object clone() throws CloneNotSupportedException;
}//interface ProblemFreeInterface {

// This class implements interface above and implements concrete
// methods overriding the 3 public methods
class ProblemFreeClass implements ProblemFreeInterface {

    public int id;

    // Constructor
    ProblemFreeClass(int id) {
        this.id = id;
    }//ProblemFreeClass(int id) {

    public String toString() {
        System.out.println("A Class CAN override toString()");
        return "\tProblemFreeClass{" +
                "id=" + id +
                '}';
    }//public String toString() {

    public boolean equals(Object o) {
        System.out.println("A Class CAN override equals()");
        if (this == o) return true;
        if (!(o instanceof ProblemFreeClass)) return false;
        ProblemFreeClass that = (ProblemFreeClass) o;
        return id == that.id;
    }//public boolean equals(Object o) {

    public int hashCode() {
        System.out.println("A Class CAN override hashCode()");
        return Objects.hash(id);
    }//public int hashCode() {


    public Object clone() throws CloneNotSupportedException {
        System.out.println("A Class CAN override clone()");
        return null;
    }//public Object clone() throws CloneNotSupportedException {
}//class ProblemFreeClass implements ProblemFreeInterface {

// This class extends the ProblemFreeClass, demonstrating calling overloaded
// versions of equals(), hashCode() and toString().

public class InterfaceIssues extends ProblemFreeClass implements ProblematicInterface {


    // Constructor
    InterfaceIssues(int id) {
        super(id);
    }//InterfaceIssues(int id) {

    public static void main(String[] args) {
        InterfaceIssues it = new InterfaceIssues(1);
        ProblemFreeClass it2 = null;
        try {
            it2 = (ProblemFreeClass) it.clone();
        } catch (CloneNotSupportedException e) {//try {
            e.printStackTrace();
        }//catch (CloneNotSupportedException e) {
        boolean isEquals = it.equals(it2);
        System.out.println("\thashCode = " + it.hashCode());
        System.out.println(it);

    }//public class InterfaceIssues extends ProblemFreeClass implements ProblematicInterface {
}//public class InterfaceIssues extends ProblemFreeClass {