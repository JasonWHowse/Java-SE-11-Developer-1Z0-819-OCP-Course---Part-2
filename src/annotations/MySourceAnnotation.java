/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotation retained only in source file
*/

package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotation with Source Retention Policy
@Retention(RetentionPolicy.SOURCE)
public @interface MySourceAnnotation {
}//public @interface MySourceAnnotation {