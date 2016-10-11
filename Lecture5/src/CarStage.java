import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	private static final long serialVersionUID = 1L;

	static int counter = 0;

	MutableCar[] cars;

	MutableCar theCar1 = new MutableCar(0, 0, Color.BLUE, 5, 1, 1);
	MutableCar theCar2 = new MutableCar(0, 50, Color.RED, 5, 1, 2);
	MutableCar theCar3 = new MutableCar(0, 100, Color.ORANGE, 5, 1, 3);

	boolean onAWall = false;

	boolean someCarWon = false;

	Random randomNumbers = new Random();

	public CarStage(int frameHeight) {
		int laneHeight = 50;
		int numberOfLanes = Math.round(frameHeight / laneHeight);
		// TO DO Make Sure numberOfLanes fit in frame
		cars = new MutableCar[numberOfLanes];

		int nextYPos = 0;
		for (int i=0; i < numberOfLanes; i++) {
			cars[i] = new MutableCar(0, nextYPos, Color.BLUE, 10, 1, i);
			nextYPos += laneHeight;
		}
	}

	public boolean someCarWon() { return someCarWon; }

	public void paintComponent (Graphics g) {

		for (MutableCar car : cars) {
			car.draw(g);
			int deltaxCar = randomNumbers.nextInt(car.getHorizontalSpeed());
			car.moveInX(deltaxCar);
			if (car.getXPos()+60 >= this.getWidth()) {
				// Car hit the wall
				car.setPosition(this.getWidth()-60, car.getYPos());
				someCarWon = true;
			}
		}
		System.out.println(counter++);
	}
}
