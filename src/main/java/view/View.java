package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Calculater;

public class View extends JFrame{

	private JTextField cmd;
	private JPanel jpCenter;
	private JPanel jpTop;
        private JPanel jpRight;
        
	private JButton butEq;
	private String digits[] = {"7","8","9","4","5","6","1","2","3","0"};
        private String operations[] ={"+","-","*","/","="};
        

	
	public View(){
		super("Калькулятор");
                c=new Calculater();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		addContentPane(getContentPane());
		pack();
		setVisible(true);
	}

	private void addContentPane(Container contentPane) {
				
		jpTop = new JPanel();
		jpTop.setLayout(new BorderLayout());
		
		cmd = new JTextField();
		jpTop.add(cmd);
		
		jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(5,3));
		
		
		for(String c: digits){      //************Цепляем кнопки с цифрами
			JButton b = new JButton(c);
			jpCenter.add(b);
                        b.addActionListener(new Num());
			
		}
                for(String c: operations){  //************Цепляем кнопки с операциями
                    JButton b = new JButton(c);
			jpCenter.add(b);
                        b.addActionListener(new Oper());
		}
                              
		contentPane.setLayout(new BorderLayout());
		contentPane.add(jpTop, BorderLayout.PAGE_START);
                contentPane.add(jpCenter, BorderLayout.CENTER);
	}

	public String getCmd() {
		return cmd.getText();
	}

	public void setCmd(String s) {
		cmd.setText(s);
	}
 
        
       private class Num implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) 
        {
		JButton b = (JButton) e.getSource();
		setCmd(getCmd()+b.getText());
	}
       }
       
       private Calculater c=null;
       private char op;
       private int a; 
       private int b;
       
        private class Oper implements ActionListener{
      	@Override
	public void actionPerformed(ActionEvent e) 
        {
		JButton but = (JButton) e.getSource();
		if(!but.getText().equals("="))
                {
                 if(getCmd().length()>0) 
                  {
                      a=Integer.parseInt(getCmd());
                  }
                 op=but.getText().toCharArray()[0];
                 setCmd("");
                }
                else
                {
                  if(getCmd().length()>0) 
                  {
                      b=Integer.parseInt(getCmd());
                  } 
                  setCmd(""+c.calculate(a, b, op));
                }
  	}
    }


public static void main(String[] args) {
		
		View f = new View();
	}

}
