package dev.vrba.bullshit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Base64ImplementationCreator {

    private static class Base64InvocationHandler implements InvocationHandler {

        private final Class<?> targetClass;

        public Base64InvocationHandler(Class<?> targetClass) {
            this.targetClass = targetClass;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] arguments) throws Throwable {
            String base64 = method.getName().replaceAll("_", "=");
            String body = new String(Base64.getDecoder().decode(base64));

            Parameter[] parameters = method.getParameters();

            if (arguments == null) {
                arguments = new Object[0];
            }

            //noinspection unchecked
            return new StringCompiler(
                    targetClass,
                    method.getReturnType(),
                    parameters,
                    body
            ).evaluate(arguments);
        }
    }

    public static <T> T makeImplementation(final Class<T> target) {
        //noinspection unchecked
        return (T) Proxy.newProxyInstance(
                Base64ImplementationCreator.class.getClassLoader(),
                new Class[] { target },
                new Base64InvocationHandler(target)
        );
    }
}
