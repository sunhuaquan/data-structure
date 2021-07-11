package com.sun.algorithm;

public class Interview5 {

    public static void main(String[] args){
        String str="we are happy";
        char[] chars = replaceBank(str.toCharArray());
        System.out.println(new String(chars));
    }

    public static char[] replaceBank(char[] ch){
        if(ch==null){
            return null;
        }
        int countBanK=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]==' ')
            {
                countBanK++;
            }
        }
        char[] result=new char[ch.length+countBanK*2];
        int p1=ch.length-1;
        int p2=result.length-1;
        while (p1>=0){
            if(ch[p1]==' '){
                result[p2]='0';
                result[--p2]='2';
                result[--p2]='%';
            }else {
                result[p2]=ch[p1];

            }
            p1--;
            p2--;
        }
        return result;
    }
}
