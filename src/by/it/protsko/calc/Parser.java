package by.it.protsko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private Map<String, Integer> operationPriority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private int getIndexOperation(List<String> operators) {
        int operatorIndex = -1;
        int operatorPriority = -1;

        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            if (operationPriority.get(operator) >= operatorPriority) {
                operatorPriority = operationPriority.get(operator);
                operatorIndex = i;
            }
        }
        return operatorIndex;
    }

    Var calc(String expression) throws CalcException {
        String[] membersOfExpression = expression.replaceAll(" ", "").split(Patterns.OPERATIONS);
        if (membersOfExpression.length == 1) {
            return Var.createVar(expression);
        }

        List<String> operatorsExpression = new ArrayList<>();
        List<String> operandsExpression = new ArrayList<>(Arrays.asList(membersOfExpression));
        Matcher matcher = Pattern.compile(Patterns.OPERATIONS).matcher(expression);
        while (matcher.find()) {
            operatorsExpression.add(matcher.group());
        }

        while (operatorsExpression.size() > 0) {
            int indexOperation = getIndexOperation(operatorsExpression);
            String leftOperand = operandsExpression.remove(indexOperation);
            String rigthOperand = operandsExpression.remove(indexOperation);
            String operation = operatorsExpression.remove(indexOperation);
            Var operationResult = dataOperation(leftOperand, operation, rigthOperand);
            operandsExpression.add(indexOperation, operationResult.toString());
        }
        return Var.createVar(operandsExpression.get(0).replaceAll(" ",""));
    }

    Var dataOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var rightOperandValue = Var.createVar(rightOperand);

        if (operation.equals("=")) {
            Var.set(leftOperand, rightOperandValue);
            return rightOperandValue;
        }
        Var leftOperandValue = Var.createVar(leftOperand);

        if (leftOperandValue != null && rightOperandValue != null) {
            switch (operation) {
                case "+":
                    return leftOperandValue.add(rightOperandValue);
                case "-":
                    return leftOperandValue.sub(rightOperandValue);
                case "*":
                    return leftOperandValue.mul(rightOperandValue);
                case "/":
                    return leftOperandValue.div(rightOperandValue);
            }
        }
        throw new CalcException("Expression is not correct");
    }
}
