package com.app;

public class ParseCronExpression extends CronParserUtil{

    public static void main(String[] args) {

        if(args.length!=1){
            throw new RuntimeException("No argument or too many arguments passed");
        }

        String[] ArrayOfAttributes = args[0].split(" ");
        // parsing minute attribute
        String temp ="";
        temp = CronParserUtil.getPaddedString(MINUTE) + parseAttribute(ArrayOfAttributes[0],MINUTE);
        System.out.println(temp);
        // parsing hour attribute
        temp = getPaddedString(HOUR) + parseAttribute(ArrayOfAttributes[1],HOUR);
        System.out.println(temp);
        // parsing day of month attribute
        temp = getPaddedString(DAY_OF_MON) + parseAttribute(ArrayOfAttributes[2],DAY_OF_MON);
        System.out.println(temp);
        // parsing month attribute
        temp = getPaddedString(MONTH) + parseAttribute(ArrayOfAttributes[3],MONTH);
        System.out.println(temp);
        // parsing day of week attribute
        temp = getPaddedString(DAY_OF_WK) + parseAttribute(ArrayOfAttributes[4],DAY_OF_WK);
        System.out.println(temp);
        // parsing command attribute
        temp = getPaddedString(COMMAND) + ArrayOfAttributes[5];
        System.out.println(temp);
    }
}
