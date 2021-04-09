/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Using the Optional Class
*/

import java.util.List;
import java.util.Optional;

// Create a CollegeStudent with a name & gpa
class CollegeStudent {

    private Optional<Float> gpa = Optional.empty();

    private String name;

    // Constructor
    CollegeStudent(String name) {
        this.name = name;
    }//CollegeStudent(String name) {

    CollegeStudent(String name, float gpa) {
        this.name = name;
        this.gpa = Optional.of(gpa);
    }//CollegeStudent(String name, float gpa) {

    public Optional<Float> getGpa() {
        return gpa;
    }//public Float getGpa() {

    public void setGpa(Float gpa) {
        this.gpa = Optional.ofNullable(gpa);
    }//public void setGpa(Float gpa) {

    public String getName() {
        return name;
    }//public String getName() {

}//class CollegeStudent {

// Class to Test retrieving Gpa
public class OptionalTests {
    public static void main(String[] args) {
        CollegeStudent joe = new CollegeStudent("Joe", 3.2f);
        CollegeStudent jane = new CollegeStudent("Jane");

//        List.of(joe, jane)
//                .stream()
//                .forEach(OptionalTests::printStatus);
//
//        List.of(joe, jane)
//                .stream()
//                .forEach(s -> System.out.println(s.getName() +
//                        (s.getGpa()
//                                .or(() -> {
//                                    System.out.println(
//                                            "In Supplier Code for "+ s.getName());
//                                    return Optional.of(2.0f);
//                                })
//                                .get() >= 2.0f
//                                ? " in good standing" :
//                                " on academic probation")));
        List.of(joe, jane)
                .stream()
                .forEach(s -> System.out.println(s.getName() +
                        (s.getGpa()
//                                .orElseThrow()
                                .orElseGet(OptionalTests::getGpaEstimate)
                                >= 2.0f
                                ? " in good standing" :
                                " on academic probation")));


        System.out.println("Joe's gpa = " + joe.getGpa());
        System.out.println("Jane's gpa = " + jane.getGpa());

    }//public static void main(String[] args) {

    // Print's student's academic status

    private static void printStatus(CollegeStudent student) {
        System.out.print(student.getName());
        Optional<Float> gpa;
        if ((gpa = student.getGpa()).isPresent()) {
            if (gpa.get() < 2.0) {
                System.out.println(" is on academic probation");
            } else {//if (gpa.get() < 2.0) {
                System.out.println(" is in good standing");
            }//else {
        } //if ((gpa = student.getGpa()).isPresent()) {
        else System.out.println(" has an unknown gpa");
    }//private static void printStatus(CollegeStudent student) {

    private static float getGpaEstimate() {
        System.out.println("--- in getGpaEstimate method");
        return 2.0f;
    }//private static float getGpaEstimate() {

}//public class OptionalTests {