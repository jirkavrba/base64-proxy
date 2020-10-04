package dev.vrba.bullshit;

public class Base64Implement {

    public static void main(String[] args) {
        ExampleInterface implementation =
                Base64ImplementationCreator
                            .makeImplementation(ExampleInterface.class);

        // Hello world
        implementation.U3lzdGVtLm91dC5wcmludGxuKCJIZWxsbyBiYXNlNjQiKTs_();
    }
}
