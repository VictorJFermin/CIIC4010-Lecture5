import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Truck extends Vehicle {
	
	public Truck(double x, double y, Color color, int hSpeed, int HDir, int number) {
		this.setPosition(x, y);
		this.setHorizontalSpeed(hSpeed);
		this.setHorizontalDirection(HDir);  // Initially moving right
		this.setNumber(number);
		this.setColor(color);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;

		Point2D.Double rearWindowStart = new Point2D.Double(this.getXPos()+10, this.getYPos()+10);
		Point2D.Double rearWindowEnd = new Point2D.Double(this.getXPos()+20,this.getYPos()+0);
		Line2D.Double rearWindow = new Line2D.Double(rearWindowStart,rearWindowEnd);

		Point2D.Double frontWindowStart = new Point2D.Double(this.getXPos()+40,this.getYPos()+0);
		Point2D.Double frontWindowEnd = new Point2D.Double(this.getXPos()+50,this.getYPos()+10);
		Line2D.Double frontWindow = new Line2D.Double(frontWindowStart,frontWindowEnd);

		Point2D.Double roofStart = new Point2D.Double(this.getXPos()+20,this.getYPos()+0);
		Point2D.Double roofEnd = new Point2D.Double(this.getXPos()+40,this.getYPos()+0);
		Line2D.Double roof = new Line2D.Double(roofStart,roofEnd);

		Ellipse2D.Double rearTire1 = new Ellipse2D.Double(this.getXPos(),this.getYPos()+20,10,10);
		Ellipse2D.Double rearTire2 = new Ellipse2D.Double(this.getXPos()+10,this.getYPos()+20,10,10);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(this.getXPos()+40,this.getYPos()+20,10,10);

		Rectangle.Double body = new Rectangle.Double(this.getXPos()+0,this.getYPos()+10,60.0,10.0);

		Rectangle.Double leftLight = new Rectangle.Double(this.getXPos()+0,this.getYPos()+10,5.0,5.0);
		Rectangle.Double rightLight = new Rectangle.Double(this.getXPos()+55,this.getYPos()+10,5.0,5.0);
		Rectangle.Double cargo = new Rectangle.Double(this.getXPos()+0,this.getYPos(),40.0,20.0);

		g2.setColor(Color.BLACK);
		g2.draw(rearTire1);
		g2.draw(rearTire2);
		g2.draw(frontTire);
		g2.setColor(this.getColor());
		g2.fill(body);
		g2.fill(cargo);
		//g2.draw(rearWindow);
		g2.draw(frontWindow);
		//g2.draw(roof);
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
		g2.drawString(this.getNumber()+"", Math.round(this.getXPos())+25, Math.round(this.getYPos())+20);
		
	}

}
