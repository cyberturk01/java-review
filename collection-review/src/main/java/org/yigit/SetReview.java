package org.yigit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetReview {
    public static void main(String[] args) {
        Set<Student> myset=new HashSet<>();
        myset.add(new Student(7, "Gok"));
        myset.add(new Student(8, "Ahmet"));
        myset.add(new Student(9, "Vildan"));
        myset.add(new Student(9, "Vildan"));


        System.out.println(myset);

        Set<Integer> numSet= new HashSet<>();
        numSet.add(1);
        numSet.add(2);
        System.out.println("numSet = " + numSet);
        System.out.println(numSet.add(2));

        String str="java_developer";
        System.out.println("First Repeating Char: "+firstRepeatingChar(str));

    }
    public static Character firstRepeatingChar(String str){
        Set<Character> chars= new HashSet<>();
        for (int i = 0; i < str.length() ; i++) {
            if(!chars.add(str.charAt(i))){
                return str.charAt(i);
            }
        }
        //for(Character ch:str.toCharArray()) if(!chars.add(ch)) return ch;
        return null;
    }
}
