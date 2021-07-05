import java.util.*;

class Solution {
    public static void printIntArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
                System.out.println(start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static String intToRoman(int num) {
        //linkedHashmap按顺序存放的，普通hashmap不是
        /*Map<Integer, String> map = new LinkedHashMap<>() {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};//map优美赋值方法，其实就是建立了一个匿名内部类
        //linkedHashmap执行速度有点拉
        StringBuffer result = new StringBuffer();
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            while (num >= entry.getKey()) {
                result.append(entry.getValue());
                num = num - entry.getKey();
            }
            if (num == 0) break;
        }*/
        StringBuffer result = new StringBuffer();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                result.append(romans[i]);
                num = num - nums[i];
            }
            if (num == 0) break;
        }
        return result.toString();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n == 0) return 0;
        int[] nums = new int[n];
        int i = 0, j = 0;
//            if (nums1.length < nums2.length) {
//                int[] temp = nums1;
//                nums1 = nums2;
//                nums2 = temp;
//            }
//             nums2 = Arrays.copyOf(nums2, nums1.length);
//            System.arraycopy(nums2, 0, nums_temp, 0, nums2.length);
//            printIntArray(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[i+j] = nums1[i];
                i++;
            }
            else {
                nums[i+j] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            nums[i+j] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            nums[i+j] = nums2[j];
            j++;
        }
//        printIntArray(nums);
        if (n % 2 != 0) return nums[n/2];
        else return (double)(nums[n/2] + nums[n/2-1]) / 2;

    }

    public static int romanToInt(String s) {
        //方法1
//        int result = 0;
//        int i = 0;
//        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        while (i < s.length()) {
//            for (int j = 0; j < romans.length; j++) {
//                if (i == s.length()-1 ) {
//                    if (s.substring(i, i + 1).equals(romans[j])) {
//                        result = result + nums[j];
//                        i++;
//                        break;
//                    }
//                }
//                else {
//                    if (s.substring(i, i+2).equals(romans[j])) {
//                        result = result + nums[j];
//                        i = i + 2;
//                        break;
//                    }
//                    else if (s.substring(i, i+1).equals(romans[j])) {
//                        result = result + nums[j];
//                        i++;
//                        break;
//                    }
//                }
//            }
//            System.out.println(result);
//
//        }
//        return result;//效率拉胯
        //方法2， 和方法1差不多，但是用map查，写法上优美一点
//        Map<String, Integer> map = new HashMap<>();
//        map.put("I", 1);
//        map.put("IV", 4);
//        map.put("V", 5);
//        map.put("IX", 9);
//        map.put("X", 10);
//        map.put("XL", 40);
//        map.put("L", 50);
//        map.put("XC", 90);
//        map.put("C", 100);
//        map.put("CD", 400);
//        map.put("D", 500);
//        map.put("CM", 900);
//        map.put("M", 1000);
//
//        int ans = 0;
//        for(int i = 0;i < s.length();) {
//            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
//                ans += map.get(s.substring(i, i+2));
//                i += 2;
//            } else {
//                ans += map.get(s.substring(i, i+1));
//                i ++;
//            }
//        }
//        return ans;//效率还是拉
        //方法3 这里用map来查找映射似乎效率不高，直接用switch会快很多
        Map<Character, Integer> map = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int sum = 0, prenum = map.get(s.charAt(0)), num = 0;
        for (int i = 1; i < s.length(); i++) {
            num = map.get(s.charAt(i));
            if (prenum < num) {
                sum -= prenum;
            }
            else {
                sum += prenum;
            }
            prenum = num;
        }
        return sum+prenum;
    }

    public static void searchTree(TreeNode node, int i, Map map1, Map map2) {
        if (node == null) return;
        else {
            if (node.left != null) map1.put(node.left.val, node);
            if (node.right != null) map1.put(node.right.val, node);
            map2.put(node.val, i);
            searchTree(node.left, i+1, map1, map2);
            searchTree(node.right, i+1, map1, map2);
        }
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, TreeNode> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        searchTree(root, 0, map1, map2);
        if (map1.get(x) != map1.get(y) && map2.get(x) == map2.get(y))
            return true;

        return false;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandString(s, i, i);
            int len2 = expandString(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }//中心扩展算法，还有时间复杂度可以到O(n)的马拉车算法，但比较复杂这里就不写了

    public static int expandString(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--; R++;
        }
        return R - L - 1;
    }

    public static int countTriplets(int[] arr) {
        //方法1， 暴力法
//        int result = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                for (int k = j; k < arr.length; k++) {
//                    int a = 0, b = 0, n = i, m = j;
//                    while (n < j) {
//                        a = a ^ arr[n];
//                        n++;
//                    }
//                    while (m <= k) {
//                        b = b ^ arr[m];
//                        m++;
//                    }
//                    if (a == b) {
//                        result++;
//                    }
//                }
//            }
//        }
//        return result;
        //方法2
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j; k < n; ++k) {
                    if (s[i] == s[k + 1]) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuffer newStr = new StringBuffer();
        boolean flag = true;//代表方向，true代表向下， false代表向上；
        StringBuffer[] str = new StringBuffer[numRows];
        for(int i=0;i<str.length ;i++){
            str[i] = new StringBuffer();
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            str[index].append(s.charAt(i));
            System.out.println(Integer.toString(index) + "\t" + str[index]);
            if (flag) {
                index++;
                if (index == numRows-1) flag = false;
            } else {
                index--;
                if (index == 0) flag = true;
            }
        }
        for (StringBuffer SB : str)
            newStr.append(SB);
        return newStr.toString();
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str: words) {
            if (map.containsKey(str)) {
                int num = map.get(str);
                map.put(str, num+1);
            }
            else {
                map.put(str, 1);
            }
            map = sortMapByValue(map);

        }
//        for (String string: map.keySet()) {
//            list.add(string);
//            System.out.println(string);
//            System.out.println(map.get(string));
//        }
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext() && i < k) {
            Map.Entry<String, Integer> entry = it.next();
            list.add(entry.getKey());
            i++;
        }
        return list;
        //精简版
//        Map<String, Integer> cnt = new HashMap<String, Integer>();
//        for (String word : words) {
//            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
//        }
//        List<String> rec = new ArrayList<String>();
//        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
//            rec.add(entry.getKey());
//        }
//        Collections.sort(rec, new Comparator<String>() {
//            public int compare(String word1, String word2) {
//                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
//            }
//        });
//        return rec.subList(0, k);
    }

    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) != 0)
                return o2.getValue().compareTo(o1.getValue());
            else return o1.getKey().compareTo(o2.getKey());
        });

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;

    }

    //动态规划，数组dp[i][j]表示nums1[0:i]和nums2[0:j]的最长公共子序列的长度
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int m = nums1.length, n = nums2.length;
        for (int i = 1 ; i <= m; i++) {
            int n1 = nums1[i-1];
            for (int j = 1; j <= n; j++) {
                int n2 = nums2[j-1];
                if (n1 == n2)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    //下面两种情况返回true：1 nums的长度为偶数 2 nums全部元素异或和为0
    public static boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum == 0;
    }

    public static void main(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> l = topKFrequent(str, 2);
        for (String s: l) {
            System.out.println(s);
        }


    }
}