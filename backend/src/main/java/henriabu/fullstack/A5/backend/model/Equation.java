package henriabu.fullstack.A5.backend.model;


public class Equation {
    private int id;
    private double num1;
    private double num2;
    private String operator;
    private double answer;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getAnswer() {
        return answer;
    }

    public String writeExpression(){
        return num1 + " " + operator + " " + num2 + " = " + calculateAnswer();
    }
    public double calculateAnswer(){
      
        if (operator.equals("+")){
            this.answer = this.num1 + this.num2;
        }
        else if (operator.equals("-")){
            this.answer = this.num1 - this.num2;
        }
        else if (operator.equals("*")){
            this.answer = this.num1 * this.num2;
        }
        else if (operator.equals("/")){
            this.answer = this.num1 / this.num2;
        }
        return this.answer;
    }

     


}
