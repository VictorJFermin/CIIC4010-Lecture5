import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	private static final long serialVersionUID = 1L;

	static int counter = 0;

	MutableCar theCar1 = new MutableCar(0, 0, Color.BLUE, 5, 1, 1);
	MutableCar theCar2 = new MutableCar(0, 50, Color.RED, 5, 1, 2);
	MutableCar theCar3 = new MutableCar(0, 100, Color.ORANGE, 5, 1, 3);

	boolean onAWall = false;

	boolean someCarWon = false;
	
	Random randomNumbers = new Random();

	public boolean someCarWon() { return someCarWon; }

	public void paintComponent (Graphics g) {

		theCar1.draw(g);
		theCar2.draw(g);
		theCar3.draw(g);
		
		int deltaxCar1 = randomNumbers.nextInt(theCar1.getHorizontalSpeed());
		theCar1.moveInX(deltaxCar1);
		if (theCar1.getXPos()+60 >= this.getWidth()) {
			// Car 1 hit the wall
			theCar1.setPosition(this.getWidth()-60, theCar1.getYPos());
			someCarWon = true;
		}
		int deltaxCar2 = randomNumbers.nextInt(theCar2.getHorizontalSpeed());
		theCar2.moveInX(deltaxCar2);
		if (theCar2.getXPos()+60 >= this.getWidth()) {
			// Car 1 hit the wall
			theCar2.setPosition(this.getWidth()-60, theCar2.getYPos());
			someCarWon = true;
		}
		int deltaxCar3 = randomNumbers.nextInt(theCar3.getHorizontalSpeed());
		theCar3.moveInX(deltaxCar3);
		if (theCar3.getXPos()+60 >= this.getWidth()) {
			// Car 1 hit the wall
			theCar3.setPosition(this.getWidth()-60, theCar3.getYPos());
			someCarWon = true;
		}
		
//		if (onAWall) {
//			if (theCar.getYPos()+70 > this.getHeight()) {
//				// Car reached bottom
//				carReachedBottom = true;
//				return;
//			}
//			theCar.setPosition(theCar.getXPos(), theCar.getYPos()+40);
//			theCar.setHorizontalDirection(theCar.getHorizontalDirection()*-1);
//			onAWall = false;
//		}
//		else {
//			if (theCar.getXPos() + 60 >= this.getWidth() && theCar.getHorizontalDirection()>0) {
//				// Car would hit right wall
//				theCar.setPosition(this.getWidth()-60, theCar.getYPos());
//				//theCar.setHorizontalDirection(-1);
//				onAWall = true;
//			}
//			else if (theCar.getXPos() <= 0 && theCar.getHorizontalDirection() < 0) {
//				// Car would hit the left wall
//				theCar.setPosition(0, theCar.getYPos());
//				//theCar.setHorizontalDirection(1);
//				onAWall = true;
//			}
//			else {
//				theCar.setPosition(
//						theCar.getXPos()+(theCar.getHorizontalDirection()*theCar.getHorizontalSpeed()), 
//						theCar.getYPos());
//			}
//		}
		System.out.println(counter++);
	}
}
