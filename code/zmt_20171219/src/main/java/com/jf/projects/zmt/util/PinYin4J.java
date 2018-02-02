package com.jf.projects.zmt.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYin4J {
	/**
     * 获取汉字串拼音，英文字符不变
     */
    public static String converterToSpell(String chines) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer pinyinName = new StringBuffer();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                pinyinName.append(PinyinHelper.toHanyuPinyinStringArray(nameChar[i], format)[0]);
            } else {
                pinyinName.append(nameChar[i]);
            }
        }
        return pinyinName.toString();
    }

    /**
     * 获取汉字串拼音首字母，英文字符不变
     */
    public static String converterToFirstSpell(String str) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer buffer = new StringBuffer();
        char[] cs = str.toCharArray();
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] > 128) {
                String[] str1 = PinyinHelper.toHanyuPinyinStringArray(cs[i], outputFormat);
                if (str1 != null) {
                    buffer.append(str1[0].charAt(0));
                }
            } else {
                buffer.append(cs[i]);
            }
        }
        return buffer.toString();
    }

    /**
     * 获取汉语首字母大写，英文也大写
     */
    public static String converterToFirstSpellUp(String str) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer buffer = new StringBuffer();
        char[] cs = str.toCharArray();
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] > 128) {
                String[] str1 = PinyinHelper.toHanyuPinyinStringArray(cs[i], outputFormat);
                if (str1 != null) {
                    buffer.append(str1[0].charAt(0));
                }
            } else {
                buffer.append(Character.toUpperCase(cs[i]));
            }
        }
        return buffer.toString();
    }

    /**
     * 获取汉语和英文全大写
     */
    public static String converterToSpellUp(String chines) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer pinyinName = new StringBuffer();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                pinyinName.append(PinyinHelper.toHanyuPinyinStringArray(nameChar[i], format)[0]);
            } else {
                pinyinName.append(nameChar[i]);
            }
        }
        return pinyinName.toString();
    }
}
