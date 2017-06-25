package controller.impl;

import controller.MenuController;
import rmi.RemoteHelper;
import service.ExecuteService;
import service.IOService;
import service.impl.ExecuteServiceImpl;
import service.impl.IOServiceImpl;
import ui.FileListPanel;
import ui.MainFrame;
import utility.FILE_TYPE;
import utility.TmpHelper;

import javax.swing.*;
import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class MenuControllerImpl implements MenuController {

    private static MainFrame ui;
    ExecuteService executeService;
    IOService ioService;
    public MenuControllerImpl(MainFrame ui){
        this.ui = ui;
        executeService = new ExecuteServiceImpl();
        ioService = new IOServiceImpl();
    }
    public MenuControllerImpl(){
        ioService = new IOServiceImpl();
    }
    @Override
    public void handleSave(){
        String code = ui.getContent();
        String filename = TmpHelper.getCurrentFile();
        String user = TmpHelper.getCurrentUser();
        try {
            ioService.writeFile(code,user,filename);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleRun() {
        String code = ui.getContent();
        String param = ui.getInput();
        String output = executeService.execute(code,param);
        ui.setOutput(output);
    }

    @Override
    public void handleOpen() {
        try {
            String files =  ioService.readFileList(TmpHelper.getCurrentUser());
            String[] s = files.split(" ");
            FileListPanel fileList = new FileListPanel(s);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleOpenFill(String filename) {
        System.out.println(TmpHelper.getCurrentUser() + "," + filename);
        try {
            String file = ioService.readFile(TmpHelper.getCurrentUser(),filename);
            ui.setContent(file);
        } catch (RemoteException e) {
            e.printStackTrace();
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
