package projectJava;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class GUI extends JFrame {

	public static String selectShap = "";
	public static Color selectColor = Color.black;
	public static ArrayList<Paint> paint = new ArrayList<Paint>();
	private JPanel contentPane;
	public static GUI frame;  
	
	
	public static void main(String[] args) 
    {
    	try{
    		frame = new GUI();
    		frame.setVisible(true);
        }catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint - Đồ An Java - SE330.J21.PMCL");
		setSize(1000, 700);
		setMinimumSize(getSize());
		
		/*
		 * Create Menu bar
		 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		/*
		 * Menu Create News paint
		 */
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "";
				OpenFile.image = null;
				paint.clear();
				repaint();
			}
		});
		mnMenu.add(mntmNew);
		
		/*
		 * Menu open this paint 
		 */
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectShap="Open";
            	try {
            		GUI.paint.clear();
					new OpenFile();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
            }
        });
		mnMenu.add(mntmOpen);
		
		/*
		 * Menu Save this paint 
		 */
		JMenuItem mntmNew_1 = new JMenuItem("Save");
		mntmNew_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Save";
				new SaveFile();
			}
		});
		mnMenu.add(mntmNew_1);
		
		/*
		 * Menu exit this application
		 */
		JMenuItem mntmNew_2 = new JMenuItem("Exit");
		mntmNew_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Exit";
				System.exit(0);
			}
		});
		mnMenu.add(mntmNew_2);
	
	
		/*
		 * Menu Help
		 */
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
			
		/*
		 * Menu About
		 */
		
		Panel pnlabout = new Panel();
		pnlabout.setVisible(false);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new About();
			}
		});
		menuBar.add(mnAbout);
		
		/*
		 * Panel main (painting on this panel)
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.darkGray);
		contentPane.add(panel, BorderLayout.NORTH);
		
		/*
		 * Button draw free
		 */
		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Point";
			}
		});
		panel.add(btnDraw);
		
		
		/*
		 * Button selected draw Point
		 */
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Point";
			}
		});
		panel.add(btnPoint);
		
		/*
		 * Button selected draw Line
		 */
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectShap = "Line";
			}
		});
		panel.add(btnLine);
		
		/*
		 * Button selected draw Rectangle
		 */
		JButton btnRect = new JButton("Rectangle");
		btnRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Rectangle";
			}
		});
		panel.add(btnRect);
		
		/*
		 * Button selected draw Oval
		 */
		JButton btnOval = new JButton("Oval");
		btnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Oval";
			}
		});
		panel.add(btnOval);
		
		/*
		 * Button selected draw Square
		 */
		JButton btnSquare = new JButton("Square");
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Square";
			}
		});
		panel.add(btnSquare);
		
		/*
		 * Button selected draw Triangle
		 */
		JButton btnTri = new JButton("Triangle");
		btnTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectShap = "Triangle";
			}
		});
		panel.add(btnTri);
		
		/*
		 * Button selected draw Circle
		 */
		JButton btnCir = new JButton("Circle");
		btnCir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Circle";
			}
		});
		panel.add(btnCir);

		/*
		 * Button selected fill color to shape
		 */
		JButton btnFill = new JButton("Fillcolor");
		btnFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectShap = "fill";
			}
		});
		panel.add(btnFill);
		
		/*
		 * Button choose color
		 */
		JButton btnChooseColor = new JButton("Chose Color");
		btnChooseColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//selectShap = "ChooseColor";
				new ColorChoose();
			}
		});
		panel.add(btnChooseColor);
		
		/*
		 * Button move shape by mouse
		 */
		JButton btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "move";
			}
		});
		panel.add(btnMove);
		
		/*
		 * Button delete shape by mouse click
		 */
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectShap = "Delete";
			}
		});
		panel.add(btnDelete);
		
		/*
		 * Create Panel Color to select color
		 */
		JPanel pnlColor = new JPanel();
		pnlColor.setBackground(Color.darkGray);
		pnlColor.setSize(20, getHeight());
		contentPane.add(pnlColor, BorderLayout.SOUTH);
		
		
		/*
		 * Add another button color
		 */
		Dimension SizeColorBox = new Dimension(20, 20);
		
		JButton btnC_Red = new JButton();
		btnC_Red.setPreferredSize(SizeColorBox);
		btnC_Red.setBackground(Color.red);
		btnC_Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.red;
			}
		});
		pnlColor.add(btnC_Red);
		
		
		/*
		 * Add another button color
		 */
		JButton btnC_Blue = new JButton();
		btnC_Blue.setPreferredSize(SizeColorBox);
		btnC_Blue.setBackground(Color.blue);
		btnC_Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.blue;
			}
		});
		pnlColor.add(btnC_Blue);
		
		/*
		 * Add another button color
		 */
		JButton btnC_Green = new JButton();
		btnC_Green.setPreferredSize(SizeColorBox);
		btnC_Green.setBackground(Color.green);
		btnC_Green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.green;
			}
		});
		pnlColor.add(btnC_Green);
		
		/*
		 * Add another button color
		 */
		JButton btnC_Cyan = new JButton();
		btnC_Cyan.setPreferredSize(SizeColorBox);
		btnC_Cyan.setBackground(Color.cyan);
		btnC_Cyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.cyan;
			}
		});
		pnlColor.add(btnC_Cyan);
		
		/*
		 * Add another button color
		 */
		JButton btnC_DarkGray = new JButton();
		btnC_DarkGray.setPreferredSize(SizeColorBox);
		btnC_DarkGray.setBackground(Color.darkGray);
		btnC_DarkGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.darkGray;
			}
		});
		pnlColor.add(btnC_DarkGray);
		
		/*
		 * Add another button color
		 */
		JButton btnC_Orange = new JButton();
		btnC_Orange.setPreferredSize(SizeColorBox);
		btnC_Orange.setBackground(Color.orange);
		btnC_Orange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.orange;
			}
		});
		pnlColor.add(btnC_Orange);
		
		/*
		 * Add another button color
		 */
		JButton btnC_Pink = new JButton();
		btnC_Pink.setPreferredSize(SizeColorBox);
		btnC_Pink.setBackground(Color.pink);
		btnC_Pink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.pink;
			}
		});
		pnlColor.add(btnC_Pink);
		
		/*
		 * Add another button color
		 */
		JButton btnC_LightGray = new JButton();
		btnC_LightGray.setPreferredSize(SizeColorBox);
		btnC_LightGray.setBackground(Color.lightGray);
		btnC_LightGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectColor = Color.lightGray;
			}
		});
		pnlColor.add(btnC_LightGray);
		
		/*
		 * Create new Component paint to paint with mouse
		 */
		
		contentPane.add(new Paint_App(), BorderLayout.CENTER);
		validate();
	}
}
