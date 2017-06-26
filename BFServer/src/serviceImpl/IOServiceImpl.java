package serviceImpl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import service.IOService;
import utility.FileHelper;

import static utility.FileHelper.checkDir;
import static utility.FileHelper.checkSave;

public class IOServiceImpl implements IOService{

	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		fileName = FileHelper.transSaveName(fileName);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FileHelper.dateFormat);
		String time = sdf.format(d);

		System.out.println("保存" + fileName + " " + time);

		String dir = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId + "/" + fileName;
		File f = new File(dir + "/" + time);

		checkDir(f);
		checkSave(dir);

		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String readFile(String userId, String fileName) {
		String path = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId + "/" + FileHelper.transSaveName(fileName);
		if (FileHelper.isDir(path)){
			System.out.println("path is a dir");
			String lastest = FileHelper.getLastestName(path);
			path = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId + "/" + FileHelper.transSaveName(fileName) +
					"/" + lastest;
		}
		File file = new File(path);
		Long filelength = file.length();
		byte[] ret = new byte[filelength.intValue()];
		String encoding = "ISO-8859-1";
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(ret);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(ret, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String readFileList(String userId) {

		String path = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId;
		File f = new File(path);
		String filenames = "";
		checkDir(f);
		File[] files = f.listFiles();
		for (File file : files){
			filenames += FileHelper.transReadName(file.getName()) + " ";
		}
		return filenames;
	}

	@Override
	public String[] getVersions(String userId, String fileName) {
		fileName = FileHelper.transSaveName(fileName);
		String path = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId + "/" + fileName;
		File f = new File(path);
		String filenames = "";
		checkDir(f);
		File[] files = f.listFiles();
		for (File file : files){
			filenames += FileHelper.transReadName(file.getName()) + " ";
		}
		return filenames.split(" ");
	}

}
