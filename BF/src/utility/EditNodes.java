package utility;

import java.util.Stack;

/**
 * Created by cdn on 17/6/26.
 */
public class EditNodes {
    private static Stack<String> opts = new Stack<>();
    private static Stack<String> undos = new Stack<>();
    private static boolean afterUndo = false;

    private static boolean empty= false;


    public static void addNode(String content,boolean contentType){
        System.out.println(contentType);
        if (contentType){
            undos = new Stack<>();
        }
        if (content.equals("")) {
            empty = true;
            return;
        }else {
            empty = false;
        }

        opts.push(content);
        System.out.println("push " + content);
    }

    public static String getUndo(){

        if (opts.isEmpty()){
            return "";
        }
        String redo = opts.pop();
        undos.push(redo);
        if (opts.isEmpty())
            return "";
        String ret = opts.pop();
        return ret;
    }

    public static String getRedo(){
        System.out.println("redo");
        if (undos.isEmpty()){
            if (empty)
                return "";
            String ret = opts.pop();
            return ret;
        }
        String ret = undos.pop();
        return ret;
    }
}
