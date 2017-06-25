package controller;

import utility.FILE_TYPE;

/**
 * Created by cdn on 17/6/22.
 */
public interface MenuController {
    public void handleNew(FILE_TYPE type);

    public void handleSave();

    public void handleRun();

    public void handleOpen();

    public void handleOpenFill(String filename);

}
