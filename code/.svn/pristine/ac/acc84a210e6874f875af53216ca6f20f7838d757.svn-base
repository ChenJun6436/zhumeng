package com.jf.projects.zmt.util;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 八位段uuid生成作为生猪标签
 * 
 * @className:
 * 
 * @description:
 * 
 * @author wzw
 * 
 * @date 2017年12月25日
 * 
 */
public class SignGenerator {
	public String code = "";

	public SignGenerator(String code) {
		super();
		this.code = code;
	}

	public ArrayList<String> signPool = new ArrayList<>();
	public String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g",
			"h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		shortBuffer.append(code).append("-");
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3a]);
		}

		return shortBuffer.toString();

	}

	public ArrayList<String> getSign() {
		for (int i = 0; i <= 100; i++) {
			signPool.add(generateShortUuid());
		}
		return signPool;
	}

	public static void main(String[] args) {
		SignGenerator signGenerator = new SignGenerator("111111");
		System.out.println(signGenerator.getSign());
	}
}
