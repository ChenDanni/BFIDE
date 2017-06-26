package utility;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cdn on 17/6/26.
 */
public class FileHelper {

    public static String dateFormat = "yyyy-MM-dd-HH:mm:ss";

    public static int maxVersion = 4;

    public static String transSaveName(String name){
        return name.replace('.','_');
    }
    public static String transReadName(String name){
        return name.replace('_','.');
    }

    private static ArrayList<Date> sortDates(String dir){
        File f = new File(dir);
        File[] files = f.listFiles();
        ArrayList<Date> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(FileHelper.dateFormat);
        for (File file : files){
            try {
                Date date = sdf.parse(file.getName());
                dates.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0;i < dates.size();i++){
            for (int j = 0;j < dates.size() - i - 1;j++){
                if (dates.get(j).before(dates.get(j + 1))){
                    Date tmp = dates.get(j);
                    dates.set(j,dates.get(j + 1));
                    dates.set(j + 1,tmp);
                }
            }
        }
        return dates;
    }


    public static String getLastestName(String dir){
        SimpleDateFormat sdf = new SimpleDateFormat(FileHelper.dateFormat);
        ArrayList<Date> dates = sortDates(dir);
        if (dates.size() == 0)
            return "";
        return sdf.format(dates.get(0));
    }

    private static String getEarlistName(String dir){
        SimpleDateFormat sdf = new SimpleDateFormat(FileHelper.dateFormat);
        ArrayList<Date> dates = sortDates(dir);
        if (dates.size() == 0)
            return "";
        return sdf.format(dates.get(dates.size() - 1));
    }

    public static boolean isDir(String path){
        File f = new File(path);
        return f.isDirectory();
    }
    public static void checkDir(File f){
        if(!f.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if(!f.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
            }
        }
    }

    public static void checkSave(String dir){
        File f = new File(dir);
        File[] fs = f.listFiles();
        if (fs.length >= maxVersion){
            String re = getEarlistName(dir);
            File delete = new File(dir + "/" + re);
            delete.delete();
        }



    }

}
