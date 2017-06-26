package ui;
import ui.Listener.*;
import java.awt.*;
import javax.swing.*;
import utility.BFManager;
import utility.TmpHelper;

public class MainFrame extends JFrame {
	private JTextArea textArea;
	JFrame frame;
	JLabel currentUser;
	JTextArea input;
	JTextArea output;
	JButton login;
	JMenu versionMenu;
	String login_info = "Login";
	String logout_info = "Logout";
	JButton undo;
	JButton redo;
	public boolean contentType;

	private void initEditArea(){
		textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.getDocument().addDocumentListener(new EditAreaListener(this));
	}
	private JPanel initInputOutput(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		input = new JTextArea();
		output = new JTextArea();
		input.setMargin(new Insets(10, 10, 10, 10));
		output.setMargin(new Insets(10, 10, 10, 10));
		input.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		output.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.add(input);
		panel.add(output);
		return panel;
	}
	private void initCurrentUser(){
		String user = TmpHelper.getCurrentUser();
		if (user.equals("null")){
			System.out.println("username is null");
			user = "";
		}
		currentUser.setText(user);
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
		saveMenuItem.addActionListener(new MenuItemActionListener(this));
		runMenuItem.addActionListener(new MenuItemActionListener(this));


		versionMenu = new JMenu("Version");
		versionMenu.addMenuListener(new VersionActionListener());

		if (TmpHelper.isLogin()){
			login.setText(logout_info);
		}else {
			login.setText(login_info);
		}


		login.addActionListener(new MenuBarActionListener(this));
		undo.addActionListener(new MenuBarActionListener(this));
		redo.addActionListener(new MenuBarActionListener(this));

		menuBar.add(fileMenu);
		menuBar.add(versionMenu);
		menuBar.add(login);
		menuBar.add(undo);
		menuBar.add(redo);
		initCurrentUser();
		menuBar.add(currentUser);
		return menuBar;
	}

	public void setTitle(String title){
		frame.setTitle(title);
	}

	public void setCurrentUser(){
		initCurrentUser();
	}

	public String getInput(){
		return input.getText();
	}

	public void setOutput(String output){
		this.output.setText(output);
	}

	public String getContent(){
		return textArea.getText();
	}

	public void updateVersions(String[] versions){
		versionMenu.removeAll();
		VersionItemListener versionItemListener = new VersionItemListener();
		for (String v : versions){
			JMenuItem version = new JMenuItem(v);
			version.addActionListener(versionItemListener);
			versionMenu.add(version);
		}
	}

	public void setContent(String content){
		textArea.setText(content);
	}

	public void setLogState(){
		if (login.getText().equals(login_info)){
			login.setText(logout_info);
		}else {
			login.setText(login_info);
		}
	}

	public MainFrame() {
		//初始化组件
		currentUser = new JLabel();
		login = new JButton();
		undo = new JButton("undo");
		redo = new JButton("redo");
		contentType = true;

		// 创建窗体
		frame = new JFrame("BF Client");
		frame.setLayout(new BorderLayout());

		JMenuBar menuBar = initMenuBar();
		initEditArea();
		JPanel ioArea = initInputOutput();


		frame.setJMenuBar(menuBar);
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(ioArea,BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
