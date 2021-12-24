import java.util.*;

public class Is_Anagram {
    public boolean isAnagram(String s, String t) {
        String[] arr_1 = s.split("");
        String[] arr_2 = t.split("");

        Arrays.sort(arr_1);
        Arrays.sort(arr_2);

        String one_sorted = String.join("", arr_1);
        String two_sorted = String.join("", arr_2);
        return one_sorted.equals(two_sorted);
    }
}
