package ui.Listener;

import controller.ContentController;
import controller.MenuController;
import controller.UserController;
import controller.impl.ContentControllerImpl;
import controller.impl.MenuControllerImpl;
import sun.applet.Main;
import ui.MainFrame;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created by cdn on 17/6/26.
 */
public class EditAreaListener implements DocumentListener {

    ContentController contentController;
    MainFrame ui;

    public EditAreaListener(MainFrame ui) {
        this.ui = ui;
        contentController = new ContentControllerImpl();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert");
        contentController.monitorEditArea(ui.contentType);
        ui.contentType = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove");
        contentController.monitorEditArea(ui.contentType);
//        ui.contentType = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("change");
    }
}
