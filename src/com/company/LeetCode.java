package com.company;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        //System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));

        //int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //rotate(arr);
        //System.out.println(arr);

        TreeNode tn1 = new TreeNode(1);
        tn1.left = new TreeNode(2);

        tn1.right = new TreeNode(2);

        System.out.println(isSymmetric(tn1));

        System.out.println(numDistinct("bbit","bit"));

    }

    public static int[] nums;
    public static List<List<Integer>> fourSum(int[] A, int target){
        ret = new ArrayList<>();
        int anzahlNummern = 4;

        if (A.length <  4) return ret;

        nums = A;
        Arrays.sort(nums);

        int minsum = 0, sum = 0;
        for(int j = 0; j < nums.length; j++){
            if(j <= anzahlNummern-1){
                minsum += nums[j];
            }
            sum += nums[j];
        }
        solveForNumber(anzahlNummern,nums.length-1, target, minsum, new ArrayList<>());
        return ret;
    }

    static List<List<Integer>> ret = new ArrayList<>();
    public static void solveForNumber(int n, int end, int sum, int minsum, List<Integer> list){

        if(n == 1){
            if(Arrays.binarySearch(nums,n-1,end+1,sum) >= 0){
                ret.add(new ArrayList<>(list));
                ret.get(ret.size()-1).add(sum);
            }
            return;
        }
        if(minsum == sum){
            ret.add(new ArrayList<>(list));
            for(int j = 0; j < n; j++){
                ret.get(ret.size()-1).add(nums[j]);
            }
            return;
        }

        end = binarySearch0(nums, n-1, end, sum-(minsum-nums[n-1]))+1;

        int maxsum = 0;
        for(int x = end; x > end - n; x--) maxsum += nums[x];

        for(int i = end; i >= n; i--){
            if(maxsum < sum- (nums[i] > 0 ? nums[i] : -nums[i]))
                return;
            if(i == end || nums[i] != nums[i+1]){
                list.add(nums[i]);
                solveForNumber(n-1,  i-1, sum-nums[i], minsum-nums[n-1], list);
                list.remove(list.indexOf(nums[i]));
            }
            maxsum = maxsum-nums[i]+nums[i-n];
        }

        return;
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while(low <= high) {
            int mid = low + high >>> 1;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else {
                if (midVal <= key) {
                    return mid;
                }

                high = mid - 1;
            }
        }
        return low - 1;
    }


    public static String longestPalindrome(String s) {
        String max = "";

        for(int i = 0; i < s.length(); i++){
            int j = 1;
            while(j + i < s.length() && i - j >= 0 && s.charAt(i+j) == s.charAt(i-j)){
                j++;
            }
            if(2*j > max.length()){
                max = s.substring(i-j+1, i+j+1);
            }
        }
        return max;
    }

    static int surfaceArea(int[][] A) {
        double surface = 0;

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] > 0)
                    surface += 2;

                if(1 == A.length){
                    surface += 2*A[i][j];
                }else{
                    if(i == 0){
                        surface += A[i][j] + (double)Math.abs(A[i][j] - A[i+1][j])/2;
                    }else if(i == A.length-1){
                        surface += A[i][j] + (double)Math.abs(A[i][j] - A[i-1][j])/2;
                    }else{
                        surface += (double)Math.abs(A[i][j] - A[i+1][j])/2 + (double)Math.abs(A[i][j] - A[i-1][j])/2;
                    }
                }



                if(1 == A[i].length){
                    surface += 2*A[i][j];
                }else{
                    if(j == 0){
                        surface += A[i][j] + (double)Math.abs(A[i][j] - A[i][j+1])/2;
                    }else if(j == A[i].length-1){
                        surface += A[i][j] + (double)Math.abs(A[i][j] - A[i][j-1])/2;
                    }else{
                        surface += (double)Math.abs(A[i][j] - A[i][j+1])/2 + (double)Math.abs(A[i][j] - A[i][j-1])/2;
                    }
                }
            }
        }

        return (int)surface;
    }

    static int[] absolutePermutation(int n, int k) {



        int[] ans = new int[n];
        int shitty=k;
        for(int i = 0; i < n; i++){
            if(shitty == -k){
                shitty = k;
            }
            if(shitty > 0){
                ans[i] = (i+k+1) % n;
                if(ans[i] <= 0)
                    ans[i] += n;
            }else{
                ans[i] = (i-k+1) % n;
                if(ans[i] <= 0)
                    ans[i] += n;
            }
            shitty--;
        }

        for(int i = 0; i < ans.length; i++){
            if(Math.abs(ans[i]-(i+1)) != k)
                return new int[]{-1};
        }


        return ans;
    }



    static int equal(int[] arr) {
        int[] maxMin = getMaxMin(arr);
        int[] pieces = new int[]{1,2,5};
        int counter = 0;

        while(maxMin[0] != maxMin[1]){
            int plus = maxMin[0]-maxMin[1] >= 5 ? 5 : maxMin[0]-maxMin[1] >= 2 ? 2 : 1;
            int times = (maxMin[0] - maxMin[1] - ((maxMin[0] - maxMin[1]) % plus)) / plus;
            counter += times;
            plus(arr, plus*times, maxMin[0]);
            maxMin = getMaxMin(arr);
        }
        return counter;
    }
    static void plus(int[] arr, int plu, int max){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != max){
                arr[i] += plu;
            }
        }
    }
    static int[] getMaxMin(int[] arr){
        int[] maxMin = new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
        for(int x : arr){
            if (x > maxMin[0])
                maxMin[0] = x;

            if (x < maxMin[1])
                maxMin[1] = x;
        }
        return maxMin;
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] += (j > 0 && j < dp[0].length ? dp[i][j-1] : 0) + (i > 0 && i < dp.length ? dp[i-1][j] : 0);
            }
        }

        return dp[m-1][n-1];
    }


    static int fibonacciModified(int t1, int t2, int n) {

        double a = t1;
        double b = t2;
        boolean sw = true;
        for(int i = 2; i < n; i++){
            if(sw){
                a = (a + Math.pow(b,2));
            }else{
                b = (b + Math.pow(a,2));
            }
            sw = !sw;
        }

        return n % 2 == 0 ? (int)(a % Integer.MAX_VALUE) : (int)(b % Integer.MAX_VALUE);
    }

    static int primeCount(long n) {
        /*
         * Write your code here.
         */
        int maxNum = (int)Math.log(n)*3;
        BitSet mash = new BitSet();


        int atm = 1;

        while(atm <= Math.sqrt(maxNum)){
            atm = mash.nextClearBit(atm+1);
            int plus = atm == 2 ? atm : 2*atm;
            for(int i = atm*atm; i <= maxNum; i += plus){
                mash.set(i);
            }
        }
        mash.set(0);
        mash.set(1);

        int counter = 0;
        long sum = 1;
        int index = 1;

        while(sum < n && sum > 0){
            index = mash.nextClearBit(index+1);
            sum *= index;
            ++counter;
        }

        return counter -(sum == n ? 0 : 1);
    }




    private static final BigDecimal HANDLING_COSTS_IN_PERCENT = new BigDecimal("0.02");
    private static final BigDecimal NO_RISK = new BigDecimal("0.0");
    private static final BigDecimal SMOKING_SURCHARGE_IN_PERCENT = new BigDecimal("0.03");
    private static final BigDecimal RISKY_PROFESSIONAL_GROUP_SURCHARGE_IN_PERCENT = new BigDecimal("0.05");
    private static final BigDecimal EXTREME_ATHLETE_SURCHARGE_IN_PERCENT = new BigDecimal("0.08");




    public static int getPayout(List<Risk> risks, int lifetimeInYears, LocalDate policyStartDate, int monthlyPayment){

        BigDecimal rate = new BigDecimal("1.0");
        year yr = getYear(policyStartDate);
        rate = rate.subtract(shittySolution(yr));

        for(Risk x : risks){
            rate = rate.subtract(shittySolution(x, yr));
        }


        return (int)((double)(monthlyPayment * 12 * lifetimeInYears * rate.doubleValue()));

    }
    public enum Risk {
        NOTHING, SMOKER, EXTREME_ATHLETE, PROFESSIONAL_GROUP
    }

    private enum year {
        Y2019, Y2020, Y2022
    }
    /*

     */
    private static BigDecimal shittySolution(Risk risk, year yr){

        BigDecimal bd = new BigDecimal("0.0");
        switch (risk){

            case EXTREME_ATHLETE:
                bd = bd.add(yr == year.Y2019 ? new BigDecimal("0.08") : (yr == year.Y2020 ? new BigDecimal("0.075") : new BigDecimal("0.075")));
                break;

            case SMOKER:
                bd = bd.add(yr == year.Y2019 ? new BigDecimal("0.03") : (yr == year.Y2020 ? new BigDecimal("0.04") : new BigDecimal("0.04")));
                break;

            case PROFESSIONAL_GROUP:
                bd = bd.add(yr == year.Y2019 ? new BigDecimal("0.05") : (yr == year.Y2020 ? new BigDecimal("0.05") : new BigDecimal("0.065")));
                break;

            case NOTHING:
                break;


        }

        return bd;
    }
    private static BigDecimal shittySolution(year yr){
        BigDecimal bd = new BigDecimal("0.0");
        bd = bd.add(yr == year.Y2019 ? new BigDecimal("0.02") : (yr == year.Y2020 ? new BigDecimal("0.025") : new BigDecimal("0.03")));
        return bd;
    }

    private static year getYear(LocalDate date){

        if(date.isAfter(LocalDate.parse("2022-05-31"))){
            return year.Y2022;
        }else if(date.isAfter(LocalDate.parse("2020-05-31"))){
            return year.Y2020;
        }else{
            return year.Y2019;
        }
    }


    public static String countAndSay(int n) {
            StringBuilder st = new StringBuilder();
            st.append("1");

            n--;
            for(int i = 0; i < n; i++){
                if(i == 2){
                    System.out.println("hi");
                }
                int counter = 0;
                char temp = st.charAt(0);
                StringBuilder nSt = new StringBuilder();
                for(int j = 0; j <= st.length(); j++){
                    if(j < st.length() && st.charAt(j) == temp){
                        counter++;
                    }else{
                        nSt.append(counter).append(temp);
                        counter = 1;
                        if(j<st.length()){
                            temp = st.charAt(j);
                        }
                    }
                }
                st = nSt;
            }

            return st.toString();
        }


    public static void rotate(int[][] matrix) {
        int shell = 0;
        int temp = 5;
        for(int i = shell; i < matrix.length * matrix.length; i += temp){
            shell = i % matrix.length;

        }
    }



    public static ArrayList<TreeNode> ar = new ArrayList();

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else if(root.left == null && root.right == null){
            return true;
        }
        ar.add(root.left);
        ar.add(root.right);
        return symTest(ar);
    }

    public static boolean symTest(ArrayList<TreeNode> al){

        if(al.size() < 2){
            return true;
        }
        boolean ret = true;
        if(al.get(0) == null || al.get(al.size()-1) == null){

            ret &= al.get(0) == null && al.get(al.size()-1) == null;
            al.remove(0);
            al.remove(al.size()-1);
        }else{
            if(al.get(0).val != al.get(al.size()-1).val){
                return false;
            }
            al.add(0,al.get(0).left);
            al.add(1,al.get(1).right);
            al.add(al.size(), al.get(al.size()-1).left);
            al.add(al.size(), al.get(al.size()-2).right);
            al.remove(2);
            al.remove(al.size()-3);
        }

        if(!ret){
            return false;
        }



        return symTest(al);
    }


    public static int ans = 0;
    public static int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        if(t.equals(s)) return 1;
        distRec(t, s);
        return ans;
    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void distRec(String t, String s){
        if(t.length() == 1 && s.length() >= 1){
            if(t.charAt(0) == s.charAt(0))
                ans++;
            if(s.indexOf(t,1) >= 0){
                distRec(t,s.substring(1));
            }
        }
        while(t.length() > 1 && s.length() >= 1 && s.indexOf(t.charAt(0)) >= 0 && t.length() <= s.length()){
            distRec(t.substring(1),s.substring(s.indexOf(t.charAt(0))+1));
            s = s.substring(1);
        }
    }

//    public int ans = 0;
//    public int numDistinct(String s, String t) {
//
//        int[] dp = new int[s.length()];
//
//
//        for(int i = 0; i < s.length(); i++){
//
//        }
//
//        return 0;
//    }
}










