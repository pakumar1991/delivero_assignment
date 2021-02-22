package com.app;

import java.util.Optional;

public class CronParserUtil {


    public static final String MINUTE ="minute";
    public static final String HOUR ="hour";
    public static final String DAY_OF_MON ="day of month";
    public static final String MONTH ="month";
    public static final String DAY_OF_WK ="day of week";
    public static final String COMMAND ="command";
    public static final String ALL_VALUES ="*";
    public static final String RANGE ="-";
    public static final String MULTIPLE_VALUES =",";
    public static final String INCREMENTAL_VALUES ="/";


    public static String parseAttribute(String attributeValue, String attributeName){
        Optional minOpt = Optional.ofNullable(attributeValue);
        if(!minOpt.isPresent()){
            throw new RuntimeException(attributeName + ": Invalid field");
        }
        if(attributeValue.equals(ALL_VALUES)){
            return getAllValues(attributeName);
        }
        else if(attributeValue.contains(RANGE)){
            return getRangeOfValues(attributeValue);
        }
        else if(attributeValue.contains(MULTIPLE_VALUES)){
            return getMultipleValues(attributeValue);
        }
        else if(attributeValue.contains(INCREMENTAL_VALUES)){
            return getIncrementalValues(attributeValue,attributeName);
        }
        else{
            return attributeValue;
        }
    }

    public static String getIncrementalValues(String attributeValue,String attributeName){

        String[] sArr = attributeValue.split(INCREMENTAL_VALUES);
        boolean fromStart = false;
        if(sArr[0].equals("*")){
            fromStart = true;
        }
        String returnString = "";
        if(fromStart){
            int start=0;
            if(attributeName.equals(MINUTE)){
                while(start <60){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(HOUR)){
                while(start <24){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(DAY_OF_MON)){
                while(start <31){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(MONTH)){
                while(start < 13){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(DAY_OF_WK)){
                while(start < 8){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
        }
        else{

            int start = Integer.parseInt(sArr[0]);
            if(attributeName.equals(MINUTE)){
                while(start <60){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(HOUR)){
                while(start <24){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(DAY_OF_MON)){
                while(start <31){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(MONTH)){
                while(start < 13){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }
            if(attributeName.equals(DAY_OF_WK)){
                while(start < 8){
                    returnString += start + " ";
                    start += Integer.parseInt(sArr[1]);
                }
            }

        }
        return returnString;
    }

    public static String getMultipleValues(String attributeValue){
        String returnString = "";
        String[]  sArr = attributeValue.split(MULTIPLE_VALUES);
        for(String s : sArr){
            returnString += s+" ";
        }
        return returnString;
    }
    public static String getRangeOfValues(String attributeValue){
        String returnString = "";
        String[] sArr = attributeValue.split(RANGE);
        for(int i=Integer.parseInt(sArr[0]);i<=Integer.parseInt(sArr[1]);i++){
            returnString += i+" ";
        }
        return returnString;
    }
    public static String getAllValues(String attributeName){
        String returnString = "";
        if(attributeName.equals(MINUTE)){
            for(int i=1;i<61;i++){
                returnString += i+" ";
            }
        }
        else if(attributeName.equals(HOUR)){
            for(int i=1;i<24;i++){
                returnString += i+" ";
            }
        }
        else if(attributeName.equals(MONTH)){
            for(int i=1;i<13;i++){
                returnString += i+" ";
            }
        }
        else if(attributeName.equals(DAY_OF_MON)){
            for(int i=1;i<31;i++){
                returnString += i+" ";
            }
        }
        else if(attributeName.equals(DAY_OF_WK)){
            for(int i=1;i<8;i++){
                returnString += i+" ";
            }
        }
        return returnString;
    }

    public static String getPaddedString(String s){
        return String.format("%-14s",s);
    }
}
