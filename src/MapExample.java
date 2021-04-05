/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Map: HashMap, TreeMap, LinkedHashMap
*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        // Create three maps with String keys and Integer values.
        Map<String, Integer> h = new HashMap<>();
        Map<String, Integer> t = new TreeMap<>();
        Map<String, Integer> l = new LinkedHashMap<>();

        String[] names = new String[]{"Barry",
                "George", "Harold", "Ida", "John"};

        // Fill the map with some data, using put.
        for (int i = 0; i < names.length; i++) {
            h.put(names[i], (i + 1));
            t.put(names[i], (i + 1));
            l.put(names[i], (i + 1));
        }//for (int i = 0; i < names.length; i++) {

        // Test if null keys and null values are allowed
        Map<String, Integer> currentMap;
        for (int i = 0; i < 3; i++) {
            if (i == 0) currentMap = l;
            else if (i == 1) currentMap = h;
            else currentMap = t;
            try {
                // Insert map entry with a null value
                currentMap.put("NullValue", null);

                // Insert map entry with a null key
                currentMap.put(null, 12);

            } catch (Exception e) {//try {
                System.out.println(currentMap.getClass().toGenericString() +
                        " does not support null keys");
                System.out.println(e.toString());

            }//catch (Exception e) {
        }//for (int i = 0; i < 3; i++) {

        // Print out data, the entire set, then each element of set.
        System.out.println("--- HashMap: " + h);
        h.entrySet().forEach((s) ->
                System.out.println(s.getClass().getName() + " : " + s));

        // Print out data, the entire set, then each element of set.
        System.out.println("--- TreeMap: " + t);
        t.entrySet().forEach((s) ->
                System.out.println(s.getClass().getName() + " : " + s));

        // Print out data, the entire set, then each element of set.
        System.out.println("--- LinkedHashMap: " + l);
        l.entrySet().forEach((s) ->
                System.out.println(s.getClass().getName() + " : " + s));

        System.out.println("\n---- LinkedHashMap: do Simple Stuff -------");
        doSimpleMapStuff(l);

        System.out.println("\n--- LinkedHashMap: test compute methods ---");
        // Simplify map
        l.remove("NullValue");
        l.remove(null);
        l.remove("Maggie");
        testComputes(l);
    }//public static void main(String[] args) {

    private static void doSimpleMapStuff(Map<String, Integer> m) {
        System.out.println("The value of m.get(Jane)) = "
                + m.get("Jane") + " : " + m);
        System.out.println("The value of m.get(John)) = "
                + m.get("John") + " : " + m);

        // Does map exist?
        System.out.println("Map contains a key 'Barry'?: " +
                m.containsKey("Barry") + " : " + m);
        // Does value exist
        System.out.println("Map contains a value '7'?: " +
                m.containsValue(7) + " : " + m);

        // Replacing values - Always replaces value for NullValue to 77
        System.out.println("m.replace(NullValue, 77): " +
                m.replace("NullValue", 77) + " : " + m);

        // Replaces value in Barry to 10 if current value is 1,
        // returns true
        System.out.println("m.replace(Barry, 1, 10): " +
                m.replace("Barry", 1, 10) + " : " + m);

        // Replaces value in Barry to 11 if current value is 7,
        // returns false because value in Barry is not 7
        System.out.println("m.replace(Barry, 7, 11): " +
                m.replace("Barry", 7, 11) + " : " + m);

        // Simple removal by key
        System.out.println("remove(Ida): " + m.remove("Ida")
                + " : " + m);

        // Conditional removal by key if value matches second argument
        System.out.println("remove(Harold, 10) : " + m.remove("Harold", 10)
                + " : " + m);

        // Conditional removal by key if value matches second argument
        System.out.println("remove(Harold, 3) : " + m.remove("Harold", 3)
                + " : " + m);

        // putIfAbsent adds Key/Value if key doesn't exist
        System.out.println("putIfAbsent(Harold, 8) : " +
                m.putIfAbsent("Harold", 8) + " : " + m);

        // put always updates the Harold value
        System.out.println("put(Harold, 100) : " +
                m.put("Harold", 100) + " : " + m);

        // putIfAbsent will not update Harold if it exists
        System.out.println("putIfAbsent(Harold, 200) : " +
                m.putIfAbsent("Harold", 200) + " : " + m);

        // putIfAbsent will insert Maggie with value of 200
        System.out.println("putIfAbsent(Maggie, 200) : " +
                m.putIfAbsent("Maggie", 200) + " : " + m);
    }//private static void doSimpleMapStuff(Map<String, Integer> m) {


    private static void testComputes(Map<String, Integer> m) {
        System.out.println("Original State: " + m);
        // If John exist and value is not null, apply function
        m.compute("John", (key, val) -> (val == null) ? 0 : val * 100);
        System.out.println("compute(John, val*100): " + m);

        try {
            //Ilene does not exist
            m.compute("Ilene", (key, val) -> (val == null) ? 0 : val * 100);
            System.out.println(m);
        } catch (Exception e) {//try {
            System.out.println("Using compute(Ilene) threw error: " + e);
        }//catch (Exception e) {

        try {
            m.put("John", null);
            System.out.println("Set value in John to null: " + m);
            // If value in John entry is null, NullPointer Exception thrown.
            m.compute("John", (key, val) -> (val == null) ? 0 : val * 100);
            System.out.println(m);
        } catch (Exception e) {//try {
            System.out.println("Using compute(John) where John exist " +
                    " but has a null value threw error: " + e);
        }//catch (Exception e) {

        // You can use following methods without try catch...
        int defaultVal = 30;

        // Mary will get added with value result of computation
        System.out.println("Mary gets added with value = " +
                m.computeIfAbsent("Mary", (val) -> defaultVal * 3));
        System.out.println("m.computeIfAbsent(Mary, (30) * 3): " + m);

        // Mary exists, no computation made, value left unchanged
        System.out.println("Mary value is unchanged = " +
                m.computeIfAbsent("Mary", (val) -> defaultVal * 3));
        System.out.println("m.computeIfAbsent(Mary, (30) * 3): " + m);

        // Mary exists, computation made and value updated
        System.out.println("Mary gets updated using computeIfPresent" +
                " with value = " +
                m.computeIfPresent(
                        "Mary", (key, val) -> val * 3));
        System.out.println("m.computeIfPresent(Mary, (val) * 3): " + m);

        // Ralph does not exist, and does not get added.
        System.out.println("Ralph does not exist, computeIfPresent " +
                " does nothing = " +
                m.computeIfPresent(
                        "Ralph", (key, val) -> {
                            System.out.println("code is executed");
                            return val * 3;

                        }));
        System.out.println("m.computeIfPresent(Ralph, (val) * 3): " + m);

    }//private static void testComputes(Map<String, Integer> m) {
}//public class MapExample {