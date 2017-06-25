package ui.Listener;

import controller.MenuController;
import controller.impl.MenuControllerImpl;
import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by cdn on 17/6/25.
 */
public class FileOpenActionListener implements MouseListener{

    private String file;
    private JFrame fileListFrame;
    private MenuController menuController;

    public FileOpenActionListener(JFrame frame){
        file = "";
        fileListFrame = frame;
        menuController = new MenuControllerImpl();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JButton){
            String choice = ((JButton) e.getSource()).getText();
            fileListFrame.setVisible(false);
            if (choice.equals("OK")){
                menuController.handleOpenFill(file);
            }

        }else if (e.getSource() instanceof JLabel){
            ((JLabel) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.black));
            file = ((JLabel) e.getSource()).getText();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
