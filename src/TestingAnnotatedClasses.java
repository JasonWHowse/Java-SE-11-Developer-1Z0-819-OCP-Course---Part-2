/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotations

In the output folder:
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java

*/

import annotations.MyClassAnnotation;
import annotations.MyRuntimeAnnotation;
import annotations.MySourceAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Apply annotations to the class
@MyRuntimeAnnotation(
        author = "Tim",
        version = 1.0,
        description = "This class is used for testing annotations"
)
public class TestingAnnotatedClasses {

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
                ((Class) e).getDeclaredAnnotations();
        else if (e instanceof Method) annotations =
                ((Method) e).getDeclaredAnnotations();
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
}//public class TestingAnnotatedClasses {