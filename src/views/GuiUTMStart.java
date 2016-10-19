package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiUTMStart {

	private JFrame frame;
	private JTextArea textAreaJavaSourceCode;
	private JTextArea textAreaUML;
	private JButton btnSelectUmlFile;
	private JButton btnSelectJava;
	private JButton btnStart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiUTMStart window = new GuiUTMStart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiUTMStart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					MoreInfo moreinfo = new MoreInfo();
					moreinfo.setModal(true);
					moreinfo.setVisible(true);
				
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		textAreaUML = new JTextArea();
		
		btnSelectUmlFile = new JButton("Select Your UML file");
		btnSelectUmlFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenFile of = new OpenFile();
				try {
					of.PickMe();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textAreaUML.setText(of.sb.toString());		
			}
		});
		
		btnSelectJava = new JButton("Select Your Java Source file");
		btnSelectJava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OpenFile of = new OpenFile();
				try {
					of.PickMe();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textAreaJavaSourceCode.setText(of.sb.toString());
			
			}
		});
		
		textAreaJavaSourceCode = new JTextArea();
		
		JLabel lblNewLabel = new JLabel("Welcome to Trace Magic");
		
		btnStart = new JButton("Start Trace");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
						frame.dispose();
						GuiUmlToJava output = new GuiUmlToJava();
						output.setVisible(true);
					
//						GuiJavaToUml output = new GuiJavaToUml();
//						output.setVisible(true);
					
//						System.out.printf("Please Import UML class file or Java Source file!");
//						GuiOutputUmlToJava output = new GuiOutputUmlToJava();
//						output.setVisible(true);	
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		
		
		btnStart.setIcon(new ImageIcon(GuiUTMStart.class.getResource("/resources/Magic_icon_16.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Start");
		lblNewLabel_1.setIcon(new ImageIcon(GuiUTMStart.class.getResource("/resources/Magic_icon_16.png")));
		
		JButton btnNewButton = new JButton("Trace UML file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					frame.dispose();
					GuiUmlToJava output = new GuiUmlToJava();
					output.setVisible(true);
			}catch(Exception e2){
				JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Trace Java Source file");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//frame.dispose();
					frame.setVisible(false); 
					GuiJavaToUml output = new GuiJavaToUml();
					output.setVisible(true);
			}catch(Exception e2){
				JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSelectUmlFile, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSelectJava, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(btnNewButton)
									.addGap(64)
									.addComponent(btnNewButton_1)))))
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(textAreaUML, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(textAreaJavaSourceCode, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(257, Short.MAX_VALUE)
					.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAreaUML, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAreaJavaSourceCode, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelectUmlFile)
						.addComponent(btnSelectJava))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_1))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
