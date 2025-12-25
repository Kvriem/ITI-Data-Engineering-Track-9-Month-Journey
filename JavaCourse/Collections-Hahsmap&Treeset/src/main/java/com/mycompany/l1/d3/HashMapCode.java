package com.mycompany.l1.d3;


import java.util.*;

public class HashMapCode {
    public static void main(String args[]) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        hm.put(100, "Amit");
        hm.put(101, "Vijay");
        hm.put(102, "Rahui");
        for(Map.Entry m :hm.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}