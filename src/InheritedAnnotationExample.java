/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Testing Inherited Annotations
*/

// Annotate an Interface with one that had meta-annotation @Inherited
@InheritedInterfaceAnnotation
interface SuperInterface {

}//interface SuperInterface {

// Annotate a Class with one that had meta-annotation @Inherited
@InheritedClassAnnotation
class SuperClass {

}//class SuperClass {

// Do not annotate this class, which extends SuperClass and implements
// SuperInterface
public class InheritedAnnotationExample extends SuperClass
        implements SuperInterface {
    public static void main(String[] args) {
        System.out.println("Testing meta-annotations");
    }//public static void main(String[] args) {
}//public class InheritedAnnotationExample extends SuperClass