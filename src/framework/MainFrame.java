package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import objects.Human;

public class MainFrame {

	private JFrame mainFrame;
	
	private JPanel leftJPanel;
	private JPanel rightJPanel;
	
	private JPanel textPanel;			
	private JTextArea stroyTextArea;
			
	private JPanel characterPanel;
	private JList<Human> characterList;
		
	private JPanel buttonPanel;	
	private JButton goodButton;
	private JButton badButton;
	private JButton continueButton;
	
	private JPanel resourceJPanel;
	private JLabel fOODJLabel;			//food supply
	private JLabel rESOURCEJLabel;		//general resource
	private JLabel fPJLabel; 			//fighting power
	private JLabel tECHJLabel;    		//technology level
	private JLabel uNITYJLabel;			//prople's confidence
	
	
	private JScrollPane clistJScrollPane;
	
	protected ActionListener clickActionListener;
	
	private MainFrame() {
		
		mainFrame = new JFrame("Keeper");
		
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
		textPanel.setLayout(new BorderLayout());
		textPanel.setPreferredSize(new Dimension(700,450));
		textPanel.add(stroyTextArea);
		textPanel.setBorder(new TitledBorder("Story"));
		textPanel.setVisible(true);
		
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
		buttonPanel.setPreferredSize(new Dimension(700,125));
		buttonPanel.setBorder(new TitledBorder("Selections"));
		buttonPanel.add(goodButton);
		buttonPanel.add(badButton);
		buttonPanel.add(continueButton);
		buttonPanel.setVisible(true);
		
		leftJPanel.add(textPanel,BorderLayout.NORTH);
		leftJPanel.add(buttonPanel,BorderLayout.SOUTH);
		rightJPanel.add(characterPanel);
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(leftJPanel,BorderLayout.WEST);
		mainFrame.add(rightJPanel,BorderLayout.EAST);
		mainFrame.setSize(1000,618);
		
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
//		stroyTextArea.append("normal");

		stroyTextArea.append("\n");
		
	}

	private void Do_sth_bad() {
		// TODO Display the story
//		stroyTextArea.append("bad");

		stroyTextArea.append("\n");
		
	}

	private void Do_sth_good() {
		// TODO Display the story
//		stroyTextArea.append("good");

		stroyTextArea.append("\n");
		
	}
	
	
	public static void main(String args[]) {
		new MainFrame();
	}
	
}
