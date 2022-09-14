package ReverseBigInteger;

import java.util.Scanner;

public class Reverser {

    public static String reverse(String str) {
        String res;
        if(str.indexOf('.')!=-1){
            String[] strArr = str.split("\\.");
            res = reverseFromZero(reverseString(strArr[0]))+"."+reverseString(strArr[1]);
        }
        else{
            res = reverseFromZero(reverseString(str));
        }
        return res;
    }

    public static String reverseString(String value){
        StringBuffer s = new StringBuffer(value);
        return s.reverse().toString();
    }

    public  static String reverseFromZero(String value){
        int indexZero = -1;
        StringBuffer s = new StringBuffer();

        boolean isNegative = false;
        if (value.charAt(0)=='-') {
            isNegative = true;
            value = value.substring(1,value.length()-1);
        }
        if(value.charAt(0)=='+'){
            value = value.substring(2,value.length()-1);
        }

        for(int i = 0;i<value.length();i++){
            if(value.charAt(i)=='0'){
                indexZero = i;
            }else
                break;  //find until the last zero;
        }

        if(value.length() == indexZero+1){
            s = new StringBuffer("0");
        }else if(indexZero!=-1){
            s = new StringBuffer(value.substring(indexZero+1,value.length()));
        }else{
            s = new StringBuffer(value);
        }
        String res = s.toString();
        if(isNegative){
            System.out.println("negative!");
            return "-"+res;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
        }

}
