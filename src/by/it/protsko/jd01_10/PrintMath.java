package by.it.protsko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClassStructure = Math.class;
        Field[] fields = mathClassStructure.getDeclaredFields();
        Method[] methods = mathClassStructure.getDeclaredMethods();

        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.println(getModyfierType(field.getModifiers()) + field.getType() + " " + field.getName());
            }
        }

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println(getModyfierType(method.getModifiers()) + method.getReturnType() + " " + method.getName() + "(" + getParametersType(method.getParameters()) + ")");
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