package org.postfix;

public class PostfixCalculator implements Calc {
    private Stack<Double> stack;

    public PostfixCalculator() {
        this.stack = new StackVector<>();
    }

    @Override
    public double calculate(String input) {
        stack = new StackVector<>(); // clear stack
        
        String[] tokens = input.trim().split("\\s+");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                if (((StackVector<Double>) stack).size() < 2) {
                    throw new IllegalArgumentException("Operandos insuficientes");
                }
                
                double b = stack.pop();
                double a = stack.pop();
                double resultado = operar(a, b, token);
                stack.push(resultado);
            } else {
                try {
                    stack.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Carácter inválido: " + token);
                }
            }
        }
        
        if (((StackVector<Double>) stack).size() != 1) {
            throw new IllegalArgumentException("Expresión inválida");
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }
    
    private double operar(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("División entre cero");
                return a / b;
            default: throw new IllegalArgumentException("Operador desconocido");
        }
    }
}