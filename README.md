# POC: Generate method bodies from their base64 encoded names.

For example:
Given an interface
```java
package dev.vrba.bullshit;

/**
 * As = is not a valid Java identifier, use _ instead as the padding character
 */
public interface ExampleInterface {
    /**
     * base64(System.out.println("Hello base64"));
     */
    void U3lzdGVtLm91dC5wcmludGxuKCJIZWxsbyBiYXNlNjQiKTs_();

    /**
     * base64(return arg0 + arg1);
     */
    int cmV0dXJuIGFyZzAgKyBhcmcxOw__(int arg0, int arg1);
}
```

you can automatically generate its implementation, where all method bodies are generated
from the method name. It even can handle arguments and returning the value.

```java
package dev.vrba.bullshit;


class Program {
    public static void main(String[] args) {
        ExampleInterface implementation = Base64ImplementationCreator.makeImplementation(ExampleInterface.class);

        // Hello world
        implementation.U3lzdGVtLm91dC5wcmludGxuKCJIZWxsbyBiYXNlNjQiKTs_();

        // 1 + 2 = 3
        int three = implementation.cmV0dXJuIGFyZzAgKyBhcmcxOw__(1, 2);

        System.out.println("1 + 2 = " + three);
    }
}
```

That's it, so much wasted time on this :poop: