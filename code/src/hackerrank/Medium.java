package hackerrank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Medium {
    public static String extractContent(String str){
    // https://www.hackerrank.com/challenges/tag-content-extractor/problem?isFullScreen=true
        Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\\\1>");
        Matcher matcher = pattern.matcher(str);

        String result = "";

        while (matcher.find()){
            result = matcher.group(2);
        }

        return result;
    }

    //https://www.hackerrank.com/challenges/java-bigdecimal/problem?isFullScreen=true
    static void bigDecimal(){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        s = Arrays.copyOf(s, n);
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);
                return b.compareTo(a);
            }
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

    // https://www.hackerrank.com/challenges/java-2d-array/problem?isFullScreen=true


    public static void main(String[] args) {
       String[] s = {"-100","50","0","56.6","90","0.12",".12","02.34","000.000", null, null};

//        Arrays.sort(s, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                BigDecimal a = new BigDecimal(o1);
//                BigDecimal b = new BigDecimal(o2);
//                return b.compareTo(a);
//            }
//        });

//        System.out.println(Arrays.toString(s));

        BigInteger bigA = new BigInteger("123456789123456789");
        BigInteger bigB = new BigInteger("100000000000000000");

        System.out.println(bigA.add(bigB).toString());
        System.out.println(bigA.multiply(bigB).toString());
    }
}
