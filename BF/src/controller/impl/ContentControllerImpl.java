package controller.impl;

import controller.ContentController;
import ui.MainFrame;
import utility.EditNodes;

/**
 * Created by cdn on 17/6/26.
 */
public class ContentControllerImpl implements ContentController {
    static MainFrame ui;

    public ContentControllerImpl(MainFrame ui){
        this.ui = ui;
    }

    public ContentControllerImpl(){}

    @Override
    public void monitorEditArea(boolean contentType) {
        String code = ui.getContent();
        EditNodes.addNode(code,contentType);
    }

    @Override
    public void undo() {
        String code = EditNodes.getUndo();
        System.out.println("set content------");
        ui.contentType = false;
        ui.setContent(code);
    }

    @Override
    public void redo() {
        String code = EditNodes.getRedo();
        ui.contentType = false;
        ui.setContent(code);
    }
}
