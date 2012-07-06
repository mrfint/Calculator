package model;

public class Calculater {

    public int calculate(int a, int b, char op){
        int result = 0;
        switch(op){
            case '+':  result=a+b;
                       break;
            case '-':  result=a-b;
                       break;                
            case '*':  result=a*b;
                       break;
            case '/':  result=a/b;
                       break;                
            default: throw new IllegalArgumentException("MY EXCEPTION");
        }
        return result;
    }   
}
