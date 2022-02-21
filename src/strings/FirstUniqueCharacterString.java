package strings;

import java.util.HashMap;
import java.util.Map;

//387. First Unique Character in a String
public class FirstUniqueCharacterString {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap();
        Map<Character, Integer> location = new HashMap();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) +1 );
            if(location.getOrDefault(s.charAt(i),0) == 0) {
                location.put(s.charAt(i), i);
                //System.out.print(" put char = " + s.charAt(i));
            }
        }
        int minLocation = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> element : map.entrySet()){
            if(element.getValue() == 1){
                char key = element.getKey();
                //System.out.println("temp " + location.get(key) + " key ="+ (char)key);
                minLocation = Math.min(minLocation, location.get(key)  );
            }
        }
        return minLocation == Integer.MAX_VALUE ? -1 : minLocation;

    }

}
