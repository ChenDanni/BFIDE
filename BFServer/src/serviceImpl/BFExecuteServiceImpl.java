//请不要修改本文件名
package serviceImpl;

import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

public class BFExecuteServiceImpl implements ExecuteService {
	@Override
	public String execute(String code, String param) throws RemoteException {
		char cs[] = code.toCharArray();
		char ps[] = param.toCharArray();
		int p_c = 0,p_p = 0,max = 2048,len = cs.length;
		char content[] = new char[max];
		String ret = "";
//		System.out.println(ps.length);
		for (char c : content)
			c = 0;
		for (int i = 0;i < len;i++){
//			System.out.print(cs[i] + " ");
			switch(cs[i]){
				case '>':
					p_c++;
					break;
				case '<':
					p_c--;
					break;
				case '+':
					content[p_c]++;
					break;
				case '-':
					content[p_c]--;
					break;
				case '.':
					ret += content[p_c];
					break;
				case ',':
					content[p_c] = ps[p_p];
					p_p++;
					break;
				case '[':
					if (content[p_c] == 0){
						int tmp = 0;
						for (int j = i;j < len;j++){
							if (cs[j] == ']'){
								tmp--;
								if (tmp == 0){
									i = j - 1;
									break;
								}
							}else if (cs[j] == '[')
								tmp++;
						}
					}
					break;
				case ']':
					if (content[p_c] != 0){
						int tmp = 0;
						for (int j = i;j >= 0;j--){
							if (cs[j] == '['){
								tmp--;
								if (tmp == 0){
									i = j - 1;
									break;
								}
							}else if (cs[j] == ']')
								tmp++;
						}
					}
					break;
				default:
					return "compile error";
			}
//			System.out.println(" " + p_c + " : " + Integer.valueOf(content[0]) + "|" + Integer.valueOf(content[1]) + "|" + Integer.valueOf(content[2]) + "|" + Integer.valueOf(content[3]));
		}
		return ret;
	}

}
