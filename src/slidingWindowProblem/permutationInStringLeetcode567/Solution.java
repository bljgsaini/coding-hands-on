package slidingWindowProblem.permutationInStringLeetcode567;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/

/* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/
public class Solution {
    public static void main(String[] args) {

        String s1 = "ckzviabspcfbabslodcxtzanlsnwbqrozvnfadhtskosxhxaxzwcthvirwivsfuyxgkdvvdmmaoohvnfegkzdajhzibfiuxvsihpseyyiapmgldyojfselzzudzrxcksvfoqoeimyfhnvidryqhhpvjawwpzspcfnvmewnhcbbbwfjifmcuspbrrjyhcusyiuydscwenyicdlfzaoaiudsdyjmhmzwmeaozheiaddevjrrgsfgqnyeoyxfvktctazsfizkynlookeorzmdvtloyfpbqjgzhjvykdthwkuubnbalrddjxpizysaptrinlytecouekkpsfzbjaitckodcdinydtaaakbntwbvrcabylllxtgtkdqfkjggvbrnxnvcsfpcutabvazyeqzitpwhhdpcxaklhbjrcsqzveytzbgoeqnyrbkvkfnlqhrnedjomfmkuadwabnzomgvtdypocbvipryedcxnrcrqwpefqducxxilhpoewlliilidxucjydpahcumngpekrlroftwpbaejfjmohnkulxdglcpcszpyqestonhxskshzmdkikjkeymddyiysmigvqjveocbabhcofwyseytwfgiqmufcqrugwofytxzwwwiwlxdshtamwneosotqbfjjdxmhjkmzcvpmkuumycqzvlmwvjdwkcikyewupwaotrseyomhuykdkohveftgqfoqjcnstlxdasnvimslmuqsqrhvbukyfvpswmlavtxegbcesxgzswwnslxymmrdwmpalcazukvyyotlvwvlishtgbmlznrmcjysjemwqfjgbehnowgjlvtgemlkkdqpxiuqwhqkqdkexoflxfescoblknurkntbpfqfiervqgeiasguycmjoyzyujgzdfjobrswjpxixmadnnkdtazbasmnnlbubokkvomtupdpqwnoddummmqbwbthfhqdgdawdwxlmgvelhefvqcrpxbkgvhyrpxmfivrvkkqfpxjhzqesiqoeanqzpvbgonwptzqgtajoiiphivxtefarwjyoklkxumrndswebdsgiipzrcunpnibmxwlkihnzlswaujflztxxnuhojrpkzldwhnuiizxalawskkvaplopthvzjrbqfwpwjfkzrhyciajdsaeusctnvajuubjiqdqsaqjxtxgxabpdwxzgiedyyeosfdbkairekywkilyksjratftctphompqoomxucysbzrpywjzumoiizklkooilgeapimiixawfgiszfqucihxfrtrwijyeiebudncwnxbnafohhhqaltksafjfegxlbbewetsyrtuxxlngffpcnyfdarqwznsuiuhvqshjpvbiqkxgfwyrkdlorlwgexfinunbfzifxlfufalbkyfdekhupuuflsetpbppaahwbtjpjguygpnavimbbaeikwjxurdxyfgmldgdbkyxzhvwlxzlpnpmzlyosvhngmuqkrvcsabhiahhguxuakphuaptbjfpxybqnlfazkagwlbvzcnzorpymafiwvtkjtilwihwoyelogtpdyipzkurqcghpdqgrfpnmrmahbkbyupxwooblaydongjrlnuhoikoyiexgzlzgonceyhfwypsgypilxcnkdhxvbfddnhvdicolrjyzttrymmcvoyswaszbbugsuuewhewtoxgnrbfqsysjqqcutoikssesxaohxxfxofiguvpgzfkimmqdjuyljlpndapzygidopwxnaetmmpyaqozybbpfqlonebiilvckmtyaommksfcrmdeyjjbjncmpruofaaccnvndkovjugcrzcwkbdhqdiwnvnavnngloshyataygyukrecamzftmeephucmofjgrzsexsprpdkazhmtaepqppgzjmxxzlpbkouqlhqcxdpaslrjrsnfbjvbekpyqsldzhxarpzbbjteudfwfjdipgcdwylorxivwbjkegazpcngzkokygjfnmfeumbetznsxsmyhccurqdzznvhrtawpklrrrbedqzkiczignlaoaiydezgktdecaxwxxecymbuisvhlcjlhmnpjuegnaawfxopvvkxihehquxzlveabigomeptsqbfurytjikpbtsotgfghadilylnimxcsvgtmzjgxjyhabtfawzmomctquctwnolglflghdugeutgdmkitunbkhgoceqyrzvwprotiysaiqcnwxflcjgjqobeskizjqqwihnmxyvbeeufyvouupnyuuyauxtmhtqlbgoacjdkvmuqohbkpctfwxvwlghevsuozrgxkrrrllnvjloeligxvnvzluxlajszgeilxdjaviawhlthtxuclqypgdiwgwrhynmzqghyzeednlmyepgxxvtmjsuprisbgyvcojhculwdkjmpmvueaftiujrmdqptrmlrwdyjtjlznuhftzmffbcqsjemrpjrqxtuxhlnqvckgcuvhswgtxonfljjwnexdafpjzwjdypdfwhwogikkpsvuckmgehcqmdecriamdqsdsxuhsdqenrpifzjnpvrbpvetatbmvsncltabzspzedumeclbxiqnsmdkbqfedikoalfsnxkhewwzyeqxlecfimvdpxdnvrtlxlxzakupknvchursvilyjyfxmvdeojclhjjwxtpqiogsfdnzchrlztvxmibbociiberaevpjmyqxvcicxuwkmyjlgxhvrjdqbjzdctzwidoplkvazhgsdbkavmrpfjgebydmloykqtxocdhcpwrtvawhofvwnohtwodppmcrbhvrvexzijiwgkptntyljvikjlzpjvpxaejfwzyldxrckbzylvhpqmjjeyatmrbcgozvcalcctngwuysjqmkmhjwmyyfxhdjswimahqzptrphtjekkabpgopfdnhwaclxzavftmswadgztxceonrkczurtdvxhabiafyzdbdbyorerekjzgpueihiamlscdndjjgqwdjsmeweqrfpypfrfsciclvrrqchnmtxscbvbbipzingkeopuvlnpqaeqidlpvusbkjhntvxbookqctymjmhqjvsnaiblmnofxphanpxspmkmxmyejooqpytdixgguonbpaipurpwwfqxrrtekvvtpgndabbvjcoxonxciuypxqcfolxirvafnmgsrcrenwyuxfekuqyfdtvhvmonvkstbmvygsbguiknltpixsebxktczniurulxpyxckrtmhpvgqpbvlqwvcqwaocalqtdwomgrjyvryodeikbeeebcrrkugliqgktoohsneynmfafykpmndfgwtpdwfrmicenyntbfyyntlqqrujfioycrhopgiadmsjcycucyuqvzufbvachmlwyfxspzrvkkvkhuykoqrwshzmyypmvosuezpsgtqtecayj";
        String s2 = "livsugnixbcmmajhinduvzfjzxtzneixibupxfezifaovcbowfayjtlcdsjogjytuczxbwluiktkdyecquebuvkgfobhpiqfbyckfbchvfkdowckrvuiblhbmubugrrovdhbyvevwetlusthiyxgtaqcdfytgbkrnnjifdslzntgnryqcmwkumdvqctymyffanmawobfihsfqmtqvivvouunsexpzcfmiituppwxgjyspyoeuspyystyneoonatbojiufzhhfeakqzeypaopkyscadbkzsnnjewgflysazhwaigicrzeccanemfmrvrdzxtcbuqvjblrynlhbmtkzhtiqnhrfclxovtijwucgvsreirqmhweoazxdyydksrchvizmljhdkekaxbqkleaolqnepijxpwbcxfadfsxswhzmmffsmoiyfosbwjjcgqpexddwizaiqpsaagwxkajdhqeyouihwlfrmnelakembxwcrvwqyaguvqewjczfmfqiqmjbqxcmfrpqoewszkomwckfgrlkannjefxsulbpkpxlvbrgwruvhdonuezoomvnyridrosfzhfvhmqbzdsfvjgfdqvafheuhveaqwrofhgkfobkkevdsqyumzrvapfjypvjsdzaxxwcnsbxasqewmkmucxbgjqntdsvrbndebttkoiznatcjgtgklljurkkdvpbrtbolvgrqwsnuoubhgvtmbakwgvxypndpqtireuvbdxfjcioqqsbfrqahqsfbwfnlkwobnqdbptxrizourrxyjejflgkbcwmrtttqeeqkyzrzdcfakwcfajhjfmcpnsbekwtzgpbwrotgsxopaemsnywoxsqxoyricgosfurfggulchgyoocivnkqytgbroijmaduoywbudtgwugekikebdadoygtmikcficifdcsvritesbvznlbrgbveudwzatarhbehowrrakimocgqyxzedhlqxzxtqloupbwbdvewcbehkmoahoykouhilivtxukqhwmyjjqmfxqybahsubfvnhctudtpxwsnwfmsamavjkqiabzzcqgqssygswavqpdtxfyognqybsogsbkzkktfjqebhitvqnawokacbkfkthqoammdscyvxgaaqyaplexhlwweambfwtylvihpdedshaeluxgthrejkgkvwrtyzpuygqghtlkmpnzkyjiwyuaqijkxttvdsxddfkmgnnlmamjumsbjmjxqkrgncrwyoyetdsmtanoasirkfklcsxukfdebnlbgobwgyqrthzwjbwpxuxmheplqyjaucgrptfewjahejsfypktnpafmlrzekbjqsgthrwbdxttitsqyglsjgnzmscncgvkooxdlxsmmugeeayicndgoagpfckerzuwdphqksijniyckzviabspcfbabslodcxtzanlsnwbqrozvnfadhtskosxhxaxzwcthvirwivsfuyxgkdvvdmmaoohvnfegkzdajhzibfiuxvsihpseyyiapmgldyojfselzzudzrxcksvfoqoeimyfhnvidryqhhpvjawwpzspcfnvmewnhcbbbwfjifmcuspbrrjyhcusyiuydscwenyicdlfznoaiudsdyjmcmzwmeaozheiaddevjrrgsfgqnyeoyxfvktctazsfizkynlookeorzmdvtloyfpbqjgzhjvykdthwkuubnbalrddjxpihysaptrinlytecouekkpsfzbjaitckodcdinydtaaakbntwbvrcasylllxtgtkdqfkjggvbanxnvcsfphutabvazyeqzitpwhhdpcxaklhbjrcsqzveytzbgoeqnyrbkvkfnlqhrnedjomfmkuadwabnzomgvtdypocbvipryedcxnrcrqwpefqducxxilhpoewlliilidxucjydpahcumagpekrlroftwpbaejfjmohnkulxdglcpcszpyqestonhxskshzmdkikjkeymdfyiysmigvqjveocbabhcofwyseytwfgiqmufcqrugwofytxzwwwiwlxdshtamwneosotqbfjjdxmhjkmzcvpmkuumycqzvlmwvjdwkcityewupwaotrseyomhuykdkohveftgqfoqjcnstlxdasnvimslmuqsqrhvbukyfvpswmlavtxegbcesxgzswwnslxymmrdwmpalcazukvyyotlvwvlishtgbmlznrmcjysjemwqfjgbehnowgjlvtgemlkkdqpxiuqwhqkqdkexoflxfescoblknurkntbpfqfiervqgeiesguycmjoyzyujgzdfjobrswjpxixmadnnkdtazbasmnnlbubokkvomtupdpqwnoddummmqbwbthfhqdgdawdwxlmgvelhefvqcrpxbkgvhyrpxmfivrvkkqfpxjhzqesiqoeanqzpvbgonwptzqgtajoiiphivxtefarwjyoklkxumrndswebdsghipzrcunpnibmxwlkihnzlswaujflztxxnuhojrpkzldwhnuiizxalawskkvaplopthvzjrbqfwpwjfkzrhyciajdsaeusctnvajuubjiqdqsaqjxtxgxabpdwxzgiedyyeosfdbkrirekywkilyksjratftctphompqoomxucysbzrpywjzumoiizklkooilgeapimiixawfgiszfqucihxfrtrwijyeiebudncwnxbnafohhhqaltksafjfegxlbbewetsyrtuxxlngffpcnyfdarqwznsuiuhvqshjpvbiqkxgfwyrkdlorlwgexfinunbfzifxlfufalbkyddekhupuuflsetpbppaahwbkjpjguygpnavimbbaeikwjxurdxyfgmldgdbkyxzhvwlxzlpnpmzlyosvhngmuqkrvcsabhiahhguxuakphuaptbjfpxybqnlfazkagwlbvzcnzorpymafiwvtkjtilwihwoyelogtpdyipzkurqcghpdqgrfpnmrmahbkbyupxwooblaydongjrlnuhoikoyiexgzlzgonceyhfwypsgypilxcnkdhxvbfddnhvdicolrjyzttrymmcvoyswaszbbugsuuewhawtoxgnrbfqsysjqqcutoikssesxaohxxfxofiguvpgzfkimmqdjuyljlpndapzygidopwxnaetmmpyaqozybbpfqlonebiilvckmtyaommksfcrmdeyjjbjncmpruofaaccnvndkovjugcrzcwkbdhqdiwnvnavnngloshyataygyukrecamzftmeephucmofjgrzsepsprpdkazhmtaepqppgzjmxxzlpbkouqlhqcxdpaslrjrsnfbjvbekpyqsldzhxarpzbbjteudfwfjdipgcdwylorxivwbjkegazpcngzkokygjfnmfeumbetznsxsmyhccurqdzznvhrtawpklrrrbedqzkiczignlaoaiydezgktdecaxwxxecymbuisvhlcjlhmnpjuegnaawfxopvvkxihehquxzlveabigomeptsqbfurytjikpbtsotgfghadilylnimxcsvgtmzjgxjyhabtfawzmomctquctwnolglflghdugeutgdmkitunbkhgoceqyrzvwprotiysaiqcnwnflcjgjqobeskizjqqwihnmxyvbeeufyvouupnyuuyauxtmhtqlbgoacjdkvmuqohbkpctfwxvwlgievsuozrgxkrrrllnvjloeligxvnvzluxlajszgeilxdjaviawhlthtxuclqypgdiwgwrhynmzqghyzeednlmyepgxxvtmjsuprisbgyvcojhculwdkjmpmvueaftiujrmdqptrmlrwdyjtjlznuhftzmffbcqsjemrpjrqxtuxhlnqvckgcuvhswgtxonfljjwnexdafpjzwjdypdfwhwogikkpsvuckmgehcqmdecriamdqsdsxuhsdqenrpifzjnpvrbpvetatbmvsncltabzspzedumeclbxiqnsmdkbqfedikoalfsnxkhewwzyeqxlecfimvdpxdnvrtlxlxzakupknvchursvilyjyfxmvdfojclhjjwxtpqiogsfdxzczrlztvxmibbociiberaevpjmyqxvcicxuwkmyjlgxhvrjdqbjzdctzwidoplkvazhgsdbkavmrpfjgebydmloykqtxocdhcpwrtvawhofvwnohtwodxpmcrbhvrvexzijiwgkptntyljvikjlzpjvpxaejfwzyldxrckbzylvhpqmjjeyatmrbcgozvcalcctngwuysjqmkmhjwmyyfxhdjswimahqzptrphtjekkabpgopfdnhwaclxzavftmswadgztxceonrkczurtdvxhabiafyzdbdbyorerekjzgpueihiamlscdndjjgqwdjsmeweqrfpypfrfsciclvrrqchnmtxscbvbbipzingkeopuvlnpqaeqidlpvusbkjhntvxbookqctymjmhqjvsnaiblmnofxphanpxspmkmxmyejooqpytdixgguonbpaipurpwwfqxrrtekvvtpgndabbvjcoxonxciuypxqcfolxirvafnmgsrcrenwyuxeekuqyfdtvhvmonvkbtbmvygsbguiknltpixsebxktczniurulxpyxckrtmhpvgqpbvlqwvcqwaocalqtdwomgrjyvryodeikbeeebcrrkugliqgktoohsneynmfafykpmndfgwtpdwfrmicenyntbfyyntlqqrujfioycrhopgiadmsjcycucyuqvzufbvachmlwyfxspzrvkkvkhuykoqrwshzmyypmvosuezpsgtqtecayjdasrysrmdewxmqntqmuavczczrcrzokjzqtiucdfmijfqkizfftxsddkdwlofkjbuhzodgzeslpezdifpdfktufgekrrbsxfeqduphoemwhncbblqkoyychuwlkjfxjmvdasfhwxnxjmstabgiujditpmpnojsfzpgqvupkdipphutiewfynvoxmdaloyxsksaxnyyizreshgejskhokarxddrrkoeglwledovrbarhkfcetrshiuucmbrtqjawsavbhuoijshkzcmogbjurybhwduushlmhjzgthhlvftpytayjzzbcxbtvozwhsmtkltgrugyfaoldnnswbohpsqvwbwtjcxeewsvfwpkwltxmomlwsylwvcmmrwjvvbbktqxnypfmhjigzaqacmprjfnooinkgbjzzwyuafxsmqdcmsxhbfoejjzxizufvfejrrcfaijqovlxdngkgwisvryevivawbcttftuxympktxbxotvdycxhfokmtdeqacdceffvhvjpnzfuhqslixvlcxehvbkritokoqqlbmkdkgflthhhdgiaidjjpvcatctiosolfqzcjmdppttztpklgosnshspna";

        System.out.println(checkInclusionUsingArray(s1, s2));

    }


    public static boolean checkInclusionUsingArray(String s1, String s2) {
        if(s1.length() > s2.length() ) return false;
        int []mapS1 = new int[26];
        int []mapS2 = new int[26];
        for(int i=0; i<s1.length(); i++){
            mapS1[s1.charAt(i) - 'a']++;
            mapS2[s2.charAt(i) - 'a']++;
        }
        int totalMatch = 0;
        for( int i=0; i<26; i++ ) if(mapS1[i] - mapS2[i] == 0) totalMatch++;
        int i = 0, j = s1.length();
        while(j < s2.length()){
            if(totalMatch == 26 ) return true;
            mapS2[s2.charAt(j) - 'a']++;
            if( mapS1[s2.charAt(j) - 'a'] - mapS2[s2.charAt(j) - 'a'] == 0 ) totalMatch++;
            else if(mapS1[s2.charAt(j) - 'a'] + 1 - mapS2[s2.charAt(j) - 'a'] == 0) totalMatch--;

            mapS2[s2.charAt(i) - 'a']--;
            if( mapS1[s2.charAt(i) - 'a'] - mapS2[s2.charAt(i) - 'a'] == 0 ) totalMatch++;
            else if( mapS1[s2.charAt(i) - 'a'] - 1 - mapS2[s2.charAt(i) - 'a'] == 0 ) totalMatch--;

            i++;
            j++;
        }
        return totalMatch == 26;
    }


    public boolean checkInclusionUsingHashMap(String s1, String s2) {
        if(s1.length() > s2.length() ) return false;
        Map<Character, Integer> mapS1 = new HashMap();
        Map<Character, Integer> mapS2 = new HashMap();
        for(int i=0; i<26; i++){
            char ch = (char)( 'a' + i);
            mapS1.put(ch, 0);
            mapS2.put(ch, 0);
        }
        for(int i=0; i<s1.length(); i++){
            mapS1.put(s1.charAt(i), mapS1.get(s1.charAt(i)) + 1);
            mapS2.put(s2.charAt(i), mapS2.get(s2.charAt(i)) + 1);
        }
        int totalMatch = 0;
        for(Character ch : mapS1.keySet() ) if(mapS1.get(ch) - mapS2.get(ch) == 0) totalMatch++;
        int i = 0, j = s1.length();
        while(j < s2.length()){
            if(totalMatch == 26 ) return true;
            char ch = s2.charAt(j);
            mapS2.put(ch, mapS2.get(ch) + 1);
            if( (mapS1.get(ch) - mapS2.get(ch)) == 0 ) totalMatch++;
            else if( mapS1.get(ch) + 1 - mapS2.get(ch) == 0 ) totalMatch--;

            ch = s2.charAt(i);
            mapS2.put(ch, mapS2.get(ch) - 1);
            if( (mapS1.get(ch) - mapS2.get(ch)) == 0 ) totalMatch++;
            else if( mapS1.get(ch)-1 - mapS2.get(ch) == 0 ) totalMatch--;

            i++;
            j++;
        }
        return totalMatch == 26;
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> mapS1 = new HashMap();
        Map<Character, Integer> mapS2 = new HashMap();
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1 );
        }

        int i =0, j=0;
        while(j < s2.length()){
            char ch = s2.charAt(j);
            mapS2.put(ch, mapS2.getOrDefault(ch, 0)+1);
            if(j-i+1 == s1.length() ){
                if(checkStringAnagram(mapS1, mapS2)) return true;
                ch = s2.charAt(i);
                int freq= mapS2.get(ch);
                if(freq == 1 ) mapS2.remove(ch);
                else mapS2.put(ch, freq-1);
                i++;
            }
            j++;
        }

        return false;
    }

    public static boolean checkStringAnagram(Map<Character, Integer> map1, Map<Character, Integer> map2){
        System.out.println("map1=>" + map1.toString());
        System.out.println("map2=>" + map2.toString());
        for(Character ch : map1.keySet()){
            if( map1.get(ch).compareTo(map2.getOrDefault(ch, 0 )) != 0) return false;
        }
        return true;
    }

}
