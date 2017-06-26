package ui.Listener;

import controller.ContentController;
import controller.UserController;
import controller.impl.ContentControllerImpl;
import controller.impl.UserControllerImpl;
import ui.LoginPanel;
import ui.MainFrame;
import utility.TmpHelper;

import javax.swing.*;
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
            int result = JOptionPane.showConfirmDialog(null,
                    panel,"login", JOptionPane.OK_CANCEL_OPTION,0,null);
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
