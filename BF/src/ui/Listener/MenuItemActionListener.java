package ui.Listener;

import controller.MenuController;
import controller.impl.MenuControllerImpl;
import ui.MainFrame;
import utility.BFManager;
import utility.FILE_TYPE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cdn on 17/6/22.
 */
public class MenuItemActionListener implements ActionListener{
    MainFrame ui;
    MenuController mainController;
    public MenuItemActionListener(MainFrame ui){
        super();
        this.ui = ui;
        mainController = new MenuControllerImpl(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Open")) {
            mainController.handleOpen();
        } else if (cmd.equals("Save")) {
            mainController.handleSave();
        } else if (cmd.equals("Run")) {
            mainController.handleRun();
        } else if (cmd.equals(BFManager.newBFItem)){
            mainController.handleNew(FILE_TYPE.BF);
        } else if (cmd.equals(BFManager.newoOKItem)){
            mainController.handleNew(FILE_TYPE.OKK);
        }
    }
}
