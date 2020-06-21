package hr.fer.oop.fourth;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SwingWorkerMain {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new SimulatedMessageFrame();
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setLocation(500, 250);
			frame.pack();
			frame.setVisible(true);
		});
		
	}

}
