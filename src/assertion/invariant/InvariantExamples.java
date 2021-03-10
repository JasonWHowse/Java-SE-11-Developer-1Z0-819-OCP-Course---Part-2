/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Exception Handling and Assertions
Topic:  Using assertions
*/

package assertion.invariant;

import java.util.ArrayList;
import java.util.Arrays;

public class InvariantExamples {

    // 4 pet types supported
    private enum PetType {
        DOG, CAT, HAMSTER, GERBIL, PARROT
    }//private enum PetType {

    public static void main(String[] args) {
        InvariantExamples ex = new InvariantExamples();
        // Print formulary for each pet type
        for (PetType pt : PetType.values()) {
            // Check baby animal description...
            System.out.println("A juvenile " + pt + " is called a " +
                    ex.getPetTypeAgeDescription(pt, 0));
        }//for (PetType pt : PetType.values()) {
    }//public static void main(String[] args) {

    //  Method demonstrates assertion for a Control-Flow invariant
    private String getPetTypeDietaryNeeds(PetType petType) {

        switch (petType) {
            case DOG:
                return "Some formulary for dog";
            case CAT:
                return "Some formulary for cat";
            case HAMSTER:
                return "Some formulary for hamster";
            case GERBIL:
                return "Some formulary for gerbil";
            default:
                // --- Control-Flow invariant assertion ----
                // Assumption: code not reachable, all types referenced above
                assert false : "Formulary does not exist for " + petType;
        }//switch (petType) {
        return null;

    }//private String getPetTypeDietaryNeeds(PetType petType) {

    // Examples of pre and post condition invariants and internal invariant
    public String getPetTypeAgeDescription(PetType petType, int petAge) {
        // public methods should include tests for validity of data  passed
        if (petAge < 0) throw new IllegalArgumentException("Age cannot be negative");

        // **Bad Practice: Assertion to check validity of public method parameters
        assert petAge >= 0;

        String description = "ADULT";

        if (petType == PetType.CAT || petType == PetType.DOG) {
            if (petAge > 7) description = "SENIOR";
            else if (petAge < 1)
                description = (petType == PetType.CAT) ? "KITTEN" : "PUPPY";
        }//if (petType == PetType.CAT || petType == PetType.DOG) {
        // Add else if section for PARROT
        else if (petType == PetType.PARROT) {
            if (petAge > 45) description = "SENIOR";
            else if (petAge < 1) description = "CHICK";
        }//else if (petType == PetType.PARROT) {
        // Catch all for everything else
        else {
            // ** Internal Invariant Assertion
            // Assumes if pet not CAT/DOG, must be GERBIL/HAMSTER
            assert (petType == PetType.GERBIL || petType == PetType.HAMSTER);

            if (petAge > 3) description = "SENIOR";
            else if (petAge < 1)
                description = "PUP";
        }//else {

        // ** Good Practice:  Post-Condition Assertion
        assert (new ArrayList(Arrays.asList(
                new String[]{"ADULT", "SENIOR", "KITTEN", "PUPPY", "PUP"})).
                indexOf(description) > -1) : "No Description exists for " +
                petType + " age " + petAge;
        return description;
    }//public String getPetTypeAgeDescription(PetType petType, int petAge) {
}//public class InvariantExamples {