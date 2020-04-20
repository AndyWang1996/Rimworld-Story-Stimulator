package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import objects.Human;

public class MainFrame {

	private JFrame mainFrame;
	
	private JPanel leftJPanel;
	private JPanel rightJPanel;
	
	private JPanel textPanel;
	private JScrollPane container;
	public static JTextArea stroyTextArea;
			
	private JPanel characterPanel;
	private JList<Human> characterList;
		
	private JPanel buttonPanel;	
	private JButton goodButton;
	private JButton badButton;
	private JButton continueButton;
	
	private JPanel resourceJPanel;
	
	private JLabel fOODJLabel;			//food supply
	public static int FOOD = 0;
	
	private JLabel rESOURCEJLabel;		//general resource
	public static int RESOURCE = 0;
	
	private JLabel tECHJLabel;    		//technology level
	public static int TEC = 0;
	
	private JLabel uNITYJLabel;			//prople's confidence
	public static int UNITY = 0;
	
	
	private JScrollPane clistJScrollPane;
	
	protected ActionListener clickActionListener;
	
	private MainFrame() {
		
		mainFrame = new JFrame("Keeper");
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);// exit
			}
		});
		
		leftJPanel = new JPanel();
		leftJPanel.setLayout(new BorderLayout());
		leftJPanel.setPreferredSize(new Dimension(780,600));
//		leftJPanel.setSize(new Dimension(400,600));
		rightJPanel = new JPanel();
		rightJPanel.setLayout(new BorderLayout());
		rightJPanel.setPreferredSize(new Dimension(200,600));
//		rightJPanel.setSize(new Dimension(100,600));
		
		textPanel = new JPanel();
		stroyTextArea = new JTextArea();
		stroyTextArea.setEditable(false);
		stroyTextArea.setVisible(true);
		stroyTextArea.setForeground(Color.blue);
		container = new JScrollPane(stroyTextArea);
		textPanel.setLayout(new BorderLayout());
		textPanel.setPreferredSize(new Dimension(700,450));
		textPanel.add(container);
		textPanel.setBorder(new TitledBorder("Story"));
		textPanel.setVisible(true);
		
		resourceJPanel = new JPanel();
		resourceJPanel.setLayout(new GridLayout(1,3));
		resourceJPanel.setBorder(new TitledBorder("STATUS"));
		fOODJLabel = new JLabel();
		fOODJLabel.setText("FOOD: " + Integer.toString(FOOD));
		rESOURCEJLabel = new JLabel();
		rESOURCEJLabel.setText("RESOURCE: " + Integer.toString(RESOURCE));
		tECHJLabel = new JLabel();
		tECHJLabel.setText("TECH: " + Integer.toString(TEC));
		uNITYJLabel = new JLabel();
		uNITYJLabel.setText("UNITY: " + Integer.toString(UNITY));
		resourceJPanel.add(fOODJLabel);
		resourceJPanel.add(rESOURCEJLabel);
		resourceJPanel.add(tECHJLabel);
		resourceJPanel.add(uNITYJLabel);
		resourceJPanel.setPreferredSize(new Dimension(700,70));
		resourceJPanel.setVisible(true);
		
		characterPanel = new JPanel();
		characterList = new JList<Human>();
		
		characterPanel.setLayout(new GridLayout(1,1));
		clistJScrollPane = new JScrollPane(characterList);
		characterPanel.add(clistJScrollPane);
		characterPanel.setBorder(new TitledBorder("Characters"));
		characterPanel.setVisible(true);
		
		buttonPanel = new JPanel();
		goodButton = new JButton("GOOD");
		badButton = new JButton("BAD");
		continueButton = new JButton("GO ON");
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.setPreferredSize(new Dimension(700,100));
		buttonPanel.setBorder(new TitledBorder("Selections"));
		buttonPanel.add(goodButton);
		buttonPanel.add(badButton);
		buttonPanel.add(continueButton);
		buttonPanel.setVisible(true);
		
		leftJPanel.add(textPanel,BorderLayout.NORTH);
		leftJPanel.add(resourceJPanel,BorderLayout.CENTER);
		leftJPanel.add(buttonPanel,BorderLayout.SOUTH);
		rightJPanel.add(characterPanel);
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(leftJPanel,BorderLayout.WEST);
		mainFrame.add(rightJPanel,BorderLayout.EAST);
		mainFrame.setSize(1000,650);
		
		clickActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.print(e + "\n");
				if (e.getActionCommand().equals("GOOD")) {
					Do_sth_good();
				}
				else if (e.getActionCommand().equals("BAD")) {
					Do_sth_bad();
				}
				else if (e.getActionCommand().equals("GO ON")) {
					Do_sth_normal();
				}
			}

		};
		
		badButton.addActionListener(clickActionListener);
		goodButton.addActionListener(clickActionListener);
		continueButton.addActionListener(clickActionListener);
		
		mainFrame.setVisible(true);
		
	}
	
	private void Do_sth_normal() {
		// TODO Display the story
		stroyTextArea.append("normal");
		refresh_status(1, 2, 3, 4);
		stroyTextArea.append("\n");
		
	}

	private void Do_sth_bad() {
		// TODO Display the story
		stroyTextArea.append("bad");
		refresh_status(4, 3, 2, 1);
		stroyTextArea.append("\n");
		
	}

	private void Do_sth_good() {
		// TODO Display the story
		stroyTextArea.append("good");
		refresh_status(1, 4, 3, 2);
		stroyTextArea.append("\n");
		
	}
	
	public void refresh_status(int fp, int rp, int tp, int up) {
		FOOD += fp;
		RESOURCE += rp;
		TEC += tp;
		UNITY += up;
		
		fOODJLabel.setText("FOOD:" + Integer.toString(FOOD));
		rESOURCEJLabel.setText("RESOURCE:" + Integer.toString(RESOURCE));
		tECHJLabel.setText("TEC:" + Integer.toString(TEC));
		uNITYJLabel.setText("UNITY:" + Integer.toString(UNITY));
	}
	
	public static JTextArea geTextArea() {
		return stroyTextArea;
	}
	
	
	public static void main(String args[]) {
		new MainFrame();
	}
	
}
