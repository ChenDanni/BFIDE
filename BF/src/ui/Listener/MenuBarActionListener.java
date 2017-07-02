package ui.Listener;

import controller.ContentController;
import controller.UserController;
import controller.impl.ContentControllerImpl;
import controller.impl.UserControllerImpl;
import ui.LoginPanel;
import ui.MainFrame;
import utility.TmpHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cdn on 17/6/24.
 */
public class MenuBarActionListener implements ActionListener {

    UserController loginController;
    ContentController contentController;
    static MainFrame ui;

    public MenuBarActionListener(MainFrame ui){
        this.ui = ui;
        loginController = new UserControllerImpl(ui);
        contentController = new ContentControllerImpl(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Login")){
            LoginPanel loginPanel = new LoginPanel();
            JPanel panel = loginPanel.getLoginPanel();
            ImageIcon ico = new ImageIcon("/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BF/src/resourses/img/avatar.gif");
            ico.setImage(ico.getImage().getScaledInstance(65,65, Image.SCALE_DEFAULT));
            int result = JOptionPane.showConfirmDialog(null,
                    panel,"login", JOptionPane.OK_CANCEL_OPTION,0,ico);
            if (result == JOptionPane.OK_OPTION) {
                String name = loginPanel.getUsername();
                String pwd = loginPanel.getPassword();
                loginController.login(name,pwd);
            }
        }else if (cmd.equals("Logout")){
            loginController.logout();
        }else if (cmd.equals("undo")){
            contentController.undo();
        }else if (cmd.equals("redo")){
            contentController.redo();
        }
    }
}
