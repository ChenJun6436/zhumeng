package com.jf.projects.zmt.util;

import java.util.UUID;

public class UUIDUtil {
	public UUIDUtil() {
	}

	public static String getUUID() {
		UUID uuid1 = UUID.randomUUID();
		String str = uuid1.toString();
		return str.replaceAll("-", "");
	}
	
	
	/*public static void main(String[] args){
	    System.out.println(UUID.randomUUID());
	}*/
}
