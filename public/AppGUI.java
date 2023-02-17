import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AppGUI extends JFrame implements ActionListener, ChangeListener{

	JPanel panel;
	JLabel title;
	JLabel result_lbl;
	JLabel resText_lbl;
	JLabel opt_lbl;
	JButton submit_btn;
	JRadioButton pin_btn;
	JRadioButton pwd_btn;
	ButtonGroup opt_btn;
	JSlider length_slider;
	int length;
	JLabel length_lbl;
	int min,max;
	Generate password;
	Generate pin;
	String selectedOption;
	String output;
	
	public AppGUI() {
		
		password = new Password(8,30);
		pin = new Pin(4,8);
		
		panel = new JPanel();
		panel.setBounds(0,0,500,500);
		
		title = new JLabel("PIN and Password Generator");
		title.setBounds(30,20,400,50);
		title.setForeground(new Color(50,150,240));
		title.setFont(new Font("Times New Roman",Font.BOLD,30));
		
		opt_lbl = new JLabel("select:");
		opt_lbl.setBounds(70,100,100,50);
		opt_lbl.setForeground(new Color(50,150,240));
		opt_lbl.setFont(new Font("Times New Roman",Font.PLAIN,20));
		
		pin_btn = new JRadioButton();
		pin_btn.setBounds(150,100,100,50);
		pin_btn.setText("PIN");
		pin_btn.setFont(new Font("Times New Roman",Font.PLAIN,20));
		pin_btn.setForeground(new Color(50,150,240));
		pin_btn.setFocusable(false);
		pin_btn.addActionListener(this);
		
		pwd_btn = new JRadioButton();
		pwd_btn.setBounds(250,100,150,50);
		pwd_btn.setText("Password");
		pwd_btn.setFont(new Font("Times New Roman",Font.PLAIN,17));
		pwd_btn.setForeground(new Color(50,150,240));
		pwd_btn.setFocusable(false);
		pwd_btn.addActionListener(this);
		
		getSelectedOption(); // setting min and max values; get selected radion button
		length_slider = new JSlider(0, 0, 0);
		length_slider.setBounds(200, 150, 100, 20);
		length_slider.addChangeListener(this);
		
		length_lbl = new JLabel();
		length_lbl.setText(length+"");
		length_lbl.setBounds(250,180,50,20);
		length_lbl.setFont(new Font("Times New Roman",Font.PLAIN,20));
		length_lbl.setForeground(new Color(50,150,240));
		
		opt_btn = new ButtonGroup();
		opt_btn.add(pin_btn);
		opt_btn.add(pwd_btn);
		
		submit_btn = new JButton();
		submit_btn.setBounds(200,250,100,50);
		submit_btn.setText("Generate");
		submit_btn.setFont(new Font("Times New Roman",Font.PLAIN,15));
		submit_btn.setForeground(new Color(50,150,240));
		submit_btn.setFocusable(false);
		submit_btn.addActionListener(this);
		submit_btn.setEnabled(false);
		
		result_lbl = new JLabel();
		result_lbl.setText(getOutput());
		result_lbl.setBounds(100,350,400,20);
		result_lbl.setFont(new Font("Times New Roman",Font.PLAIN,20));
		result_lbl.setForeground(new Color(50,150,240));
		
		resText_lbl = new JLabel();
		resText_lbl.setText("Result:");
		resText_lbl.setBounds(10,350,80,20);
		resText_lbl.setFont(new Font("Times New Roman",Font.PLAIN,20));
		resText_lbl.setForeground(new Color(50,150,240));
		
		this.add(resText_lbl);
		this.add(result_lbl);
		this.add(submit_btn);
		this.add(opt_lbl);
		this.add(title);
		this.add(pin_btn);
		this.add(pwd_btn);
		this.add(length_slider);
		this.add(length_lbl);
		this.setTitle("PIN and Password Generator");
		this.setBackground(new Color(30,40,50));
		this.setSize(500, 500);
		
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void setSelectedOption(String option){
		this.selectedOption = option;
	}
	
	
	public String getSelectedOption(){
		return selectedOption;
	}
	
	 String getOutput() {
		 if(getSelectedOption() == "pin") {
			 pin.setOutput(pin.generate(length));
			 output = pin.getOutput();
			 System.out.println(output);
			 return output;
		 }
		 else if(getSelectedOption() == "password") {
			 password.setOutput(password.generate(length));
			 output = password.getOutput();
			 return output;
		 }
		 return null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit_btn) {
			result_lbl.setText(getOutput());
			if(getSelectedOption() == "pin") {
				pin = new Pin(4,8); //reset generate pin class
			}
			if(getSelectedOption() == "password") {
				password = new Password(8,30); //reset generate password class
			}

		}
		if(e.getSource() == pin_btn) {
			this.min = pin.min;
			this.max = pin.max;

			length_slider.setMinimum(min);
			length_slider.setMaximum(max);
			
			setSelectedOption("pin");
			submit_btn.setEnabled(true);
		}
		if(e.getSource() == pwd_btn) {
			this.min = password.min;
			this.max = password.max;
		
			length_slider.setMinimum(min);
			length_slider.setMaximum(max);

			setSelectedOption("password");
			submit_btn.setEnabled(true);
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		
		getSelectedOption();
		length = length_slider.getValue();
		length_lbl.setText(Integer.toString(length));
	}
}
