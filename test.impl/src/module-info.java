module test.impl {
    requires test.spi;
    exports test.impl;
    provides test.spi.TestService with test.impl.TestProviderTwo;
}