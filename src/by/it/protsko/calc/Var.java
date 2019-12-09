package by.it.protsko.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) {
        System.out.printf("Сложение %s + %s невозможно\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Вычитание %s - %s невозможно\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Умножение %s * %s невозможно\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Деление %s / %s невозможно\n", this, other);
        return null;
    }

    static void set(String name, Var var) {
        vars.put(name, var);
    }

    static Map<String, Var> sortVar(Map<String, Var> vars) {
        return new TreeMap<>(vars);
    }

    static Var createVar(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else {
            if (stringVar.matches(Patterns.VECTOR)) {
                return new Vector(stringVar);
            } else {
                if (stringVar.matches(Patterns.MATRIX)) {
                    return new Matrix(stringVar);
                } else {
                    if (vars.containsKey(stringVar)) {
                        return vars.get(stringVar);
                    }
                }
            }
        }
        return null;
    }
}
