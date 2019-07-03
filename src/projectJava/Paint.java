package projectJava;

import java.awt.Point;
import java.io.BufferedWriter;

public interface Paint {
	public void draw(GraphicAdapter g); //Chuc nang chinh: Draw - ve doi tuong
	public boolean contains(Point p);	//Kiem tra diem co thuoc doi tuong
	public void move(Point startDrag, Point endDrag);	//Ham di chuyen doi tuong
	public void writetoFile(BufferedWriter b);	//Ghi cac gia tri doi tuong ra file text
	public void makeObject(Point startDrag, Point endDrag);	//Tao doi tuong
}