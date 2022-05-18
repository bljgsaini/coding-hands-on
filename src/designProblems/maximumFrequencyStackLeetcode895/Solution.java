package designProblems.maximumFrequencyStackLeetcode895;

import java.util.*;

//https://leetcode.com/problems/maximum-frequency-stack/
public class Solution {
}


class FreqStack {
    Map<Integer, Integer> map;
    NavigableMap<Integer, Stack<Integer>> countMap;

    public FreqStack() {
        map = new HashMap();
        countMap = new TreeMap<>();
    }

    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        Stack<Integer> s = countMap.getOrDefault(freq, new Stack<Integer>());
        s.push(val);
        countMap.put(freq, s);
    }

    public int pop() {
        Map.Entry<Integer, Stack<Integer>> entry = countMap.lastEntry();
        Stack<Integer> s = entry.getValue();
        if(s.size() == 1){
            countMap.remove(entry.getKey());
        }
        int num = s.pop();
        map.put(num, map.get(num)-1);
        return num;
    }
}


class FreqStack2 {

    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> countMap;
    int maxFreq;

    public FreqStack2() {
        map = new HashMap();
        countMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, freq);
        map.put(val, freq);
        Stack<Integer> s = countMap.getOrDefault(freq, new Stack<Integer>());
        s.push(val);
        countMap.put(freq, s);
    }

    public int pop() {
        int num = countMap.get(maxFreq).pop();
        if(countMap.get(maxFreq).size() == 0){
            maxFreq -= 1;
        }
        map.put(num, map.get(num)-1);
        return num;
    }
}
