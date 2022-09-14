package ReverseBigInteger;

import java.util.Scanner;

public class Reverser {

    /*
    由于需要将小数点两边分别处理，直接用biginteger类型不大方便，
    还是改为用字符串表示数值，这样无论是反转还是字符串划分，都方便些；
    */


    public static String reverse(String str) {
        String res;
        if(str.indexOf('.')!=-1){  //如果是有小数点；
            String[] strArr = str.split("\\.");  //正则表达式，将小数点俩边分成两个字符串分别处理；需要转义字符；
            res = removezero(reverseString(strArr[0]))+"."+reverseString(strArr[1]);//分别处理两边；
        }
        else{  //如果是整数；直接反转；
            res = removezero(reverseString(str));
        }
        return res;
    }

    public static String reverseString(String value){  //通过反转字符串，来完成数字反转；
        boolean isNegative = false;
        if (value.charAt(0)=='-') {  //需要判断数值的正负；
            isNegative = true;
            value = value.substring(1,value.length());
        }
        if(value.charAt(0)=='+'){
            value = value.substring(1,value.length());
        }
        StringBuffer s = new StringBuffer(value);
        if(isNegative){
            return "-"+s.reverse().toString();
        }
        return s.reverse().toString();
    }

    public  static String removezero(String value){  //这个是为了消除数字前那些无效的0；
        int indexZero = -1;
        StringBuffer s = new StringBuffer();
        int i =0;
        boolean isNegative = false;
        if(value.charAt(0)=='-'||value.charAt(0)=='+'){
            i = 1;
            if(value.charAt(0)=='-'){
                isNegative = true;
            }
        }
        for(;i<value.length();i++){
            if(value.charAt(i)=='0'){
                indexZero = i;
            }else
                break;  //从最开始的0一直找到最后无效的0；；
        }

        if(value.length() == indexZero+1){
            s = new StringBuffer("0");
        }else if(indexZero!=-1){
            s = new StringBuffer(value.substring(indexZero+1,value.length()));
        }else{
            s = new StringBuffer(value);
        }
        String res = s.toString();
        if(isNegative)
            return "-"+res;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
        }

}
