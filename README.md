![forthebadge](https://forthebadge.com/images/badges/ages-18.svg)
![forthebadge](https://forthebadge.com/images/badges/contains-tasty-spaghetti-code.svg)
![forthebadge](https://forthebadge.com/images/badges/designed-in-ms-paint.svg)
![forthebadge](https://forthebadge.com/images/badges/it-works-why.svg)
![forthebadge](https://forthebadge.com/images/badges/its-not-a-lie-if-you-believe-it.svg)
![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)
![forthebadge](https://forthebadge.com/images/badges/powered-by-black-magic.svg)
![forthebadge](https://forthebadge.com/images/badges/you-didnt-ask-for-this.svg)

# POC: Generate method bodies from their base64 encoded names.
![Noooooooo! You cannot define method bodies as their names, that's illegal. Haha, base64 goes brrrrr](https://imgur.com/388km9d.png)

For example,
given an interface like this:
```java
package dev.vrba.bullshit.example;

/**
 * As = is not a valid Java identifier, use _ instead for padding
 */
public interface ExampleInterface {
    /**
     * System.out.println("Hello base64");
     */
    void U3lzdGVtLm91dC5wcmludGxuKCJIZWxsbyBiYXNlNjQiKTs_();

    /**
     * return arg0 + arg1;
     */
    int cmV0dXJuIGFyZzAgKyBhcmcxOw__(int arg0, int arg1);

    /**
     * Factorial goes brrrr
     *
     * if (arg0 <= 0) return 1;
     * else return arg0 * __self__(arg0 - 1);
     */
    int aWYgKGFyZzAgPD0gMCkgcmV0dXJuIDE7IAplbHNlIHJldHVybiBhcmcwICogX19zZWxmX18oYXJnMCAtIDEpOw__(int arg0);

    /**
     * Fibonacci
     *
     * if (arg0 <= 1) return arg0;
     * return __self__(arg0 - 1) + __self__(arg0 - 2);
     */
    int aWYgKGFyZzAgPD0gMSkgcmV0dXJuIGFyZzA7IApyZXR1cm4gX19zZWxmX18oYXJnMCAtIDEpICsgX19zZWxmX18oYXJnMCAtIDIpOw__(int arg0);
}
```

you can automatically generate its implementation, where all method bodies are generated
from the method name. 
All you need to do is give the `Base64ImplementationCreator` a class name (usign the `.class` or `.getClass()`), and reflection goes brrrr.
It even can handle arguments and returning the value.

```java
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

        // 5!
        int factorialOfFive = implementation.aWYgKGFyZzAgPD0gMCkgcmV0dXJuIDE7IAplbHNlIHJldHVybiBhcmcwICogX19zZWxmX18oYXJnMCAtIDEpOw__(5);

        System.out.println("5! = " + factorialOfFive);

        // fib(5)
        int fifthFibonacciNumber = implementation.aWYgKGFyZzAgPD0gMSkgcmV0dXJuIGFyZzA7IApyZXR1cm4gX19zZWxmX18oYXJnMCAtIDEpICsgX19zZWxmX18oYXJnMCAtIDIpOw__(5);

        System.out.println("fib(5) = " + fifthFibonacciNumber);
    }
}
```

For recursive methods use `__self__` or `magic` :crystal_ball: to reference the generated method.

That's it, so much wasted time on this :poop:
