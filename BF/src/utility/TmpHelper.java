package utility;

import java.io.*;

/**
 * Created by cdn on 17/6/24.
 */
public class TmpHelper {
    private static String userPath = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BF/src/tmp/user.txt";
    private static String filePath = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BF/src/tmp/file.txt";
    private static String getContent(String filepath){
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));
            String ret = br.readLine();
            br.close();
            return ret;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
    private static void updateContent(String filePath,String content){
        File f = new File(filePath);
        try {
            FileWriter fw = new FileWriter(f, false);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentUser(){
        return getContent(userPath);
    }
    public static String getCurrentFile(){
        return getContent(filePath);
    }


    public static void updateCurrentFile(String filename){
        updateContent(filePath,filename);
    }

    public static void updateCurrentUser(String user){
        updateContent(userPath,user);
    }

    public static boolean isLogin(){
        String user = getCurrentUser();
        if (user.equals("null")){
            return false;
        }else {
            return true;
        }
    }
}
