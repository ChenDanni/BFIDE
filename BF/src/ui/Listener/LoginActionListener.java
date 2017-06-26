package ui.Listener;

import controller.UserController;
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
public class LoginActionListener implements ActionListener {

    UserController loginController;

    public LoginActionListener(MainFrame ui){
        loginController = new UserControllerImpl(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")){
            LoginPanel loginPanel = new LoginPanel();
            JPanel panel = loginPanel.getLoginPanel();
            int result = JOptionPane.showConfirmDialog(null,
                    panel,"login", JOptionPane.OK_CANCEL_OPTION,0,null);
            if (result == JOptionPane.OK_OPTION) {
                String name = loginPanel.getUsername();
                String pwd = loginPanel.getPassword();
                loginController.login(name,pwd);
            }
        }else if (e.getActionCommand().equals("Logout")){
            loginController.logout();
        }




    }
}
