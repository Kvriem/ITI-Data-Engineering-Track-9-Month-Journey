package com.mycompany.l1.d3;

import java.util.*;

public class L1D3 {
    public static void main(String args[]){
        TreeSet<String> al =new TreeSet<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");
        Iterator <String> itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
