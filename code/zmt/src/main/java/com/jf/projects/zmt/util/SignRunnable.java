package com.jf.projects.zmt.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SignRunnable implements Runnable {

	public List<String> signPool;
	public String pathsString;
	public String format;

	public SignRunnable(List<String> signPool, String pathsString, String format) {
		super();
		this.signPool = signPool;
		this.pathsString = pathsString;
		this.format = format;
	}

	@Override
	public void run() {
		for (String string : signPool) {
			File outputFile = new File(pathsString + File.separator
					+ "code_img" + File.separator + string + ".jpg");
			try {
				ZxingTool.writeToFile(ZxingTool.encodeQRcode(string, 110, 110),
						format, outputFile);
				ZxingTool.pressText(string, outputFile, 5, Color.black, 11);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
