package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
	static JFrame frame;
	JPanel panel;
	JLabel instruction;
	JLabel title;
	JButton start;
	Font font;
	Font font2;
	double[] time = new double[10];
	static Test test = new Test();
	
	public Main() {
		frame = new JFrame("Reaction time test");
		frame.setBounds(0, 0, 1925, 1050);

		font = new Font("Comic Sans MS", Font.BOLD, 36);
		font2 = new Font("Comic Sans MS", Font.PLAIN, 24);

		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);

		instruction = new JLabel();

		panel.add(instruction);

		title = new JLabel();

		panel.add(title);

		start = new JButton("Play");

		panel.add(start);

	}

	public void titleScreen() {

		instruction.setFont(font2);
		instruction.setText("<html>Instructions<br>___________<br>1. Press play<br><br>"
				+ "2. A button will appear at a random location on the screen after a random amount of time."
				+ " Click it as fast as you can"
				+ "<br><br>3. Step 2 is repeated 9 more times to get accurate results<br><br>4. A text file containing your average"
				+ " reaction time and median reaction time for each testing session will be created. Make sure to check it out");
		instruction.setBounds(800, 200, 500, 500);

		title.setBounds(800, 10, 375, 100);
		title.setOpaque(true);
		title.setBackground(Color.white);
		title.setFont(font);
		title.setText("Reaction Time Test");

		start.setFont(font2);
		start.setText("Play");
		start.setBounds(800, 850, 200, 100);
		start.addActionListener(this);

	}

	public static void main(String[] args) {
		Main main = new Main();
		
		main.titleScreen();

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			 test.cls();
			
		}

	}

}