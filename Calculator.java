
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator extends JFrame implements  ActionListener
	 {
		public JTextField result = new JTextField();
		Container c ; 
		JPanel p = new JPanel();
		JButton button[] = new JButton[16];
		public String s[] = {"0","1","2","3","4","5","6","7","8","9","+","-","/","*","=","Clear"};
		double R,L;
		public String Screen = "";
		char charOperator = 'E' ;
		double Answer;
		public boolean setEmpty = false; public boolean ifAnswer = false;
		
		
		
		public Calculator()
		 {
		 super("My First Real Code ^_^");
			c=getContentPane();
			getContentPane().setBackground(Color.YELLOW);					//God awful color for god awful code
			p.setLayout(new GridLayout(4,5));
			result.setEditable(false);
			result.setBackground(Color.cyan);
	
			for(int i=0;i<16;i++)
			 {
					button[i] = new JButton(s[i]);
					button[i].addActionListener(this);
					p.add(button[i]);
			}
			result.setBackground(Color.cyan);
			c.add(result,BorderLayout.NORTH);
			c.add(p);
			setSize(300,300);
			setVisible(true);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public static void main (String[] args) 
		{
				new Calculator();
	  	}
		public void actionPerformed(ActionEvent event)
		 {
			
			for(int i=0;i<10;i++){
				if(event.getSource()==button[i]){
					
					Screen = Screen + i;
					result.setText(Screen);
					if(charOperator!='E'){
						try{
						
							L = Double.parseDouble(Screen);
							
						}catch(Exception e){}
					}
					
				}
			}
			
			for(int i=10;i<14;i++){										//Operators
				if(event.getSource() == button[i]){
					
					try{												//Catch exception and allow answer carry on
							R = Double.parseDouble(result.getText()); 
							System.out.println(R);
				
					}catch(Exception e){}
					
					charOperator = s[i].charAt(0);
					clear();
					result.setText(s[i]);
				}
			}
			
			if(event.getSource() == button[14]){						// Equals button.
				Answer = Calculate(charOperator,R,L);
				String setAnswer;
				setAnswer = String.valueOf(Answer);
				result.setText(setAnswer);
				R = 0; L = 0;
				ifAnswer = true;
			}
			
			if(event.getSource() == button[15]){			// Clear button
				charOperator = 'E';		
				clear();
				
			}
			
		}
	
		double Calculate(char op, double K,double S){
		
		switch (op)
			{
				case '+':
					return K+S;
				case '-':
					return K-S;
				case '*':
					return K*S;
				case '/':
					return K/S;
				case 'E':
					clear();
					return K;
			}
			return 0;
		}
		
		
		void clear(){
				result.setText(" "); 
				Screen = " ";
				
		}
		
		
		
	}
	
	
	
	
	





