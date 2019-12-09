package by.it.protsko.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Сложение %s + %s невозможно\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Вычитание %s - %s невозможно\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Умножение %s * %s невозможно\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Деление %s / %s невозможно\n", this, other));
    }

    static void set(String name, Var var) {
        vars.put(name, var);
    }

    static Map<String, Var> sortVar(Map<String, Var> vars) {
        return new TreeMap<>(vars);
    }

    static Var createVar(String stringVar) throws CalcException {
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
        throw new CalcException("Var didn't create");
    }
}
