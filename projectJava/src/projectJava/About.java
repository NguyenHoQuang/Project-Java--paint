package projectJava;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class About extends JFrame {
	private JPanel contentPane;
	public About() {
		setTitle("Information of the team made: ");
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JEditorPane About = new JEditorPane();
		About.setEditable(false);
		About.setText("INFORMATION:\r\n FULL NAME: NGUYEN HO QUANG \t STUDENT'S ID: 16520997 \n FULL NAME: NGUYEN KHA TINH \t STUDENT'S ID:16521248\nClass: SE330.J21.PMCL \n UNIVERSITY of INFORMATION TECHNOLOGY");
		contentPane.add(About, BorderLayout.CENTER);
	}

}
