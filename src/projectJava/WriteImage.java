package projectJava;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class WriteImage extends JComponent{
	public WriteImage(){
		
	}
	public void Paint(GraphicAdapter g){
		g.getGraphicAdapter().drawImage(OpenFile.image, 0, 0, null);
	}
}