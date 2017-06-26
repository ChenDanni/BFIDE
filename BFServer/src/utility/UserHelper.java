package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by cdn on 17/6/26.
 */
public class UserHelper {

    private static String accountsPath = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/sysFile/accounts.txt";

    public static String getPwd(String username){
        String pwd = "";
        boolean find = false;
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(accountsPath)));
            String line = "";

            while((line = br.readLine()) != null){
                String[] account = line.split(",");
                if (username.equals(account[0])){
                    pwd = account[1];
                    find = true;
                    break;
                }
            }
            br.close();
            if (find){
                return pwd;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
