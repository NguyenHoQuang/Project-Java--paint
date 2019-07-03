package projectJava;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Paint_App extends JComponent {
	public Point startDrag, endDrag;
	public Paint ptemp;
	public BasicStroke bstroke;
	
	public Paint_App() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
	          startDrag = new Point(e.getX(), e.getY());
	          endDrag = startDrag;
	          if(GUI.selectShap == "move"){
		          for(int i = GUI.paint.size() - 1; i>=0; i=i-1){
		        	  Paint pt = GUI.paint.get(i);
	        		  if(pt.contains(startDrag)){
	        			  ptemp = pt;
	        			  GUI.paint.remove(pt);
	        			  break;
	        		  }
		          }
	          }
	          else if(GUI.selectShap == "Delete" ){
		          for(int i = GUI.paint.size() - 1; i>=0; i=i-1){
		        	  Paint pt = GUI.paint.get(i);
		        	    if(pt.contains(startDrag)){
		        			  ptemp = null;
		        			  GUI.paint.remove(pt);
		        			  break;
		        	    }
		          }
	          }
			}
	        public void mouseReleased(MouseEvent e) {
	        	Point p = new Point(e.getX(), e.getY());
	        	if(GUI.selectShap == "Rectangle"){
	        		MyRectangle obj = new MyRectangle();
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "Square"){
	        		MySquare obj = new MySquare();
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "Triangle"){
	        		MyTriangle obj = new MyTriangle();
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "Oval"){
	        		MyOval obj = new MyOval();
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "Circle"){
	        		MyCircle obj = new MyCircle();
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "Point"){
	        		MyPoint obj = new MyPoint();
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "Line"){
	        		MyLine obj = new MyLine(startDrag, new Point(e.getX(),  e.getY()), GUI.selectColor);
	        		obj.makeObject(startDrag, p);
	    			GUI.paint.add(obj);
	        	}
	        	else if(GUI.selectShap == "fill"){
	        		for(int i = GUI.paint.size() - 1; i>=0; i=i-1){
	        			Paint pt = GUI.paint.get(i);
	        			try{
	        				Class2D s = (Class2D)pt;
	        				if(s.contains(startDrag)){
		        				try{
		        					s.fill(GUI.selectColor);
		        				}
		        				catch(Exception ex){}
			        			break;
		        			}
	        			}
	        			catch(Exception ex){}
	        		}
	        	}
	        	else if(GUI.selectShap == "move"){
	        			if(ptemp.contains(startDrag)){
	        				ptemp.move(startDrag, p);
        					GUI.paint.add(ptemp);
	        			}
	        		}
	        	startDrag = null;
	        	endDrag = null;
	        	repaint();
	        }
	      });

		this.addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) {
	        	endDrag = new Point(e.getX(), e.getY());
	        	repaint();
	        }
	      });
	}
	public void paint(Graphics g) {
		GraphicAdapter g2 = new GraphicAdapter() {
		};
		g2.setGraphicAdapter(g);
		//bstroke = new BasicStroke(40);
		//g2.getGraphicAdapter().setStroke(bstroke);
		if(OpenFile.image != null){
			g2.getGraphicAdapter().drawImage(OpenFile.image, 0, 0, null);
			repaint();
		}
		for (Paint pt : GUI.paint){
			pt.draw(g2);
		}
		if (startDrag != null && endDrag != null) {
			if(GUI.selectShap == "Rectangle"){
				MyRectangle obj = new MyRectangle();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}else if(GUI.selectShap == "Square"){
				MySquare obj = new MySquare();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}
			else if(GUI.selectShap == "Oval"){
				MyOval obj = new MyOval();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}
			else if(GUI.selectShap == "Circle"){
				MyCircle obj = new MyCircle();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}
			else if(GUI.selectShap == "Point"){
				MyPoint obj = new MyPoint();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}
			else if(GUI.selectShap == "Line"){
				MyLine obj = new MyLine();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}
			else if(GUI.selectShap == "Triangle"){
				MyTriangle obj = new MyTriangle();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g2);
			}
			else if(GUI.selectShap == "move"){
        			if(ptemp instanceof MyRectangle){
        				MyRectangle r = (MyRectangle)ptemp;
        				if(r.contains(startDrag)){
        					if(r.getColor()==null){
        						g2.getGraphicAdapter().setColor(r.getLineColor());
        						g2.getGraphicAdapter().drawRect(r.getRect().x + endDrag.x - startDrag.x, r.getRect().y + endDrag.y - startDrag.y, r.getRect().width, r.getRect().height);
        					}else {
        						g2.getGraphicAdapter().setColor(r.getColor());
        						g2.getGraphicAdapter().fillRect(r.getRect().x + endDrag.x - startDrag.x, r.getRect().y + endDrag.y - startDrag.y, r.getRect().width, r.getRect().height);
        						g2.getGraphicAdapter().drawRect(r.getRect().x + endDrag.x - startDrag.x, r.getRect().y + endDrag.y - startDrag.y, r.getRect().width, r.getRect().height);
							}
        				}
        			}else if (ptemp instanceof MyOval) {
        				MyOval oval = (MyOval)ptemp;
        				if(oval.contains(startDrag)){
        					if(oval.getColor()==null){
        						g2.getGraphicAdapter().setColor(oval.getLineColor());
        						g2.getGraphicAdapter().drawOval((int)(oval.getElip2d().getX() + endDrag.x - startDrag.x),(int)(oval.getElip2d().getY() + endDrag.y - startDrag.y), (int)oval.getElip2d().getWidth(), (int)oval.getElip2d().getHeight());
        					}else{
        						g2.getGraphicAdapter().setColor(oval.getColor());
        						g2.getGraphicAdapter().fillOval((int)(oval.getElip2d().getX() + endDrag.x - startDrag.x),(int)(oval.getElip2d().getY() + endDrag.y - startDrag.y), (int)oval.getElip2d().getWidth(), (int)oval.getElip2d().getHeight());
        					}
        				}
					}else if (ptemp instanceof MyTriangle) {
        				MyTriangle tr = (MyTriangle)ptemp;
        				if(tr.contains(startDrag)){
        					int[]x = {tr.getTriangle().xpoints[0] + endDrag.x - startDrag.x,tr.getTriangle().xpoints[1] + endDrag.x - startDrag.x, tr.getTriangle().xpoints[2] + endDrag.x - startDrag.x};
        					int[]y = {tr.getTriangle().ypoints[0] + endDrag.y - startDrag.y,tr.getTriangle().ypoints[1] + endDrag.y - startDrag.y, tr.getTriangle().ypoints[2] + endDrag.y - startDrag.y};
        					if(tr.getColor()==null){
        						g2.getGraphicAdapter().setColor(tr.getLineColor());
        						g2.getGraphicAdapter().drawPolygon(x,y,3);
        					}else{
        						g2.getGraphicAdapter().setColor(tr.getColor());
        						g2.getGraphicAdapter().fillPolygon(x,y,3);
        						g2.getGraphicAdapter().drawPolygon(x,y,3);
        					}
        				}
					}else if (ptemp instanceof MyLine) {
        				MyLine tr = (MyLine)ptemp;
        				if(tr.contains(startDrag)){
        						g2.getGraphicAdapter().setColor(tr.getColor());
        						g2.getGraphicAdapter().drawLine((int)(tr.getLine().getStartX() + endDrag.x - startDrag.x), (int)(tr.getLine().getStartY() + endDrag.y - startDrag.y), (int)(tr.getLine().getEndX()+ endDrag.x - startDrag.x), (int)(tr.getLine().getEndY()+ endDrag.y - startDrag.y));
        				}
					}
        		}
			}
		}
}
