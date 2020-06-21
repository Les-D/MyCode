package hr.fer.oop.fourth;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class SimulatedMessageFrame extends JFrame {
	
	private SwingWorker<Long, String> worker;
	private int numMessages = 10;
	private JLabel label = new JLabel("Message transfer:", JLabel.CENTER);
	private JProgressBar progressBar = new JProgressBar();
	private JButton startButton = new JButton("Start");
	private JTextArea textArea = new JTextArea();
	
	
	public SimulatedMessageFrame() {

		// progress bar (0, numMessages) => inkrement vrijednosti za svaku poruku
		progressBar.setIndeterminate(false);
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(numMessages);
		
		// TO DO: Dodaj odgovarajuće panele, layout, ...
		//setLayout(new BorderLayout()); - default layout for JFrame
		
		JPanel borderPanel = (JPanel) getContentPane();
		borderPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		//1st row
		JPanel northPanel = new JPanel();
		northPanel.add(label);
		northPanel.add(progressBar);
		add(northPanel, BorderLayout.NORTH);
		
		//2nd row
		add(textArea, BorderLayout.CENTER);
		
		//3rd row
		JPanel southPanel = new JPanel();
		southPanel.add(startButton);
		add(southPanel, BorderLayout.SOUTH);
		
		ActionListener listener = (e) -> {
			startButton.setEnabled(false);
			progressBar.setValue(0);
			textArea.setText("");
			worker = new MessageWorker();
			worker.execute();
		};
		startButton.addActionListener(listener);
	}
	
	
	private class MessageWorker extends SwingWorker<Long, String>{
		
		private Long totalTime = 0L;
		private int progress = 0;

		@Override
		protected Long doInBackground() throws Exception {
			for(int i = 1; i <= numMessages; i++) {
				long pre = System.currentTimeMillis();
				sendMessage();
				long post = System.currentTimeMillis();
				Long time = post - pre;
				totalTime += time;
				publish(time.toString());
			}
			return totalTime;
		}
		
		@Override
		protected void done() {
			textArea.append("All messages were transferred in " + totalTime + " ms.");
			progressBar.setValue(0);
			startButton.setEnabled(true);
		}
		
		@Override
		protected void process(List<String> chunks) {
			for(String time : chunks) {
				progress++;
				textArea.append("Sending " + progress + ". message, " + time + " msec\n");
				progressBar.setValue(progress);
			}
		}
		
		
		//Simulate a long run time needed for encription and sending message
		void sendMessage() throws InterruptedException {
			Random rnd = new Random(System.currentTimeMillis());
			long millis = rnd.nextInt(1000);
			Thread.sleep(millis);
		} 
	}
}