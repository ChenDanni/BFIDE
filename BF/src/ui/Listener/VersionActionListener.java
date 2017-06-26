package ui.Listener;

import controller.MenuController;
import controller.impl.MenuControllerImpl;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cdn on 17/6/26.
 */
public class VersionActionListener implements MenuListener {

    MenuController mainController;
    public VersionActionListener(){
        mainController = new MenuControllerImpl();
    }

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("in version listener");
        mainController.handleVersion();
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
