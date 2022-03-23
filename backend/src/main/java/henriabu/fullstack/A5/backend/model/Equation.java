package henriabu.fullstack.A5.backend.model;


public class Equation {
    private int id;
    private double num1;
    private double num2;
    private char op;
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

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public double getAnswer() {
        return answer;
    }

    public double calculateAnswer(){
      
        if (op == '+'){
            answer = num1 + num2;
        }
        else if (op == '-'){
            answer = num1 - num2;
        }
        else if (op == '*'){
            answer = num1 * num2;
        }
        else if (op == '/'){
            answer = num1 / num2;
        }
        return answer;
    }


}
