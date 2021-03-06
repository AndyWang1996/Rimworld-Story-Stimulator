package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.xml.stream.events.StartDocument;

import fitness.Dice;
import fitness.EventList;
import objects.Human;
import objects.Weapon;

public class MainFrame {

	private JFrame mainFrame;
	
	private JPanel leftJPanel;
	private JPanel rightJPanel;
	
	private JPanel textPanel;
	private JScrollPane container;
	public static JTextArea stroyTextArea;
			
	private JPanel characterPanel;
		
	private JPanel buttonPanel;	
	private JButton goodButton;
	private JButton badButton;
	private JButton continueButton;
	
	private JPanel resourceJPanel;
	
	private static JLabel fOODJLabel;			//food supply
	public static int FOOD = 0;
	
	private static JLabel tECHJLabel;    		//process level
	public static int PRO = 0;
	
	private static JLabel uNITYJLabel;			//prople's confidence
	public static int UNITY = 0;
	
	private JScrollPane clistJScrollPane;
	
	protected ActionListener clickActionListener;
	
	public static EventList globaList;
	
	public static List<Human> characList = new ArrayList<Human>();
	
	public static DefaultListModel<String> nameList;
	
	public static JList<String> displayList;
	
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
		tECHJLabel = new JLabel();
		tECHJLabel.setText("PROCESS: " + Integer.toString(PRO));
		uNITYJLabel = new JLabel();
		uNITYJLabel.setText("UNITY: " + Integer.toString(UNITY));
		resourceJPanel.add(fOODJLabel);
		resourceJPanel.add(tECHJLabel);
		resourceJPanel.add(uNITYJLabel);
		resourceJPanel.setPreferredSize(new Dimension(700,70));
		resourceJPanel.setVisible(true);
		
		characterPanel = new JPanel();
		nameList = new DefaultListModel<>();
		displayList = new JList<>(nameList);
		
		characterPanel.setLayout(new GridLayout(1,1));
		clistJScrollPane = new JScrollPane(displayList);
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
					try {
						Do_sth_good();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if (e.getActionCommand().equals("BAD")) {
					try {
						Do_sth_bad();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if (e.getActionCommand().equals("GO ON")) {
					try {
						Do_sth_normal();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		};
		
		badButton.addActionListener(clickActionListener);
		goodButton.addActionListener(clickActionListener);
		continueButton.addActionListener(clickActionListener);
		
		mainFrame.setVisible(true);
		
		Start();
		
	}
	
	private void Start() {
		// TODO Auto-generated method stub
		Human firstHuman = new Human();
		firstHuman = firstHuman.create_character("detective");
//		firstHuman.display_this_guy();
		characList.add(firstHuman);
		nameList.addElement(firstHuman.get_FullName());
		globaList =  new EventList("normal");
		//初始化一个情景，创建初始人物
		stroyTextArea.append("{name} is an explorer from rimworld. who decided to explore forward and find a way to the \"civilized world\"".replace("{name}", firstHuman.get_FullName()));
		stroyTextArea.append("\n");
		FOOD = 15;
		UNITY = 20;
		PRO = 0;
	}

	private void Do_sth_normal() throws IOException {
		// TODO Display the story
		globaList.swap_flag("normal");
		globaList.excute_Eventlist(stroyTextArea, characList);
		refresh_status();
//		Weapon.test();
//		fOODJLabel.setText("FOOD:" + Integer.toString(FOOD));	
	}

	private void Do_sth_bad() throws IOException {
		// TODO Display the story
		globaList.swap_flag("bad");
		globaList.excute_Eventlist(stroyTextArea, characList);
		refresh_status();
	}

	private void Do_sth_good() throws IOException {
		// TODO Display the story
		globaList.swap_flag("good");
		globaList.excute_Eventlist(stroyTextArea, characList);	
		refresh_status();
	}
	
	public static void refresh_status() {
		fOODJLabel.setText("FOOD:" + Integer.toString(FOOD));
		tECHJLabel.setText("PROCESS:" + Integer.toString(PRO));
		uNITYJLabel.setText("UNITY:" + Integer.toString(UNITY));
	}
	
	public void pause(long num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JTextArea geTextArea() {
		return stroyTextArea;
	}
	
	
	public static void main(String args[]) {
		new MainFrame();
	}
	
}
