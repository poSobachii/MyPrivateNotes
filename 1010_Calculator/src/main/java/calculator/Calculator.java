package calculator;

import java.util.ArrayList;
import java.util.List;

class Calculator {

    String calculate(String[] expression) {  // 2 + 2
        List<String> tmp = new ArrayList<>(List.of(expression));

        int brOpenIndex = -1;
        do {
            brOpenIndex = -1;
            for (int i = 0; i < tmp.size(); i++) {
                String a = tmp.get(i);
                if (a.equals("(")) {
                    brOpenIndex = i;
                } else if (a.equals(")")) {
                    var inBr = tmp.subList(brOpenIndex + 1, i);
                    var result = calculate(inBr);
                    tmp.subList(brOpenIndex, i + 1).clear();
                    tmp.add(brOpenIndex, result);
                    break;
                }

            }
        }
        while (brOpenIndex != -1);

        return calculate(tmp);
    }

    String calculate(List<String> expression) {
        List<String> tmp = new ArrayList<>();
        double a = Double.parseDouble(expression.get(0));
        for (int i = 1; i < expression.size(); i += 2) {
            String op = expression.get(i);
            double b = Double.parseDouble(expression.get(i + 1));
            switch (op) {
                case "+":
                case "-":
                    tmp.add(String.valueOf(a));
                    tmp.add(op);
                    a = b;
                    break;
                case "*":
                    a *= b;
                    break;
                case "/":
                    a /= b;
                    break;
            }
        }
        tmp.add(String.valueOf(a));

        System.out.println(tmp);

        double result = Double.parseDouble(tmp.get(0));
        for (int i = 1; i < tmp.size(); i += 2) {
            String op = tmp.get(i);
            double b = Double.parseDouble(tmp.get(i + 1));
            switch (op) {
                case "+":
                    result += b;
                    break;
                case "-":
                    result -= b;
                    break;
                default:
                    return "ERROR";
            }

        }

        return String.valueOf(result);
    }
}