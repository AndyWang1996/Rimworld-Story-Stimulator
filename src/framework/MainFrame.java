package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
	
	private MainFrame() {
		
		mainFrame = new JFrame("Keeper");
		
		leftJPanel = new JPanel();
		leftJPanel.setLayout(new GridLayout(2,1));
		rightJPanel = new JPanel();
		rightJPanel.setLayout(new GridLayout(1,1));;
		
		textPanel = new JPanel();
		stroyTextArea = new JTextArea();
		stroyTextArea.setEditable(false);
		stroyTextArea.setVisible(true);
		stroyTextArea.setForeground(Color.blue);
		textPanel.setLayout(new GridLayout(1,1));
		textPanel.add(stroyTextArea);
		textPanel.setVisible(true);
		
		characterPanel = new JPanel();
		characterList = new JList<Human>();
		characterPanel.setLayout(new GridLayout(1,1));
		characterPanel.add(characterList);
		characterPanel.setVisible(true);
		
		buttonPanel = new JPanel();
		goodButton = new JButton("GOOD");
		badButton = new JButton("BAD");
		continueButton = new JButton("GO ON");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(goodButton);
		buttonPanel.add(badButton);
		buttonPanel.add(continueButton);
		buttonPanel.setVisible(true);
		
		leftJPanel.add(textPanel);
		leftJPanel.add(buttonPanel);
		leftJPanel.setPreferredSize(new Dimension(400,600));
		rightJPanel.add(characterPanel);
		
		mainFrame.setLayout(new GridLayout(1,2));
		mainFrame.add(leftJPanel);
		mainFrame.add(rightJPanel);
		mainFrame.setSize(500,600);
		
		mainFrame.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		new MainFrame();
	}
	
}
