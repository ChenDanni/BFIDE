package serviceImpl;

import java.io.*;

import service.IOService;

public class IOServiceImpl implements IOService{

	public void checkDir(File f){
		if(!f.getParentFile().exists()) {
			//如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if(!f.getParentFile().mkdirs()) {
				System.out.println("创建目标文件所在目录失败！");
			}
		}
	}

	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		File f = new File("/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId + "/" + fileName);

		checkDir(f);

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

		String path = "/Users/user/Documents/un/s7/CSI/大作业/BFIDE/BFServer/src/file/" + userId + "/" + fileName;
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
			filenames += file.getName() + " ";
		}
		return filenames;
	}
	
}
