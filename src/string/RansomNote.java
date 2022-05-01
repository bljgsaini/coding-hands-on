package string;

import java.util.HashMap;
import java.util.Map;

//383. Ransom Note
public class RansomNote {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap();

        for(int i=0; i<magazine.length(); i++){
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0)+1);
        }

        for(int i=0; i<ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(map.getOrDefault(ch, 0) == 0) return false;
            map.put(ch, map.get(ch)-1);
        }
        return true;
    }

}
