module test.impl {
    requires test.spi;
    provides test.spi.TestService with
            test.impl.TestProviderFactory;
}