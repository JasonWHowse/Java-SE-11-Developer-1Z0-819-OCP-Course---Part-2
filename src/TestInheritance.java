/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Class, Extras
*/

public class TestInheritance extends OuterMost {
    public static void main(String[] args) {
        new TestInheritance().testInnerClassMembers();

        // Static method - no instance of current class so
        // cannot access the inner classes directly
    }//public static void main(String[] args) {

    private void testInnerClassMembers() {
        // non-static method - instance of current class exists so inner
        // classes (with the right access modifiers) are available...
        new ProtectedInner();
        // First Level
        new PublicInner();

        this.new ProtectedInner();
        // First Level
        this.new PublicInner();

        // Second Level
        new PublicInner().new NestedInnerSecondLevel();

        // Customized Second Level
        new KeepExtending();
    }//private void testInnerClassMembers() {

    // This inner class extends the inner class that was inherited
    // from the OuterMost class
    class KeepExtending extends OuterMost.PublicInner {
        KeepExtending() {
            System.out.println("Extend the inner class as an " +
                    "inherited member");
        }//KeepExtending() {

        class ExtendingFurther extends
                OuterMost.PublicInner.NestedInnerSecondLevel {
            ExtendingFurther() {
                System.out.println("Extending a deeper level of " +
                        "an inherited member");
            }//ExtendingFurther() {
        }//class ExtendingFurther extends
    }//class KeepExtending extends OuterMost.PublicInner {
}//public class TestInheritance extends OuterMost {