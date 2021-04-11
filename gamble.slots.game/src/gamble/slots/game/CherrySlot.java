package gamble.slots.game;

import gamble.slots.spi.PayOffService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

// The application that will use the provider to provide
// 'winnings' for a player, whatever the winnings might be
public class CherrySlot {
    public static void main(String[] args) {
        // Mock playing the game.
        new CherrySlot().playGame();

    }//public static void main(String[] args) {

    // Method searches for providers, returns last one loaded if any
    // have been loaded.  forEach implicitly uses iterator on ServiceLoader
    private PayOffService getService() {
        List<PayOffService> providers = new ArrayList<>();
        ServiceLoader.load(PayOffService.class).forEach(providers::add);
        if (providers.size() > 0) {
            return providers.get(providers.size() - 1);
        }//if (providers.size() > 0) {
        return null;
    }//private PayOffService getService() {

    // Method that plays the game and provides winnings
    private void playGame() {

        PayOffService p = getService();
        if (p == null) System.out.println("Provider not found");
        else {
            System.out.println("Congratulations:  You're a winner!");
            p.threeInRow(PayOffService.SlotType.GOLDBAR_ONE);
        }//else {

    }//private void playGame() {
}//public class CherrySlot {