package by.it.protsko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> beanClassStructure = Bean.class;
        Object object = null;
        Method[] beanClassMethods = beanClassStructure.getDeclaredMethods();

        for (Method beanClassMethod : beanClassMethods) {
            if (beanClassMethod.isAnnotationPresent(Param.class)) {
                Param classAnnotation = beanClassMethod.getDeclaredAnnotation(Param.class);
                if (object == null) {
                    object = beanClassStructure.newInstance();
                }

                System.out.println("@" + classAnnotation.annotationType().getSimpleName());
                System.out.println(getModyfierType(beanClassMethod.getModifiers())
                        + beanClassMethod.getReturnType()
                        + " "
                        + beanClassMethod.getName()
                        + "("
                        + getParametersType(beanClassMethod.getParameters())
                        + ") :" + beanClassMethod.invoke(object, classAnnotation.a(), classAnnotation.b()));
            }
        }
    }

    private static String getModyfierType(int typeDigit) {
        StringBuilder modifierType = new StringBuilder();
        if (Modifier.isPublic(typeDigit)) modifierType.append("public ");
        if (Modifier.isPrivate(typeDigit)) modifierType.append("private ");
        if (Modifier.isAbstract(typeDigit)) modifierType.append("abstract ");
        if (Modifier.isStatic(typeDigit)) modifierType.append("static ");
        if (Modifier.isFinal(typeDigit)) modifierType.append("final ");
        return modifierType.toString();
    }

    private static String getParametersType(Parameter[] parameters) {
        StringBuilder parametersType = new StringBuilder();
        int count = 0;
        for (Parameter parameter : parameters) {
            count++;
            if (count > 1) {
                parametersType.append(",").append(parameter.getType());
            } else {
                parametersType.append(parameter.getType());
            }
        }
        return parametersType.toString();
    }
}
