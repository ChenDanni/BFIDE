package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cdn on 17/6/24.
 */
public class LoginPanel{
    private JPanel loginPanel;
    private JTextField username;
    private JTextField password;

    public LoginPanel(){
        loginPanel = new JPanel();
        username = new JTextField(15);
        password = new JTextField(15);
    }

    public String getUsername(){
        return username.getText();
    }
    public String getPassword(){
        return password.getText();
    }


    public JPanel getLoginPanel(){
        loginPanel.setLayout(new GridLayout(2,1));

        JPanel pu = new JPanel();
        pu.add(new JLabel("username"));
        pu.add(username);
        JPanel pp = new JPanel();
        pp.add(new JLabel("password"));
        pp.add(password);

        loginPanel.add(pu);
        loginPanel.add(pp);

        return loginPanel;
    }
}
