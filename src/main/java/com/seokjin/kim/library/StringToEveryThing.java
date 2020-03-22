package com.seokjin.kim.library;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class StringToEveryThing {
    /**
     * 시간 없이 2013-04-08 , 20130408, 2013.04.08, 2013 04 08 케이스 원하는 type "yyyy-mm-dd"으로 형변환
     * @param date
     * @param type
     * @return Date
     */
    public static Date getStringToDate( String date, String type ) {
        
        String defaultType = StringUtils.isEmpty(type) ? "yyyy-MM-dd HH:mm:ss" : type;
        String changeDate  = date.replaceAll("-","").replaceAll(" ","").replaceAll("\\.","");
        SimpleDateFormat format = new SimpleDateFormat(defaultType);
        Date result = new Date();
        if( changeDate.length() == 8 ) {
            changeDate = new StringBuilder(changeDate.substring(0,4)).append("-").append(changeDate.substring(4,6)).append("-").append(changeDate.substring(6,8)).append(" 12:00:00").toString();
        }
        
       
        try {
            result = format.parse(changeDate);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        
        return result;
        
    }
    public static Date getStringToDate( String date ) {
        return getStringToDate(date, "yyyy-MM-dd HH:mm:ss" );
    }
    
    /**
     * 시간 없이 2013-04-08 , 20130408, 2013.04.08, 2013 04 08 케이스 2013-04-08로 통일 
     * @param date
     * @param type
     * @return Date
     */
    public static String getStringToDateDash( String date ) {
        if(  StringUtils.isEmpty(date) ) return "";
        
        String changeDate  = date.replaceAll("-","").replaceAll(" ","").replaceAll("\\.","");
        if( changeDate.length() == 8 ) {
            changeDate = new StringBuilder(changeDate.substring(0,4)).append("-").append(changeDate.substring(4,6)).append("-").append(changeDate.substring(6,8)).toString();
        }
        
        return changeDate;
        
    }
    
    /**
     * String 숫자 number로 변경
     * @param number
     * @return Double
     */
    public static Double getStringToDouble( String number ) {
        number = number.replaceAll("[^\\.\\+\\-0-9]", "");
        if ( StringUtils.isBlank(number) || number.equals("0")|| number.equals("+")|| number.equals("-")|| number.equals(".")) return 0.0;
        BigDecimal big =  new BigDecimal(number);
        Double todayPrice = big.doubleValue();
        
        return todayPrice;
        
    }
    
    /**
     * AddcDef같은 텍스트 addc_def처럼 원하는 구분자로 변경하는  로직
     * @param inputText
     * @param separator
     * @return String
     */
    public static String getUpperCaseStringToLowercaseWithWant( String inputText , String separator ) {
        if( StringUtils.isBlank(inputText) ) return inputText;
        
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < inputText.length(); index++) {
            char thisChar = inputText.charAt(index);
            // 대문자 범위
            if ( thisChar >= 65 && thisChar <= 90 && index != 0 ) {
                result.append(separator).append(String.valueOf(thisChar).toLowerCase());
            } else {
                result.append(String.valueOf(thisChar).toLowerCase());
            }
        }
        
        return result.toString();
        
    }
    
    /**
     * 원하는 구분자로 나눈 맨 마지막 정보 리턴 ex) ab-dc-df >> df 리턴
     * @param inputText
     * @param separator
     * @return String
     */
    public static String getLastStringWithSeperator( String inputText , String separator ) {
        String result = inputText;
        result = inputText.substring(result.lastIndexOf(separator)+1, inputText.length());
        
        return result;
        
    }
}
