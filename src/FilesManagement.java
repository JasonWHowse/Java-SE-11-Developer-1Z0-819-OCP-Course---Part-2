/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Using Files to create, read from, write to, and delete files.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesManagement {
    public static void main(String[] args) {

        // Create a path to a file in current working directory;
        // This file was created in example above
        Path testFile = Path.of("TestingFile.txt");
        try {
            // Use Files.readAllLines to open a file, read all lines
            // and close the file.
            System.out.println("Read each line of a file");
            List<String> fileLines = Files.readAllLines(testFile);
            fileLines.forEach(System.out::println);

            // Use Files.readAllBytes to open a file, read all data
            // and close the file.
            System.out.println("Read entire file into byte array");
            byte[] byteArray = Files.readAllBytes(testFile);
            System.out.println(new String(byteArray));

            // Use first line of previous file to create a new file
            Path byteFile = Path.of(fileLines.get(0).split("\\s")[1] + ".txt");

            System.out.println("Creating " + byteFile);
            // Write bytes to this file, creating a new file each time.

            try {
                // Exception occurs if file already exists
                Files.write(byteFile, "Secret sauce".getBytes(),
                        StandardOpenOption.CREATE_NEW);
            } catch (IOException e) {//try {
                System.out.println(e);
                Files.write(byteFile, "Secret sauce".getBytes(),
                        StandardOpenOption.CREATE);

            }//catch (IOException e) {

            Path byteFile2 = Path.of(fileLines.get(1).split("\\s")[1] + ".txt");

            // Write a String to file, but do not append it
            Files.writeString(byteFile2, "Secret Ingredient OneTwoThree\n",
                    StandardOpenOption.WRITE);

            // Write a String to file, appending it
            Files.writeString(byteFile2, "Secret Ingredient One\n",
                    StandardOpenOption.APPEND);

            System.out.println("Appending to " + byteFile2);
            Files.writeString(byteFile2, "Secret Ingredient Two\n",
                    StandardOpenOption.APPEND);

        } catch (IOException io) {//try {
            System.out.println(io);
        }//catch (IOException io) {
    }//public static void main(String[] args) {
}//public class FilesManagement {