package com.tracenull.j20201022;

import java.util.Date;

public class Ques1026 {
    public static void main(String[] args) {
        boolean b1 = "String" instanceof Object;// 1
        boolean b2 = new String() instanceof String;// 2
//        boolean b3 = 'A' instanceof Character;// 3
        boolean b4 = null instanceof String;// 4
        boolean b5 = (String)null instanceof String;// 5
//        boolean b6 = new Date() instanceof String;// 6
    }
}
