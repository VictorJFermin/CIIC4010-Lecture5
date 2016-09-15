import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MutableCar {

	private double xPos = 0;
	private double yPos = 0;
	private Color color = Color.BLACK;
	private int number;

	private int horizontalSpeed = 0;  // Car speed in pixels per second
	private int horizontalDirection;


	public MutableCar(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		horizontalSpeed = 10;
		horizontalDirection = 1;  // Initially moving right
	}

	public MutableCar(double x, double y, Color color) {
		this.xPos = x;
		this.yPos = y;
		this.color = color;
		horizontalSpeed = 10;
		horizontalDirection = 1;  // Initially moving right
	}

	public MutableCar(double x, double y, Color color, int hSpeed, int HDir, int number) {
		this.xPos = x;
		this.yPos = y;
		this.color = color;
		horizontalSpeed = hSpeed;
		horizontalDirection = HDir;
		this.number = number;
	}

	public Color getColor() {
		return this.color;
	}

	public double getXPos() {
		return this.xPos;
	}
	public double getYPos() {
		return this.yPos;
	}

	public int getHorizontalSpeed() {
		return horizontalSpeed;
	}

	public int getHorizontalDirection() {
		return horizontalDirection;
	}

	public void setPosition(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setHorizontalSpeed(int horizontalSpeed) {
		this.horizontalSpeed = horizontalSpeed;
	}

	public void setHorizontalDirection(int horizontalDirection) {
		this.horizontalDirection = horizontalDirection;
	}

	public void moveInX(double deltaX) {
		this.xPos += deltaX;
	}
	
	public void moveInY(double deltaY) {
		this.yPos += deltaY;
	}
	
	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		Point2D.Double rearWindowStart = new Point2D.Double(this.xPos+10, this.yPos+10);
		Point2D.Double rearWindowEnd = new Point2D.Double(this.xPos+20,this.yPos+0);
		Line2D.Double rearWindow = new Line2D.Double(rearWindowStart,rearWindowEnd);

		Point2D.Double frontWindowStart = new Point2D.Double(this.xPos+40,this.yPos+0);
		Point2D.Double frontWindowEnd = new Point2D.Double(this.xPos+50,this.yPos+10);
		Line2D.Double frontWindow = new Line2D.Double(frontWindowStart,frontWindowEnd);

		Point2D.Double roofStart = new Point2D.Double(this.xPos+20,this.yPos+0);
		Point2D.Double roofEnd = new Point2D.Double(this.xPos+40,this.yPos+0);
		Line2D.Double roof = new Line2D.Double(roofStart,roofEnd);

		Ellipse2D.Double rearTire = new Ellipse2D.Double(this.xPos+10,this.yPos+20,10,10);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.xPos+40,this.yPos+20,10,10);

		Rectangle.Double body = new Rectangle.Double(this.xPos+0,this.yPos+10,60.0,10.0);

		Rectangle.Double leftLight = new Rectangle.Double(this.xPos+0,this.yPos+10,5.0,5.0);
		Rectangle.Double rightLight = new Rectangle.Double(this.xPos+55,this.yPos+10,5.0,5.0);

		g2.setColor(Color.BLACK);
		g2.draw(rearTire);
		g2.draw(frontTire);
		g2.setColor(this.getColor());
		g2.fill(body);
		g2.draw(rearWindow);
		g2.draw(frontWindow);
		g2.draw(roof);
		if (this.getHorizontalDirection() > 0) {
			g2.setColor(Color.RED);
			g2.fill(leftLight);
			g2.setColor(Color.ORANGE);
			g2.fill(rightLight);
		}
		else {
			g2.setColor(Color.ORANGE);
			g2.fill(leftLight);
			g2.setColor(Color.RED);
			g2.fill(rightLight);
		}
		
		g2.setColor(Color.BLACK);
		g2.drawString(this.number+"", Math.round(this.getXPos())+25, Math.round(this.getYPos())+20);
	}
}