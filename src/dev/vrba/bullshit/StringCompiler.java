package dev.vrba.bullshit;

import org.joor.Reflect;

import java.lang.reflect.Parameter;
import java.util.Arrays;

public class StringCompiler<T, R> {
    private final Class<T> targetClass;
    private final String returnType;
    private final String sourceCode;
    private final Parameter[] parameters;

    protected StringCompiler(final Class<T> targetClass, final Class<R> returnType, final Parameter[] parameters, final String sourceCode) {
        this.targetClass = targetClass;
        this.parameters = parameters;
        this.sourceCode = sourceCode;
        this.returnType = returnType.getName();
    }

    private String buildSourceCode() {
        final String parameters = String.join(
                ", ",
                Arrays.stream(this.parameters)
                        .map(parameter -> parameter.getType().getName() + " " + parameter.getName())
                        .toArray(String[]::new)
        );

        final String sourceCode = this.sourceCode.replaceAll("__self__", "magic");

        return "package " + this.targetClass.getPackage().getName() + ";\n\n" +
               "public class " + this.targetClass.getSimpleName() + "_base64 {\n" +
                   "\tpublic static " + this.returnType + " magic(" + parameters + ") {\n" +
                       "\t\t" + sourceCode + "\n" +
                   "\t}\n" +
               "}\n";
    }

    public R evaluate(Object ...arguments) throws Throwable {

        final Reflect reflection = Reflect.compile(this.targetClass.getName() + "_base64", this.buildSourceCode()).create();

        // Otherwise the call would be interpreted as an empty array
        if (arguments.length == 0) {
            return reflection.call("magic").get();
        }

        return reflection.call("magic", arguments).get();
    }
}
