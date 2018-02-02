package com.jf.projects.zmt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import org.springframework.util.StringUtils;

/**
 * @className: CommonUtil
 * @description:公共工具类
 * @author wj
 * @date 2017年10月25日下午5:06:46
 */
public class CommonUtil {

    public static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static final int MONEYUPPERLIMIT = 300000;

    /*
     * public static void main(String[] args){
     * // System.out.println(getRandomNum(4));
     * System.out.println(UUID.randomUUID().toString());
     * }
     */

    /**
     * 获取0-9的num位随机数
     * 
     * @param num
     * @return
     */
    public static String getRandomNum(Integer num) {
        StringBuffer str = new StringBuffer();
        try {
            for (int i = 0; i < num; i++) {
                int random = (int) (Math.random() * 10);
                str.append(random);
            }

        } catch (Exception e) {
            return null;
        }
        return str.toString();
    }

    /**
     * 获取年月日
     * 
     * @param date
     *            日期
     * @return
     */
    public static String getDateYDM(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return sdfDate.format(calendar.getTime());
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取身份证户籍信息
     * 
     * @param num
     *            身份证前两位
     */
    public static String getKoseki(String num) {
        Map<String, String> cityCodeMap = new HashMap<String, String>();
        cityCodeMap.put("11", "北京");
        cityCodeMap.put("12", "天津");
        cityCodeMap.put("13", "河北");
        cityCodeMap.put("14", "山西");
        cityCodeMap.put("15", "内蒙古");
        cityCodeMap.put("21", "辽宁");
        cityCodeMap.put("22", "吉林");
        cityCodeMap.put("23", "黑龙江");
        cityCodeMap.put("31", "上海");
        cityCodeMap.put("32", "江苏");
        cityCodeMap.put("33", "浙江");
        cityCodeMap.put("34", "安徽");
        cityCodeMap.put("35", "福建");
        cityCodeMap.put("36", "江西");
        cityCodeMap.put("37", "山东");
        cityCodeMap.put("41", "河南");
        cityCodeMap.put("42", "湖北");
        cityCodeMap.put("43", "湖南");
        cityCodeMap.put("44", "广东");
        cityCodeMap.put("45", "广西");
        cityCodeMap.put("46", "海南");
        cityCodeMap.put("50", "重庆");
        cityCodeMap.put("51", "四川");
        cityCodeMap.put("52", "贵州");
        cityCodeMap.put("53", "云南");
        cityCodeMap.put("54", "西藏");
        cityCodeMap.put("61", "陕西");
        cityCodeMap.put("62", "甘肃");
        cityCodeMap.put("63", "青海");
        cityCodeMap.put("64", "宁夏");
        cityCodeMap.put("65", "新疆");
        cityCodeMap.put("71", "台湾");
        cityCodeMap.put("81", "香港");
        cityCodeMap.put("82", "澳门");
        cityCodeMap.put("91", "国外");

        return cityCodeMap.get(num);
    }

    /**
     * 根据身份证计算年龄(如果出生的月份在今天之前则年龄+1)
     * 
     * @param IdNO身份证
     * @return
     */
    public static int IdNOToAge(String IdNO) {
        if (StringUtils.isEmpty(IdNO)) return 0;
        int leh = IdNO.length();
        String dates = "";
        if (leh == 18) {
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year = df.format(new Date());
            int u = Integer.parseInt(year) - Integer.parseInt(dates);
            int moth = Integer.parseInt(IdNO.substring(10, 14));
            df = new SimpleDateFormat("MMdd");
            int m1 = Integer.parseInt(df.format(new Date()));
            if ((moth - m1) <= 0) {
                u = u + 1;
            }
            return u;
        } else {
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }

    }

    /**
     * 方法名称:transMapToString
     * 传入参数:map
     * 返回值:String 形如 username'chenziwen^password'1234
     */
    @SuppressWarnings("rawtypes")
    public static String transMapToString(Map map) {
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
            entry = (java.util.Map.Entry) iterator.next();
            sb.append(entry.getKey().toString()).append("'")
              .append(null == entry.getValue() ? "" : entry.getValue().toString())
              .append(iterator.hasNext() ? "^" : "");
        }
        return sb.toString();
    }

    /**
     * 方法名称:transStringToMap
     * 传入参数:mapString 形如 username'chenziwen^password'1234
     * 返回值:Map
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map transStringToMap(String mapString) {
        Map map = new HashMap();
        java.util.StringTokenizer items;
        for (StringTokenizer entrys = new StringTokenizer(mapString, "^"); entrys.hasMoreTokens(); map.put(items.nextToken(),
                                                                                                           items.hasMoreTokens() ? ((Object) (items.nextToken()))
                                                                                                                                : null))
            items = new StringTokenizer(entrys.nextToken(), "'");
        return map;
    }

    /**
     * 根据数字猪状态获取猪状态字符串
     * 
     * @param pigStatus
     * @return
     */
    public static String getPigStatusStr(Integer pigStatus) {
        String pigStatusStr = null;
        switch (pigStatus) {
        case 0:
            pigStatusStr = "正常";
            break;
        case 1:
            pigStatusStr = "死亡";
            break;
        case 2:
            pigStatusStr = "待屠宰录入";
            break;
        case 3:
            pigStatusStr = "待屠宰";
            break;
        case 4:
            pigStatusStr = "宰后待检验";
            break;
        case 5:
            pigStatusStr = "待销售";
            break;
        case 6:
            pigStatusStr = "已处理";
            break;
        case 7:
            pigStatusStr = "已销售";
            break;

        }
        return pigStatusStr;
    }
}
