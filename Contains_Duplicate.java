import java.util.*;

public class Contains_Duplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int i : nums)
            {
                set.add(i);
            }
            return nums.length != set.size();
        }
    }
}
