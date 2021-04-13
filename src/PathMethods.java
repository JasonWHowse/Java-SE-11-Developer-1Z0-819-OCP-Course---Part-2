/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Path Manipulation methods
*/

import java.nio.file.Path;

public class PathMethods {
    public static void main(String[] args) {
        // Testing Path.normalize() method
        testNormalize();
    }//public static void main(String[] args) {

    // Normalizing a path, simplifies it.
    public static void testNormalize() {

        System.out.println("--- Results for the normalize() method ---");
        // Directory Structure shown below, -- represents a level
        // ---------------------
        // LearningAcademyOrg
        // -- ParallelStreams
        // -- IOProject
        // -- -- out
        // -- -- -- production
        // -- -- src
        Path p = Path.of("IOProject/../ParallelStreams");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("out/production/IOProject/../../../src/.");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("LearningAcademyOrg/IOProject/src/../../../.");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("/a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

    }//public static void testNormalize() {
}//public class PathMethods {