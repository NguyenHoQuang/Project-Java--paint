package projectJava;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;

import javafx.scene.shape.Line;

public class MyLine implements Class1D{
	private Line line;
	private Color color;
	public MyLine(){
		
	}
	public MyLine(Line ln){
		this.line = ln;
	}
	public MyLine(Point staPoint, Point enPoint){
		this.line = new Line(staPoint.x, staPoint.y, enPoint.x, enPoint.y);
	}
	public MyLine(Point staPoint, Point enPoint, Color c){
		this.line = new Line(staPoint.x, staPoint.y, enPoint.x, enPoint.y);
		this.color = c;
	}
	
	@Override
	public void draw(GraphicAdapter g){
		g.getGraphicAdapter().setColor(getColor());
		g.getGraphicAdapter().drawLine((int)getLine().getStartX(), (int)getLine().getStartY() , (int)getLine().getEndX(), (int)getLine().getEndY());
	}
	
    @Override
    public boolean contains(Point p) {
    	return this.getLine().contains(p.x, p.y);
    }
    @Override
    public void move(Point startDrag, Point endDrag){
    	Point startPoint = new Point((int)getLine().getStartX() + (endDrag.x - startDrag.x), (int)getLine().getStartY() + (endDrag.y - startDrag.y));
    	Point endPoint = new Point((int)getLine().getEndX() + (endDrag.x - startDrag.x),(int)getLine().getEndY() + (endDrag.y - startDrag.y));
    	Line ln = new Line(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    	this.setLine(ln);
    }
    
    @Override
    public void writetoFile(BufferedWriter b){
    	try {
    		b.write(getClass().getSimpleName() + ";");
    		b.write((int)getLine().getStartX() + ";" + (int)getLine().getStartY() + ";" + (int)getLine().getEndX() + ";" + (int)getLine().getEndY() + ";");
    		b.write(getColor().getRed() + ";" + getColor().getGreen() + ";" + getColor().getBlue());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void makeObject(Point startDrag, Point endDrag){
    	Line ln = new Line(startDrag.x, startDrag.y, endDrag.x,  endDrag.y);
    	setLine(ln);
    	setColor(GUI.selectColor);
    }
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	
}