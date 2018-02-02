package util;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class CreateCodeUtil{
	static ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<String>();
	public static String newCode(){
		String newCode =null;
			 do{
				 String code = MD5Util.MD5(String.valueOf(Math.random()));			
					newCode =code.substring(code.length()-6);
		           }while(set.contains(newCode));
			set.add(newCode);
		return newCode;
	}
	public static void AddAll(List<String> list){
		set.addAll(list);
	}
	public static Set<String> getSetAll(){
		return set;
	}
}
