package ui;
import ui.Listener.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.*;

import rmi.RemoteHelper;
import utility.BFManager;

public class MainFrame extends JFrame {
	private JTextArea textArea;
	private JLabel resultLabel;
	JFrame frame;

	private void initEditArea(){
		textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setBackground(Color.LIGHT_GRAY);
	}
	private JPanel initInputOutput(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JTextArea input = new JTextArea();
		JTextArea output = new JTextArea();
		input.setMargin(new Insets(10, 10, 10, 10));
		output.setMargin(new Insets(10, 10, 10, 10));
		input.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		output.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.add(input);
		panel.add(output);
		return panel;
	}
	private JMenuBar initMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu newMenuItem = new JMenu("New");
		JMenuItem newBFItem = new JMenuItem(BFManager.newBFItem);
		JMenuItem newoOKItem = new JMenuItem(BFManager.newoOKItem);
		newMenuItem.add(newBFItem);
		newMenuItem.add(newoOKItem);
		fileMenu.add(newMenuItem);
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		JMenuItem saveMenuItem = new JMenuItem("Save");
		fileMenu.add(saveMenuItem);
		JMenuItem runMenuItem = new JMenuItem("Run");
		fileMenu.add(runMenuItem);

		newBFItem.addActionListener(new MenuItemActionListener(this));
		newoOKItem.addActionListener(new MenuItemActionListener(this));
		openMenuItem.addActionListener(new MenuItemActionListener(this));
		saveMenuItem.addActionListener(new SaveActionListener());
		runMenuItem.addActionListener(new MenuItemActionListener(this));


		JMenu versionMenu = new JMenu("Version");
		JButton runButton = new JButton("run");
		JButton login = new JButton("Login");

		menuBar.add(fileMenu);
		menuBar.add(versionMenu);
		menuBar.add(runButton);
		menuBar.add(login);
		return menuBar;
	}

	public void setTitle(String title){
		frame.setTitle(title);
	}

	public MainFrame() {
		// 创建窗体
		frame = new JFrame("BF Client");
		frame.setLayout(new BorderLayout());

		JMenuBar menuBar = initMenuBar();
		initEditArea();
		JPanel ioArea = initInputOutput();

		frame.setJMenuBar(menuBar);
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(ioArea,BorderLayout.SOUTH);

		// 显示结果
//		resultLabel = new JLabel();
//		resultLabel.setText("result");
//		frame.add(resultLabel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocation(400, 200);
		frame.setVisible(true);
	}

}