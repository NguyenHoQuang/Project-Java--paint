package projectJava;

import java.awt.Rectangle;

public class MySquare extends MyRectangle {
	public void setRect(Rectangle rect) {
		rect.setBounds(rect.x, rect.y , rect.width, rect.width);
		super.setRect(rect);
	}
}
