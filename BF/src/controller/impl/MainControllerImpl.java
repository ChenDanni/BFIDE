package controller.impl;

import controller.MainController;
import ui.MainFrame;
import utility.FILE_TYPE;

import javax.swing.*;

/**
 * Created by cdn on 17/6/22.
 */
public class MainControllerImpl implements MainController{

    private MainFrame ui;
    public MainControllerImpl(MainFrame ui){
        this.ui = ui;
    }

    @Override
    public void handleNew(FILE_TYPE type) {
        String tail = "";
        String hint = "";
        switch(type){
            case BF:
                tail = ".bf";
                hint = "new BF file";
                break;
            case OKK:
                tail = ".okk";
                hint = "new Ook! file";
                break;
            default:
                System.err.println("file name err");
        }

        String filename = (String) JOptionPane.showInputDialog(ui,hint,"file name") + tail;
        ui.setTitle(filename);
    }
}
