package by.it.protsko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) {

        String[] membersOfExpression = expression.replaceAll(" ", "").split(Patterns.OPERATIONS);
        if (membersOfExpression.length == 1) {
            return Var.createVar(expression);
        }
        if (expression.contains("=")) {
            Var rightPartExpression = Var.createVar(membersOfExpression[1]);
            Var.set(membersOfExpression[0], rightPartExpression);
            return rightPartExpression;
        }

        Var[] variables = new Var[membersOfExpression.length];
        for (int i = 0; i < membersOfExpression.length; i++) {
            variables[i] = Var.createVar(membersOfExpression[i]);
        }
        Matcher matcher = Pattern.compile(Patterns.OPERATIONS).matcher(expression);
        int count = 0;
        if (matcher.find()) {
            count++;
            String operation = matcher.group().trim();
            switch (operation) {
                case "+":
                    return variables[count - 1].add(variables[count]);
                case "-":
                    return variables[count - 1].sub(variables[count]);
                case "*":
                    return variables[count - 1].mul(variables[count]);
                case "/":
                    return variables[count - 1].div(variables[count]);
                default:
                    return null;
            }
        }
        return null;
    }
}
