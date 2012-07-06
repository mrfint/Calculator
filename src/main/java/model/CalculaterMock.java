package model;

public class CalculaterMock extends Calculater{
    @Override
    public int calculate(int a, int b, char op){
        int result = 10;
        String s="+-*/";
        
        if(b==0&&op=='/') throw new ArithmeticException();
        if(s.indexOf(op)<0) throw new IllegalArgumentException();
        
        return result;
    }   
}
