package by.it.protsko.calc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    static void saveCalcVariable(){
        try (PrintWriter writer = new PrintWriter(getFileName())) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                writer.printf("%s=%s\n", entry.getKey(), entry.getValue().toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file");
        }
    }


    static void loadCalcVariable() {
        try {
            Parser parser = new Parser();
            for (String line : Files.lines(Paths.get(getFileName()))
                    .collect(Collectors.toList())
            ) {
                parser.calc(line);

            }
        } catch (IOException | CalcException e) {
            System.out.println("Error reading file");
        }

    }

    private static String getFileName() {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                Var.class
                        .getName()
                        .replace(Var.class.getSimpleName(), "")
                        .replace(".", File.separator) + "varsValue.txt";
    }
}
