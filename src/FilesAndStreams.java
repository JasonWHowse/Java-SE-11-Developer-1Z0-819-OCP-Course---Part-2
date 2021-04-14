/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Files static methods that return Stream
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesAndStreams {
    public static void main(String[] args) {

        Path src = Paths.get("src");
        System.out.println("-----------------------------------");
        System.out.println("Listing of " + src + " Directory");
        System.out.println("-----------------------------------");

        // Need to wrap in try/resources or try/catch so that directory
        // is appropriately closed.
        try (Stream<Path> str = Files.list(src)) {
            str
                    .limit(5)  // Can use any stream operation 
                    .forEach(System.out::println);
        } catch (IOException io) {//try (Stream<Path> str = Files.list(src)) {
            System.out.println("Problem with listing " + io);
        }//catch (IOException io) {

        Path out = Paths.get("testA");
        System.out.println("-----------------------------------");
        System.out.println("Walk of " + out + " Directory");
        System.out.println("-----------------------------------");

        // Need to wrap in try/resources or try/catch so that directory
        // is appropriately closed
        try (Stream<Path> str = Files.walk(out)) {
            str
                    .limit(8) // Can use any stream operation
                    .forEach(System.out::println);
        } catch (IOException io) {//try (Stream<Path> str = Files.walk(out)) {
            System.out.println("Problem with walk " + io);
        }//catch (IOException io) {

        System.out.println("-----------------------------------");
        System.out.println("Breadth walk of " + out + " Directory");
        System.out.println("-----------------------------------");
        implementBreadthWalk(out);
    }//public static void main(String[] args)  {

    // Show example of breadth-first walk, vs depth-first.
    private static void implementBreadthWalk(Path p) {

        // List current level
        try (Stream<Path> str = Files.list(p)) {
            str
                    // Limiting so that output is easier to read
                    .limit(5)
                    .forEach(System.out::println);
        } catch (IOException io) {//try (Stream<Path> str = Files.list(p)) {
            System.out.println("Problem with listing " + io);
        }//catch (IOException io) {

        // For any directories, call current method recursively
        try (Stream<Path> str = Files.walk(p, 1)) {
            str
                    // Do not want to list current path
                    .filter(s -> !s.equals(p))
                    // Find all directories at current level
                    .filter((s) -> Files.isDirectory(s))
                    // Recursively call current method
                    .forEach((s) -> FilesAndStreams.implementBreadthWalk(s));
        } catch (IOException io) {//try (Stream<Path> str = Files.walk(p, 1)) {
            System.out.println("Problem with listing " + io);
        }//catch (IOException io) {
    }//private static void implementBreadthWalk(Path p) {
}//public class FilesAndStreams {