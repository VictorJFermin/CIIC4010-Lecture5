import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMain
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		
		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 400;
		
		CarStage theComponent = new CarStage(FRAME_HEIGHT);
		frame.add(theComponent);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("CIIC 4010 / ICOM 4015 Developers");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		
		while(!theComponent.someCarWon()) {
			frame.repaint();
			Thread.sleep(100);
		}
		
		JOptionPane.showMessageDialog(null, "END OF RACE");
		
		System.exit(0);
		
	}
}
