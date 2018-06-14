package mainPackage;

import java.util.Random;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

//current given status: loading the second screen takes forever
public class Test implements ActionListener {

	JPanel test;
	JButton click;
	long millis, millis2;
	private int counter = 0;

	Main main = new Main();

	public Test() {
		test = new JPanel();
		test.setLayout(null);
		click = new JButton();
		click.setFont(main.font2);
		click.addActionListener(this);
		test.add(click);
		click.setSize(300,150);
		test.setBackground(Color.red);
	}

	// clears screen
	public void cls() {

		// removes title screen, adds new panel and makes sure everything works
		// main.frame.remove(main.panel);
		main.frame.add(test);

	}

	public void test() {
		// Random seed
		Random rn = new Random();
		// random time for wait, random x and y positions
		int randTime, x, y;

		for (counter = 0; counter < 10; counter++) {
			click.setVisible(false);

			// getting random numbers: random button appear time 1-3 seconds, x 1-1600
			// position, y 1-800 position
			randTime = rn.nextInt(2000) + 1000;
			x = rn.nextInt(1600) + 1;
			y = rn.nextInt(800) + 1;

			click.setText("Attempt " + (counter + 1));

			// Wait time for button to appear
			try {
				Thread.sleep(randTime);
			} catch (InterruptedException e) {
				System.out.println("Something somehow messed up");
				e.printStackTrace();
			}

			// Getting time from when button appears
			click.setBounds(x, y, 300, 150);
			millis = System.currentTimeMillis();
			click.setVisible(true);

			// gives a max of 1.5 seconds to click on button
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("Something somehow messed up");
				e.printStackTrace();
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == click) {
			millis2 = System.currentTimeMillis();

			JOptionPane.showMessageDialog(null, "Reaction time " + (counter + 1) + ":" + ((millis2 - millis)));
			main.time[counter] = millis2 - millis;
			JOptionPane.showMessageDialog(null, main.time[counter]);
		}
	}

}