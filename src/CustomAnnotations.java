/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Custom Annotations
*/

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedClassAnnotation {

}//@interface InheritedClassAnnotation {

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedInterfaceAnnotation {

}//@interface InheritedInterfaceAnnotation {

// Intended as meta-annotation
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationAnnotation {

}//@interface AnnotationAnnotation {

// Intended for Attribute
@Retention(RetentionPolicy.RUNTIME)
@interface AttributeAnnotation {

}//@interface AttributeAnnotation {

// Intended for Constructor
@Retention(RetentionPolicy.RUNTIME)
@interface ConstructorAnnotation {

}//@interface ConstructorAnnotation {

// Intended for Local Variable
@Retention(RetentionPolicy.RUNTIME)
@interface LocalVariableAnnotation {

}//@interface LocalVariableAnnotation {

// Intended for Method
@Retention(RetentionPolicy.RUNTIME)
@interface MethodAnnotation {

}//@interface MethodAnnotation {

// Intended for Method Parameter
@Retention(RetentionPolicy.RUNTIME)
@interface MethodParameterAnnotation {

}//@interface MethodParameterAnnotation {

// Intended for Type (Class, Enum, Interface)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeAnnotation {

}//@interface TypeAnnotation {

// Intended for Type Parameter
@Target(ElementType.TYPE_PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeParameterAnnotation {

}

// Intended for Type Use
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeUseAnnotation {

}