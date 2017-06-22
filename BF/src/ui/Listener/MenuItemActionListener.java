package ui.Listener;

import controller.MainController;
import controller.impl.MainControllerImpl;
import ui.MainFrame;
import utility.BFManager;
import utility.FILE_TYPE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cdn on 17/6/22.
 */
public class MenuItemActionListener implements ActionListener{
//    MainController controller = new Ma
    MainFrame ui;
    MainController mainController;
    public MenuItemActionListener(MainFrame ui){
        super();
        this.ui = ui;
        mainController = new MainControllerImpl(ui);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Open")) {

        } else if (cmd.equals("Save")) {

        } else if (cmd.equals("Run")) {

        } else if (cmd.equals(BFManager.newBFItem)){
            mainController.handleNew(FILE_TYPE.BF);
        } else if (cmd.equals(BFManager.newoOKItem)){
            mainController.handleNew(FILE_TYPE.OKK);
        }
    }
}
