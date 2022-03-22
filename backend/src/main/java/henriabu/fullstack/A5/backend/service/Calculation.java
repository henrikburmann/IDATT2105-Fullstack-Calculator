package henriabu.fullstack.A5.backend.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Calculation {

    List<String> calculations = new ArrayList<>();
    String equation;
    double answer;
    public List<String> getCalculations() {
        return calculations;
    }

    public double getAnswer() {
        return answer;
    }

    public void setCalculations(List<String> calculations) {
        this.calculations = calculations;
    }

    public double calculate(double num1, double num2, char op){
        equation = "";
        if (op == '+'){
            answer = num1 + num2;
            equation = num1 + " + " + num2 + " = " + answer;
        }
        else if (op == '-'){
            answer = num1 - num2;

            equation = num1 + " - " + num2 + " = " + answer;
        }
        else if (op == '*'){
            answer = num1 * num2;
            equation = num1 + " * " + num2 + " = " + answer;
        }
        else if (op == '/'){
            answer = num1 / num2;
            equation = num1 + " / " + num2 + " = " + answer;
        }
        calculations.add(equation);
        return answer;
    }
}
