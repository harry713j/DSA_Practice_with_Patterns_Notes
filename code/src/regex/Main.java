package regex;

import java.util.Scanner;

class MyRegex{
    public  String pattern;
    /*
    * Valid:
    *   000.12.12.034, 121.234.12.12, 23.45.12.56
    * Invalid:
    *   000.12.234.23.23, 666.666.23.23, .213.123.23.32, 23.45.22.32., I.Am.not.an.ip
    * */
    public MyRegex(){
        this.pattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
                "(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$";
    }
}

public class Main {
    /*
    Q1. https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
    Q2. https://www.hackerrank.com/challenges/duplicate-word/problem?isFullScreen=true
    * */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}
