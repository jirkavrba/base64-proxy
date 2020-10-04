package dev.vrba.bullshit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Base64;

public class Base64ImplementationCreator {

    private static class Base64InvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object o, Method method, Object[] arguments) throws Throwable {
            String base64 = method.getName().replaceAll("_", "=");
            String body = new String(Base64.getDecoder().decode(base64));

            // TODO: Implement a String JVM "compiler"
            System.out.println("Evaluation of: " + body);

            //noinspection SuspiciousInvocationHandlerImplementation
            return null;
        }
    }

    public static <T> T makeImplementation(Class<T> target) {
        //noinspection unchecked
        return (T) Proxy.newProxyInstance(
                Base64ImplementationCreator.class.getClassLoader(),
                new Class[] { target },
                new Base64InvocationHandler()
        );
    }
}
