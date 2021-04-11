/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Describing Service Components, Additional Provider using
        public no args constructor
*/

package njvirtual.slots.impl;

import gamble.slots.spi.PayOffService;

// This provider implements the PayOffService with different prizes
public class ACPayOffService implements PayOffService {

    // This class has a public no args constructor, and does
    // not declare a static provider method.
    public ACPayOffService() {
        System.out.println("Atlantic City PayOffService loaded");
    }//public ACPayOffService() {

    public void hitTheJackPot() {
        System.out.println("Voucher for free week at Caeser's");
    }//public void hitTheJackPot() {

    public void threeInRow(SlotType s) {
        System.out.println("Voucher for Free Show at Atlantis");
    }//public void threeInRow(SlotType s) {

    public void twoInRow(SlotType s) {
        System.out.println("Voucher for 50 Trump tokens");
    }//public void twoInRow(SlotType s) {
}//public class ACPayOffService implements PayOffService {