package ui.Listener;

import rmi.RemoteHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class SaveActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
//        String code = textArea.getText();
        String code = "";
        try {
            RemoteHelper.getInstance().getIOService().writeFile(code, "admin", "code");
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }
}
