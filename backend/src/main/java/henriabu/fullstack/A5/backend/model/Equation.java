package henriabu.fullstack.A5.backend.model;


public class Equation {
    private int id;
    private double num1;
    private double num2;
    private char op;
    private String answer;
   

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String anwser) {
        this.answer = anwser;
    }


}
