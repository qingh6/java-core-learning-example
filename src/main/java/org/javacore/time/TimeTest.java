package org.javacore.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lqh on 2018-7-9.
 */
public class TimeTest {

    public static void main(String[] args) {


        String stringToDate="2016年10月24日";
        Date date = stringToDate(stringToDate);
        String string = dateToString(date);
        System.out.println("Unparseable using"+string);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
////        String date1 = df.format("2016.11.01");
////        System.out.println(date1);
//        String str = "2016.11.01";
//        Date date2=new Date();
//        try {
//            date2 = df.parse(str);
//            System.out.println(date2);
//        }catch (ParseException e){
//            System.out.println("Unparseable using"+df);
//        }
    }//Tue Nov 01 00:00:00 CST 2016

    //Date 转成 String
    public static String dateToString(Date date) {

        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy.MM.dd");
        time = formater.format(date);
        return time;
    }

    //String 转成 Date
    public static Date stringToDate(String stringDate) {

//        String stringDate3 = "2016年10月24日";
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy年MM月dd日");
        Date date3 = new Date();
        try {
            date3 = format3.parse(stringDate);
//            System.out.println("格式一：......."+format1.parse(stringDate3));
//            System.out.println("格式二：......."+format2.parse(stringDate3));
            System.out.println("格式二：......."+date3);
            System.out.println("格式三：......."+format3.parse(stringDate));//格式(2016年10月24日)只可以格式化为(yyyy年MM月dd日)
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date3;
    }
}
