import java.util.*;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
        HashMap<String, Integer> hmap = new HashMap<>();
        HashMap<Integer, String> res = new HashMap<>();

        String word = "";
        ArrayList<String> words= new ArrayList();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                word = word + s.charAt(i);
                words.add(word.trim());
                word = "";
            }
            else {
                word = word + s.charAt(i);
            }
        }

        for (int i = 0; i < words.size(); i++) {
            if (hmap.containsKey(words.get(i))) {
                hmap.replace(words.get(i), hmap.get(words.get(i)) + 1);
            }
            else {
                hmap.put(words.get(i), 1);
            }
        }

        for(Map.Entry<String,Integer> i : hmap.entrySet()) {
            String key = i.getKey();
            Integer val = i.getValue();
            if (res.containsKey(val)) {
                res.put(val, res.get(val) + " " + key);
            }
            else {
                res.put(val, key);
            }
        }

        ArrayList<Integer> arraylist = new ArrayList(res.keySet());
        Collections.sort(arraylist);

        String ordered = "";

        for(Integer cnt: arraylist) {
            word = res.get(cnt);
            while(word.indexOf(' ') != -1) {
                for (int i = 0; i < cnt; i++) {
                    ordered = ordered + word.substring(0, word.indexOf(' ')) + " ";
                }
                word = word.substring(word.indexOf(' ') + 1);
            }
            for (int i = 0; i < cnt; i++) {
                ordered = ordered + word + " ";
            }
        }

        return ordered;

    }

}
