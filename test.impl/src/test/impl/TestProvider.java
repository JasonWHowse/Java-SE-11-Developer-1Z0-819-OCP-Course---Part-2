/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service extras
*/

package test.impl;

// Class implements the TestService interface
public class TestProvider implements test.spi.TestService {

    // Overrides method on the Service, TestService
    public void provideTheService() {
        System.out.println("TestProvider");
    }//public void provideTheService() {
}//public class TestProvider implements test.spi.TestService {