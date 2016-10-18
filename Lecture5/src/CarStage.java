import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CarStage extends JComponent {

	private static final long serialVersionUID = 1L;

	static int counter = 0;

	Vehicle[] vehicles;

	boolean onAWall = false;

	boolean someCarWon = false;

	Random randomNumbers = new Random();

	public CarStage(int frameHeight) {
		int laneHeight = 50;
		int numberOfLanes = Math.round(frameHeight / laneHeight);
		// TO DO Make Sure numberOfLanes fit in frame
		vehicles = new Vehicle[numberOfLanes];

		int nextYPos = 0;
		for (int i=0; i < numberOfLanes; i++) {
			vehicles[i] = new MutableCar(0, nextYPos, Color.BLUE, 10, 1, i);
			nextYPos += laneHeight;
		}
	}

	public boolean someCarWon() { return someCarWon; }

	public void paintComponent (Graphics g) {

		for (Vehicle vehicle : vehicles) {
			vehicle.draw(g);
			int deltaxCar = randomNumbers.nextInt(vehicle.getHorizontalSpeed());
			vehicle.moveInX(deltaxCar);
			if (vehicle.getXPos()+60 >= this.getWidth()) {
				// Car hit the wall
				vehicle.setPosition(this.getWidth()-60, vehicle.getYPos());
				someCarWon = true;
			}
		}
		System.out.println(counter++);
	}
}
