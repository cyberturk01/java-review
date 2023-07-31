package org.yigit;

import java.util.HashMap;
import java.util.Map;

public class MapReview {
    public static void main(String[] args) {
        Map<Integer, String> map= new HashMap<>();
        map.put(1, "Moses");
        map.put(2, "Ahmet");
        map.put(3, "Zeynep");
        System.out.println("map.get(2) = " + map.get(2));

        String str="Java Developer";
        System.out.println(findFirstNonRepeatingChar(str));
    }

    public static Character findFirstNonRepeatingChar(String str){
        Map<Character, Integer> map= new HashMap<>();
        int count=0;
        //Counting the chars and putting values in to hash map
        for(Character ch: str.toCharArray()){
            if(map.containsKey(ch)) {
                count=map.get(ch);
                map.put(ch, count+1);
            }else {
                map.put(ch, 1);
            }
        }
        //Check if char count is 1
        for(Character ch: str.toCharArray()){
            if(map.get(ch)==1){
                return ch;
            }
        }

        return null;
    }
}
