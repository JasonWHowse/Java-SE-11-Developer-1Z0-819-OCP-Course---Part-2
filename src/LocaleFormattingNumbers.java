/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16: Localization
Topic:  Formatting Numbers
*/

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocaleFormattingNumbers {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(new Locale("en", "AU"));
        System.out.println("----------- STANDARD FORMATS ------------");
        testNumberFormats(Locale.FRANCE);
    }//public static void main(String[] args) throws ParseException {

    public static void testNumberFormats(Locale l) {
        double d = 10.55;

        String outpattern = "{0}({1}) : {3}  -  {0}({2}) : {4} ";

        // Using getInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getInstance.format",   // {0} - Text, method executed
                Locale.getDefault(),    // {1} - default Locale String
                l,                      // {2} - passed Locale String
                NumberFormat.getInstance().format(d), // {3} number (default Locale)
                NumberFormat.getInstance(l).format(d) // {4} number (passed Locale)
        ));

        // Using getNumberInstance() with and without passing a Locale, 
        // same result as using getInstance()
        System.out.println(MessageFormat.format(outpattern,
                "getNumberInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getNumberInstance().format(d),
                NumberFormat.getNumberInstance(l).format(d)
        ));

        // Using getCurrencyInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getCurrencyInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getCurrencyInstance().format(d),
                NumberFormat.getCurrencyInstance(l).format(d)));

        // Using getIntegerInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getIntegerInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getIntegerInstance().format(d),
                NumberFormat.getIntegerInstance(l).format(d)));

        // Using getPercentInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getPercentInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getPercentInstance().format(d),
                NumberFormat.getPercentInstance(l).format(d)));

    }//public static void testNumberFormats(Locale l) {
}//public class LocaleFormattingNumbers {