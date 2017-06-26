package ui.Listener;

import controller.MenuController;
import controller.impl.MenuControllerImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cdn on 17/6/26.
 */
public class VersionItemListener implements ActionListener {

    MenuController mainController;

    public VersionItemListener(){
        mainController = new MenuControllerImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String time = e.getActionCommand();
        mainController.handleVersionGet(time);
    }
}
