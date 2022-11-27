import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;  
import javax.swing.*;
public class Main {


	 public static void main(String[] args) {

		 JFrame f=new JFrame("Calculate prime number");  
		 Container container = new Container();
		container.setBackground(Color.cyan );
         JLabel l1,l2,l3;
         l1=new JLabel("Enter N : ");  
         l1.setBounds(30,20, 100,30);  
         final JTextField tf=new JTextField();
         tf.setBounds(150,25, 150,20);
         l2=new JLabel("Enter File Name : ");  
         l2.setBounds(30,70, 100,30); 
         final JTextField tf2=new JTextField();  
         tf2.setBounds(150,75, 150,20);
         l3=new JLabel("Buffer Size : ");  
         l3.setBounds(30,120, 100,30); 
         final JTextField tf3=new JTextField();  
         tf3.setBounds(150,125, 150,20);
         JButton b=new JButton("Start Producer");  
         b.setBounds(30,170,150,20); 
             b.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
            	int bufferSize=Integer.valueOf(tf3.getText());
                buffer buf = new buffer(bufferSize);
                long startTime = System.currentTimeMillis();                
                int n = Integer.valueOf(tf.getText());
                String file= String.valueOf(tf2.getText());
                
                 
                 Thread producerThread = new Thread(new producer(buf,n,startTime));
                 Thread consumerThread = new Thread(new consumer(buf,file,startTime));
		 producerThread.start();
                 consumerThread.start();
                
                
      

        }  
                });  
                
                f.add(tf);
                f.add(tf2);
                f.add(tf3);
                f.add(b);
                f.add(l1); f.add(l2); 
                f.add(l3);
                f.setSize(350,240);  
                f.setLayout(null);  
                f.setVisible(true); 
                
                

                
	}
}