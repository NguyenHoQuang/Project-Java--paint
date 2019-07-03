package projectJava;

//import java.awt.BasicStroke;
import java.awt.Color;
//import java.awt.Graphics2D;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;

public class MyPoint implements Class1D {
	private Point point;
	private Color color = Color.black;
	
	public MyPoint() {
		
	}
	public MyPoint(Point p) {
		this.point = p;
	}
	
	public MyPoint(Point p, Color c) {
		this.point = p;
		this.color = c;
	}
	@Override
	public void draw(GraphicAdapter g){
		g.GraphicAdapter.setColor(getColor());
		//g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.getGraphicAdapter().drawLine(getPoint().x, getPoint().y,getPoint().x, getPoint().y);
	}
	
	@Override
    public boolean contains(Point p) {
		if(p.x == getPoint().x && p.y == getPoint().y){
			return true;
		}
		return false;
    }
    @Override
    public void move(Point startDrag, Point endDrag){
    	setPoint(endDrag);
    }
	
    @Override
    public void writetoFile(BufferedWriter b){
    	try {
    		b.write(getClass().getSimpleName() + ";");
    		b.write(getPoint().x + ";" + getPoint().y + ";");
    		b.write(getColor().getRed() + ";" + getColor().getGreen() + ";" + getColor().getBlue());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void makeObject(Point startDrag, Point endDrag){
    	Point p = new Point(startDrag.x, startDrag.y);
    	setPoint(p);
    	setColor(GUI.selectColor);
    }
    
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
