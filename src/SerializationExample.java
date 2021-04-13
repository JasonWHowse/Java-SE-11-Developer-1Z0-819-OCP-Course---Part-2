/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Serialization / Deserialization
*/

import java.io.*;

class Animal  {
    int age;
    int weight;

    Animal() {
        System.out.println("Inside no args Animal constructor");
    }//Animal() {

    Animal(int age) {
        System.out.println("Inside single args Animal constructor");
    }//Animal(int age) {
}//class Animal implements Serializable {

// Class must implement Serializable if it does not extend
// a class that implements Serializable...
class Pet extends Animal implements Externalizable {
    private String name;
    private String type;
    private transient String breed = "Unknown";
    static int count;

    // No arguments constructor
    public Pet() {
        super(0);
        System.out.println("Inside no args Pet constructor");
    }//public Pet() {

    // Constructor takes name and type of Pet
    Pet(String name, String type) {
        super(0);
        this.name = name;
        this.type = type;
        System.out.println("Inside Pet(name,type) constructor");
    }//Pet(String name, String type) {

    // Use IntelliJ generated toString() method
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", weight ='" + weight + '\'' +
                ", count ='" + count + '\'' +
                '}';
    }//public String toString() {

    // overrides default method on Serializable

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal");
        out.writeObject(name);
        out.writeObject(breed);
        out.write(age);

    }//public void writeExternal(ObjectOutput out) throws IOException {

    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("readExternal");
        name = (String) in.readObject();
        breed = (String) in.readObject();
        age = in.read();

    }//public void readExternal(ObjectInput in) throws IOException,
}//class Pet extends Animal implements Externalizable {

public class SerializationExample {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        String fileName = "Brandy.ser";

        Pet originalPet = new Pet("Brandy", "Dog");
        originalPet.age = 5;
        originalPet.weight = 30;
        Pet.count = 55;
        System.out.println("--------- Original State -----------");
        System.out.println(originalPet);

        // Use try with resources (automatically closes file) to output
        // the Pet object
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            // write the Pet to a file
            outputStream.writeObject(originalPet);
        }//try (ObjectOutputStream outputStream = new ObjectOutputStream(

        Pet deserializedPet = null;
        // Use try with resources (automatically closes file) to input
        // the Pet object
        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            try {
                // read the Pet from a file
                deserializedPet = (Pet) inStream.readObject();

                // Need to check for EOFException
            } catch (EOFException e) {//try {
                // Ignore, end of file
            }//catch (EOFException e) {
        }//try (ObjectInputStream inStream = new ObjectInputStream(

        System.out.println("------- Deserialized State ------");
        System.out.println(deserializedPet);

    }//public static void main(String[] args) throws IOException,
}//public class SerializationExample {
