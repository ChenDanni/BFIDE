package controller.impl;

import controller.MenuController;
import rmi.RemoteHelper;
import ui.MainFrame;
import utility.FILE_TYPE;
import utility.TmpHelper;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class MenuControllerImpl implements MenuController {

    private MainFrame ui;
    public MenuControllerImpl(MainFrame ui){
        this.ui = ui;
    }

    public void handleSave(){
        String code = ui.getContent();
        String filename = TmpHelper.getCurrentFile();
        String user = TmpHelper.getCurrentUser();

        try {
            RemoteHelper.getInstance().getIOService().writeFile(code, user, filename);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
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
        TmpHelper.updateCurrentFile(filename);
        ui.setTitle(filename);
    }
}
