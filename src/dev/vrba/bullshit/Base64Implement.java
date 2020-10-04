package dev.vrba.bullshit;

public class Base64Implement {

    public static void main(String[] args) {
        ExampleInterface implementation = Base64ImplementationCreator.makeImplementation(ExampleInterface.class);

        // Hello world
        implementation.U3lzdGVtLm91dC5wcmludGxuKCJIZWxsbyBiYXNlNjQiKTs_();

        // 1 + 2 = 3
        int three = implementation.cmV0dXJuIGFyZzAgKyBhcmcxOw__(1, 2);

        System.out.println("1 + 2 = " + three);

        int factorialOfFive = implementation.aWYgKGFyZzAgPD0gMCkgcmV0dXJuIDE7IAplbHNlIHJldHVybiBhcmcwICogX19zZWxmX18oYXJnMCAtIDEpOw__(5);

        System.out.println("5! = " + factorialOfFive);
    }
}
