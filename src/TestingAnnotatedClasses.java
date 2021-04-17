/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotations

In the output folder:
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java

*/

import annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Apply annotations to the class
@MyRuntimeAnnotation(
        author = "Tim",
        version = 1.0,
        description = "This class is used for testing annotations"
)

// --Marker Annotation,  Repeatable
@MyRepeatableAnnotation

// --Single Element Annotation,  Repeatable
// Do not have to specify element name if it is 'value'
@MyRepeatableAnnotation(10)
public class TestingAnnotatedClasses extends ParentClass
        implements SomeInterface {

    @MyClassAnnotation()
    String MyField = "AnnotatedField";


    // reflection methods used to get information about class, methods,
    // fields
    @MySourceAnnotation()
    public void printRuntimeAnnotations() {
        Class c = this.getClass();

        showAnnotations(c);
        for (Method method : c.getDeclaredMethods()) {
            showAnnotations(method);
        }//for (Method method : c.getDeclaredMethods()) {
        for (Field field : c.getDeclaredFields()) {
            showAnnotations(field);
        }//for (Field field : c.getDeclaredFields()) {

    }//public void printRuntimeAnnotations() {

    // Gets declared annotations, not inherited ones
    public void showAnnotations(Object e) {
        Annotation[] annotations = null;
        if (e instanceof Class) annotations =
                ((Class) e).getAnnotations();
        else if (e instanceof Method) annotations =
                ((Method) e).getAnnotations();
        else if (e instanceof Field) annotations =
                ((Field) e).getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(e.getClass().getSimpleName() +
                    " Annotation: " + annotation);
        }//for (Annotation annotation : annotations) {
    }//public void showAnnotations(Object e) {

    public static void main(String[] args) {
        new TestingAnnotatedClasses().printRuntimeAnnotations();

    }//public static void main(String[] args) {

    // Implementing abstract method of ParentClass
    public void abstractMethod() {
        System.out.println("Implemented abstractMethod");
    }//public void abstractMethod() {

    // Implementing interface's Method
    public void interfaceMethod() {
        System.out.println("Implemented interfaceMethod");
    }//public void interfaceMethod() {
}//public class TestingAnnotatedClasses extends ParentClass


@MyFirstInheritedAnnotation
abstract class ParentClass {

    @MyFirstInheritedAnnotation
    public abstract void abstractMethod();
}//abstract class ParentClass {

@MySecondInheritedAnnotation
interface SomeInterface {

    @MySecondInheritedAnnotation
    void interfaceMethod();
}//interface SomeInterface {