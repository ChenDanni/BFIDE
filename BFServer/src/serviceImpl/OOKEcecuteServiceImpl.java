package serviceImpl;

import service.ExecuteService;

import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/25.
 */
public class OOKEcecuteServiceImpl implements ExecuteService{
    @Override
    public String execute(String code, String param) throws RemoteException {

        String cs[] = code.split(" ");
        char ps[] = param.toCharArray();
        int p_c = 0,p_p = 0,max = 2048;
        char content[] = new char[max];
        String ret = "";
        int len = cs.length/2;
//		if (len > max)
//			return "too long code";
        for (char c : content){
            c = 0;
        }

        if (cs.length % 2 != 0)
            return "complie error";
        for (int i = 0;i < len;i++){
            int i1 = 2*i, i2 = i1 + 1;
            if (cs[i1].equals("Ook.")){
                if (cs[i2].equals("Ook?")){
                    p_c++;
                }else if (cs[i2].equals("Ook.")){
                    content[p_c]++;
                }else if (cs[i2].equals("Ook!")){
                    content[p_c] = ps[p_p];
                    p_p++;
                }
            }else if (cs[i1].equals("Ook?")){
                if (cs[i2].equals("Ook.")){
                    p_c--;
                }else if (cs[i2].equals("Ook!")){
//					System.out.println(" ] " + cs[i1] + ":" + cs[i2] + "  " + Integer.valueOf(content[p_c]));
                    if (content[p_c] != 0){
                        int tmp = 0;
                        for (int j = i;j >= 0;j--){
                            if (cs[2*j].equals("Ook!") && cs[2*j + 1].equals("Ook?")){
                                tmp--;
                                if (tmp == 0){
                                    i = j - 1;
                                    break;
                                }
                            }else if (cs[2*j].equals("Ook?") && cs[2*j + 1].equals("Ook!")){
                                tmp++;
                            }
                        }
                    }
                }
            }else if (cs[i1].equals("Ook!")){
                if (cs[i2].equals("Ook!")){
                    content[p_c]--;
                }else if (cs[i2].equals("Ook.")){
                    ret += content[p_c];
                }else if (cs[i2].equals("Ook?")){
//					System.out.println(cs[i1] + ":" + cs[i2] + "  " + Integer.valueOf(content[p_c]));
                    if (content[p_c] == 0){
                        int tmp = 0;
                        for (int j = i;j < len;j++){
                            if (cs[2*j].equals("Ook?") && cs[2*j + 1].equals("Ook!")){
                                tmp--;
                                if (tmp == 0){
                                    i = j - 1;
                                    break;
                                }
                            }else if (cs[2*j].equals("Ook!") && cs[2*j + 1].equals("Ook?")){
                                tmp++;
                            }
                        }
                    }
                }
            }else {
                return "compile error";
            }
        }
        return ret;
    }
}
