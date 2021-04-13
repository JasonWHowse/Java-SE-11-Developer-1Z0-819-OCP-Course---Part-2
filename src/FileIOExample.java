/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Write data to a file using FileWriter
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FileIOExample {

    // This method uses a FileWriter to print 2500 random numbers
    private static void writeRandomNumbersToFile(String fileName)
            throws IOException {
        Random r = new Random();
        String numbersList;

        // Use try with resources to create output character stream, FileWriter
        // dumping a set of numbers to the file.
        try (FileWriter outputStream = new FileWriter(fileName)) {
            // Create 100 sets of random numbers
            for (char i = 0; i < 100; i++) {

                // Use random generator to create a set of 25 numbers between 1 and 100
                numbersList = r.ints(25, 1, 100)
                        // Map to string
                        .mapToObj((s) -> String.valueOf(s))
                        // Create a single string from all 25 numbers delimited by space
                        .reduce("", (string, element) -> String.join(" ", string, element));
                // Dump the string to the output file with a carriage return
                outputStream.write(numbersList + "\n");
            }//for (int i = 0; i < 100; i++) {
        }//try (FileWriter outputStream = new FileWriter(fileName)) {
    }//private static void writeRandomNumbersToFile(String fileName)

    // This method uses a DataInputStream to read 2500  numbers
    private static List<Integer> readRandomNumbersDataStream(String fileName)
            throws IOException {

        int fileInteger;
        List<Integer> numbers = new ArrayList<>();

        // Using DataInputStream, passing a BufferedInputStream wrapping
        // a FileInputStream.
        try (DataInputStream inStream = new DataInputStream(new
                BufferedInputStream(new FileInputStream(fileName)))) {
            try {
                while (true) {
                    // Note that you can use readInt
                    numbers.add(inStream.readInt());
                }//while (true) {
            } catch (EOFException e) {//try {
                // Ignore, end of file
            }//catch (EOFException e) {
        }//try (DataInputStream inStream = new DataInputStream(new
        System.out.println("Total number of numbers retrieved = " +
                numbers.size());
        return numbers;
    }//private static List<Integer> readRandomNumbersDataStream

    public static void main(String[] args) throws IOException {
        List<Integer> randomList =
                readRandomNumbersFromFile("characterData.txt");

//        writeRandomNumbersDataStream("binaryIOData.bin", randomList);
        List<Integer> dataList =
                readRandomNumbersDataStream("binaryIOData.bin");
        System.out.println("Are lists equal? " + randomList.equals(dataList));
    }//public static void main(String[] args) throws IOException {

    // This method uses a DataInputStream to write numbers in a list
    private static void writeRandomNumbersDataStream(String fileName,
                                                     List<Integer> list)
            throws IOException {

        // Use try with resources to create output character stream
        // dumping a set of numbers to the file.
        try (DataOutputStream outputStream =
                     new DataOutputStream(new BufferedOutputStream(
                             new FileOutputStream(fileName)))) {
            list.forEach((s) -> {
                try {
                    outputStream.writeInt(s);
                } catch (IOException e) {//try {
                    e.printStackTrace();
                }//catch (IOException e) {
            });
        }//try (DataOutputStream outputStream =
    }//private static void writeRandomNumbersDataStream(String fileName,

    // This method uses a FileReader wrapped in a BufferedReader
    private static List<Integer> readRandomNumbersFromFile(String fileName)
            throws IOException {

        List<Integer> numbers = new ArrayList<>();

        // Using BufferedReader wrapping a FileReader.  More efficient and provides
        // readLine method
        try (BufferedReader inStream =
                     new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line.
            while ((line = inStream.readLine()) != null) {
                // Split each line by white space and add numbers to a list
                Arrays.asList(line.split("\\s"))
                        .forEach((s) -> {
                            try {
                                numbers.add(Integer.parseInt(s));
                            } catch (Exception e) {//try {
                                // ignore junk;
                            }//catch (Exception e) {
                        });

            }//while ((line = inStream.readLine()) != null) {
        }
        System.out.println("Total number of numbers retrieved = " +
                numbers.size());
        return numbers;
    }//private static List<Integer> readRandomNumbersFromFile(String fileName)
}//public class FileIOExample {