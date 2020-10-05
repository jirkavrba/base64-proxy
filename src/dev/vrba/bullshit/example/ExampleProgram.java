package dev.vrba.bullshit.example;

import dev.vrba.bullshit.Base64ImplementationCreator;

public class ExampleProgram {

    public static void main(String[] args) {
        ExampleInterface implementation = Base64ImplementationCreator.makeImplementation(ExampleInterface.class);

        // Hello world
        implementation.U3lzdGVtLm91dC5wcmludGxuKCJIZWxsbyBiYXNlNjQiKTs_();

        // 1 + 2 = 3
        int three = implementation.cmV0dXJuIGFyZzAgKyBhcmcxOw__(1, 2);

        System.out.println("1 + 2 = " + three);

        int factorialOfFive = implementation.aWYgKGFyZzAgPD0gMCkgcmV0dXJuIDE7IAplbHNlIHJldHVybiBhcmcwICogX19zZWxmX18oYXJnMCAtIDEpOw__(5);

        System.out.println("5! = " + factorialOfFive);

        int fifthFibonacciNumber = implementation.aWYgKGFyZzAgPD0gMSkgcmV0dXJuIGFyZzA7IApyZXR1cm4gX19zZWxmX18oYXJnMCAtIDEpICsgX19zZWxmX18oYXJnMCAtIDIpOw__(5);

        System.out.println("fib(5) = " + fifthFibonacciNumber);
    }
}
