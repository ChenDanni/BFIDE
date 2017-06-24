package controller.impl;

import controller.UserController;
import service.impl.UserServiceImpl;
import ui.MainFrame;
import utility.TmpHelper;

/**
 * Created by cdn on 17/6/24.
 */
public class UserControllerImpl implements UserController {

    private UserServiceImpl userService;
    private MainFrame ui;

    public UserControllerImpl(MainFrame ui){
        userService = new UserServiceImpl();
        this.ui = ui;
    }

    @Override
    public void login(String username, String password) {
        try{
            boolean res = userService.login(username,password);
            if (res){
                TmpHelper.updateCurrentUser(username);
                ui.setCurrentUser();
            }else{
                System.out.println("password incorrect");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
