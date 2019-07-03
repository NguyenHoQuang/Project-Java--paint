
package projectJava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class ColorChoose extends JFrame implements ChangeListener {
	
    public static JColorChooser tcc;
    public ColorChoose() {
    	setTitle("Choose Color");
    	setVisible(true);
    	setSize(600, 400);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel bannerPanel = new JPanel(new BorderLayout());

        tcc = new JColorChooser();
        tcc.getSelectionModel().addChangeListener(this);

        this.add(bannerPanel, BorderLayout.CENTER);
        this.add(tcc, BorderLayout.NORTH);
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
        bannerPanel.add(btn, BorderLayout.SOUTH);
    }

    public void stateChanged(ChangeEvent e) {
        GUI.selectColor = tcc.getColor();
    }
}