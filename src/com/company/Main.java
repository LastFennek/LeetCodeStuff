package com.company;


import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Random rand = new Random();[][][][][]
        //System.out.println(splitArraySameAverage(new int[]{2,12,18,16,19,3}));
        //System.out.println(splitArraySameAverage(new int[]{5,3,11,19,2}));
        //long time = System.nanoTime();
        //System.out.println(splitArraySameAverage(new int[]{3,5,10,18}));

        //System.out.println(splitArraySameAverage(new int[]{1,2,3,4,5,6,7,9}));
        //System.out.println(splitArraySameAverage(new int[]{12,1,17,8,2}));
        //System.out.println(splitArraySameAverage(new int[]{60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30}));
        //System.out.println(splitArraySameAverage(new int[]{1817,3082,8735,9101,2576,3473,9941,5336,8452,2584,2518,3196,1421,8460,6863,6956,3668,17}));
        //System.out.println(splitArraySameAverage(new int[]{1,3,53,5,5,5,6,7,20,62,4,2,8,69,2,55,45,124,5,1,65,2,1,2,3,7,8,9,5,85,9,5,5,44,51,78}));
        //System.out.println(splitArraySameAverage(new int[]{0,13,13,7,5,0,10,19,5}));
        //int[] a = new int[]{1,2,3,4,4,6,7,8,9};
        //int x = Arrays.binarySearch(a, 10);
        //System.out.println(x);
        //System.out.println(splitArraySameAverage(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,3015}));
        System.out.println(splitArraySameAverage(new int[]{4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5}));
        //System.out.println(splitArraySameAverage2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,-29}));
        //System.out.println(splitArraySameAverage(new int[]{1,2,3,4,5,6,7,8}));
        //Main mn = new Main();[][]
        //System.out.println(isPalindrome("OP"));
        //System.out.println(splitArraySameAverage(new int[]{17,3,7,12,1}));
        //System.out.println(splitArraySameAverage(new int[]{5,3,11,19,2}));
        //System.out.println(splitArraySameAverage(new int[]{17,5,5,1,14,10,13,1,6}));[]
        //System.out.println(splitArraySameAverage(new int[]{0,13,13,7,5,0,10,19,5}));
        //System.out.println(splitArraySameAverage(new int[]{2,0,5,6,16,12,15,12,4}));
        //long time2 = System.nanoTime();

        //System.out.println(((time2-time)/1000_000));
        //System.out.println(checkPossibility(new int[]{1,2,3}));

    }


    public boolean isGoodArray(int[] nums) {


        return false;
    }

    public static void removeDuplicates(int[] nums,int k) {

        k -= nums.length*(k/nums.length);
        if(k == 0)return;

        int index = k;
        int tempOld = 0;
        int tempNew = nums[0];

        int counter = 0;
        int times = 0;

        do{
            tempOld = tempNew;
            tempNew = nums[index];
            nums[index] = tempOld;
            index = (index+k)%-(nums.length);

            if(index == k+times){
                times++;
                index = k+times;
                tempNew = nums[times];
            }
            counter++;
        }while(counter < nums.length);


    }

    public static boolean containsDuplicate(int[] nums){
        BitSet hs = new BitSet();

        int min = Integer.MAX_VALUE;
        for(int x : nums){
            if(x < min){
                min = x;
            }
        }

        for(int x : nums){
            x+=Math.abs(min);
            if(hs.get(x)){
                return true;
            }else{
                hs.set(x);
            }
        }

        return false;
    }

    public static boolean containsDuplicate(int[] nums, int num){
        HashSet hs = new HashSet();

        for(int x = 0; x < num && x < nums.length; x++){
            if(hs.contains(nums[x])){
                return true;
            }else{
                hs.add(nums[x]);
            }
        }

        for(int x = num; x < nums.length; x++){
            if(hs.contains(nums[x])){
                return true;
            }else{
                hs.add(nums[x]);
            }
            hs.remove(nums[x-num]);
        }

        return false;
    }

    public static boolean containsDuplicate(int[] nums, int num, int abst){
        TreeSet hs = new TreeSet();

        if(num == 0){ return false;}

        for(int x = 0; x < nums.length; x++){

            boolean test = false;
            if(hs.higher(nums[x]-abst-1) != null){
                test = true;
            }else if(Integer.MIN_VALUE - nums[x] > abst+1 ){
                test = true;
            }
            if(test){

            }

            if(test && (int)hs.higher(nums[x]-abst-1) <= (long)nums[x]+abst){
                return true;
            }


            hs.add(nums[x]);

            if(x >= num){
                hs.remove(nums[x-num]);
            }
        }


        return false;
    }

    public static int[] intersect(int[] nums1, int[] nums2){

        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int atm1 = 0;
        int atm2 = 0;

        int[] finished = new int[nums1.length + nums2.length];

        int counter = 0;

        for(int i = 0; i < nums1.length + nums2.length; i++){
            if(nums1[atm1] == nums2[atm2]){
                finished[counter] = (nums1[atm1]);
                counter++;
                atm1++;
            }
            if(!(atm1 >= nums1.length)){
                if(nums1[atm1] >= nums2[atm2]){
                    atm2++;
                }else{
                    atm1++;
                }
            }

            if(atm1 >= nums1.length || atm2 >= nums2.length){
                break;
            }
        }

        int[] finArr = new int[counter];
        System.arraycopy(finished,0, finArr,0,counter);
        return finArr;
    }

    public static int[] plusOne(int[] digits) {

        Boolean nine = true;
        int[] ret;

        if(digits[digits.length-1] == 9){
            for(int x : digits){
                if(x != 9){
                    nine = false;
                    break;
                }
            }
            if(nine){
                ret = new int[digits.length+1];
                System.arraycopy(digits, 0, ret,1, digits.length);
            }else{
                ret = digits;
            }

            int counter = ret.length-1;
            do{
                ret[counter]++;
                ret[counter] %= 10;
                counter--;
            }while(ret[counter] == 9);
            ret[counter]++;

        }else{
            digits[digits.length-1]++;
            return digits;
        }

        return ret;
    }

    public static void moveZeroes(int[] nums) {

        int nullen = 0;

        for(int i = 0; i < nums.length+nullen; i++){
            if(i < nums.length){
                if(nums[i] == 0){
                    nullen++;
                }else{
                    nums[i-nullen] = nums[i];
                }
            }else {
                nums[i-nullen] = 0;
            }
        }
    }

    public static void prime(int n){
        int ts1 = (int) new Date().getTime();

        int maxZahl = n;
        int sqrtZahl = (int)Math.sqrt(maxZahl);

        BitSet Zahlen = new BitSet(maxZahl);


        Zahlen.set(1,maxZahl);



        for(int x = 2;x<(sqrtZahl+1);){
            for(int c = x; c < maxZahl;){
                c+=x;
                Zahlen.clear(c);

            }
            x = Zahlen.nextSetBit((x+1));
        }

        int ts2 = (int) new Date().getTime();
        System.out.println("Zeit bis Beendet: "+(ts2-ts1));

        int anzahl = 0;
        int c = 1;
        System.out.println(Zahlen.cardinality());
    }

    public static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> numsSet = new HashSet<>();
        HashSet<Integer> db = new HashSet<>();

        for(int x : nums){
            if(numsSet.contains(x)){
                db.add(x);
            }
            numsSet.add(x);
        }

        int[] ans = new int[2];
        int firstnum = 0;

        for(int x : numsSet){
            if(numsSet.contains(target - x) && (x != target-x || db.contains(target-x))){
                firstnum = x;
                break;
            }
        }

        Boolean x = true;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == firstnum && x){
                if(firstnum >= target - firstnum){
                    ans[1] = i;
                }else{
                    ans[0] = i;
                }
                x = false;
            }else if(nums[i] == target - firstnum){
                if(firstnum >= target - firstnum){
                    ans[0] = i;
                }else{
                    ans[1] = i;
                }
            }
        }
        return ans;
    }

    public static boolean isValidSudoku(char[][] board) {

        HashSet<Character> check = new HashSet();

        for(char[] x : board){
            for(char y : x){
                if(y != '.'){
                    if(check.contains(y)){
                        return false;
                    }else{
                        check.add(y);
                    }
                }
            }
            check = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if(board[j][i] != '.'){
                    if(check.contains(board[j][i])){
                        return false;
                    }else{
                        check.add(board[j][i]);
                    }
                }
            }
            check = new HashSet<>();
        }

        int xDif = 0;
        int yDif = 0;

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                check = new HashSet<>();

                for(int d = 0; d < 3; d++){
                    for(int q = 0; q < 3; q++){

                        if(board[d+yDif][q+xDif] != '.'){
                            if(check.contains(board[d+yDif][q+xDif])){
                                return false;
                            }else{
                                check.add(board[d+yDif][q+xDif]);
                            }
                        }

                    }
                }

                yDif += 3;
            }
            yDif = 0;
            xDif += 3;
        }



        return true;
    }

    public static void rotate(int[][] matrix) {

    }

    public static int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];
        int fmlX = nums[0];
        int[] fml = new int[nums.length];


        for(int i = nums.length-1; i >= 0; i--){
            if(i == nums.length-1){
                fml[i] = nums[i];
            }else{
                fml[i] = fml[i+1] * nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                output[i] = fml[i+1];
            }else if(i == nums.length-1){
                output[i] = fmlX;
                fmlX *= nums[i];
            }else{
                output[i] = fml[i+1]*fmlX;
                fmlX *= nums[i];
            }
        }

        return output;
    }

    public static int[] productExceptSelf2(int[] nums) {
        return (int[]) productExceptSelfRek(nums,0,new int[nums.length],1)[1];
    }

    public static Object[] productExceptSelfRek(int[] nums,int counter, int[] output, int sum) {
        if(counter == nums.length-1){
            output[counter] = sum;
            return new Object[]{nums[counter]};
        }
        int x = (int)productExceptSelfRek(nums, counter+1, output, sum*nums[counter])[0];
        output[counter] = sum * x;
        return new Object[]{x*(nums[counter]),output};
    }

    public static int[] productExceptSelf3(int[] nums){

        int total = 1;
        int zahl = 0;
        int counter = 0;
        int nullen = 0;
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nullen++;
                index = i;
            }else{
                total *= nums[i];
            }
        }

        if(nullen > 1){
            return new int[nums.length];
        }
        if(nullen == 1){
            nums = new int[nums.length];
            nums[index] = total;
            return nums;
        }

        for(int i = 0; i < nums.length; i++){
                if(total < 0){
                    if(nums[i] > 0){
                        while(zahl > total){
                            zahl -= nums[i];
                            counter--;
                        }
                    }else{
                        while(zahl > total) {
                            zahl += nums[i];
                            counter++;
                        }
                    }
                }else{
                    if (nums[i] > 0) {
                        while (zahl < total) {
                            zahl += nums[i];
                            counter++;
                        }
                    } else {
                        while (zahl < total) {
                            zahl -= nums[i];
                            counter--;
                        }
                    }
                }

            nums[i] = counter;
            zahl = 0;
            counter = 0;
        }
        return nums;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int shell = 0;
        int x = 0;
        int y = 0;
        boolean modeX = true;
        boolean modePMX = true;
        boolean modePMY = true;
        ArrayList<Integer> output = new ArrayList<>();
        output.add(matrix[0][0]);

        for(int i = 0; i < (matrix[0].length*matrix.length*matrix.length)-2; i++){
            if(modeX){
                if(modePMX){
                    x++;
                }else{
                    x--;
                }
            }else{
                if(modePMY){
                    y++;
                }else{
                    y--;
                }
            }

            if(x == shell && y == shell){
                shell++;
                y++;
                x++;
            }

            if(modeX && (x >= matrix[0].length-(shell) || x <= shell-1)){
                modeX = false;
                modePMX = !modePMX;
                if(modePMX){
                    x++;
                }else{
                    x--;
                }
            }else if(!modeX && (y >= matrix.length-(shell) || y <= shell)){
                modeX = true;
                modePMY = !modePMY;
                if(modePMY){
                    y++;
                }else{
                    y--;
                }
            }else{
                output.add(matrix[y][x]);
            }
        }
        return output;
    }

    public static List<Integer> spiralOrder2(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();

        int shell = 0;
        boolean xpl = true;
        boolean ypl = true;
        boolean modeX = true;

        while(true){
            if(modeX){
                if(xpl){
                    for(int i = shell; i < matrix[0].length-(shell); i++){
                        output.add(matrix[shell][i]);
                    }
                }else{
                    for(int i = matrix[0].length-(shell+2); i >= shell; i--){
                        output.add(matrix[matrix.length-shell-1][i]);
                    }
                }
                xpl = !xpl;
                modeX = false;
            }else{
                if(ypl){
                    for(int i = 1+shell; i < matrix.length-(shell); i++){
                        output.add(matrix[i][matrix[0].length-shell-1]);
                    }
                }else {
                    for(int i = matrix.length-(shell+2); i > shell; i--){
                        output.add(matrix[i][shell]);
                    }
                    shell++;
                }
                ypl = !ypl;
                modeX = true;
            }
            if(output.size() >= matrix[0].length*matrix.length){
                break;
            }
        }

        return output;
    }

    public static int[][] generateMatrix(int len){
        if(len == 0){
            return new int[][]{};
        }

        int[][] arr = new int[len][len];

        int counter = 1;
        int shell = 0;
        boolean xpl = true;
        boolean ypl = true;
        boolean modeX = true;


        while(true){
            if(modeX){
                if(xpl){
                    for(int i = shell; i < len-(shell); i++){
                        arr[shell][i] = counter;
                        counter++;
                    }
                }else{
                    for(int i = len-(shell+2); i >= shell; i--){
                        arr[len-shell-1][i] = counter;
                        counter++;
                    }
                }
                xpl = !xpl;
                modeX = false;
            }else{
                if(ypl){
                    for(int i = 1+shell; i < len-(shell); i++){
                        arr[i][len-shell-1] = counter;
                        counter++;
                    }
                }else {
                    for(int i = len-(shell+2); i > shell; i--){
                        arr[i][shell] = counter;
                        counter++;
                    }
                    shell++;
                }
                ypl = !ypl;
                modeX = true;
            }
            if(counter-1 >= len*len){
                break;
            }
        }

        return arr;
    }

    public static void duplicateZeros(int[] arr) {
        int nullen = 0;
        int counter = 0;

        if(arr.length <= 2){
            if(arr.length == 1){
                return;
            }else if(arr.length == 2){
                if(arr[0] == 0){
                    arr[1] = 0;
                }
                return;
            }
        }

        while((counter+nullen) < arr.length){
            if(arr[counter] == 0){
                nullen++;
            }
            counter++;
        }
        int j = 1;
        if(counter + nullen > arr.length){
            j = 2;
            arr[arr.length-1] = arr[arr.length-1-(nullen-1)];
            nullen--;
        }

        for(int i = arr.length-j; i >= 0; i--){
            if(arr[i-nullen] == 0){
                arr[i] = arr[i-nullen];
                if(i>0){
                    arr[i-1] = 0;
                }
                i--;
                nullen--;
            }else{
                arr[i] = arr[i-(nullen)];
            }
            if(nullen == 0){
                break;
            }
        }
    }

    public static int[][] arr;
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        arr = grid;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                max = arr[i][j] == 0 ? max : Math.max(getNumberOfConnections(i,j),max);
            }
        }
        return max;
    }

    public static int getNumberOfConnections(int y, int x){
        if(x < 0 || x > arr[0].length-1 || y > arr.length-1 || y < 0 ||  arr[y][x] == 0){
            return 0;
        }
        arr[y][x] = 0;
        return getNumberOfConnections(y-1,x) + getNumberOfConnections(y+1,x) + getNumberOfConnections(y,x-1) + getNumberOfConnections(y,x+1) + 1;
    }

    public static void printArray(int[][] arr){
        for(int[] x : arr){
            for(int y : x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }

    public static int summeArray(int[] arr){
        int summe = 0;
        for(int i : arr){
            summe += i;
        }
        return summe;
    }

    public static int maxPoints2(int[][] points) {
        if(points.length == 0){
            return 0;
        }else if(points.length == 1){
            return 1;
        }
        HashMap<String, Integer> yAtZero = new HashMap<>();
        HashMap<Integer, Integer> inf = new HashMap<>();

        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i != j){
                    int[] p1 = points[i];
                    int[] p2 = points[j];


                    double yZero;
                    if(p1[1]-p2[1] != 0 && p1[0] != p2[0]){
                        double k = (double)(p1[1]-p2[1])/(double)(p1[0]-p2[0]);
                         yZero =  p1[1]-(p1[0]*k);
                    }else if(p1[1]-p2[1] == 0 && p1[0] != p2[0]){
                        yZero = p1[1];
                    }else{
                        if(inf.containsKey(p1[0])){
                            inf.put(p1[0],inf.get(p1[0])+1);
                        }else{
                            inf.put(p1[0],1);
                        }
                        continue;
                    }

                    String num;
                    if((p2[0] > p1[0] && p2[1] < p1[1]) || (p2[0] < p1[0] && p2[1] > p1[1])){
                        num = "-"+String.valueOf(yZero+0.0000).substring(0,5);
                    }else{
                        num = String.valueOf(yZero+0.0000).substring(0,5);
                    }

                    /*
                    if(i == 8 && j == 3){
                        System.out.println("hi");
                    }*/



                    if(yAtZero.containsKey(num)){
                        yAtZero.put(num,yAtZero.get(num)+1);
                    }else{
                        yAtZero.put(num,1);
                    }
                }
            }
        }

        int max = 0;
        for(Map.Entry<String,Integer> x: yAtZero.entrySet()){
            if(x.getValue() > max){
                max = x.getValue();
            }
        }

        for(Map.Entry<Integer,Integer> x: inf.entrySet()){
            if(x.getValue() > max){
                max = x.getValue();
            }
        }

        return (int) Math.sqrt(max+1)+1;
    }

    public static int maxPoints(int[][] points) {
        if(points.length == 0){
            return 0;
        }else if(points.length == 1){
            return 1;
        }

        HashSet<double[]> YKXTimes = new HashSet<>();//y k x times
        HashMap<Integer,int[]> pointsUsed = new HashMap<>();
        HashSet<double[]> temp = new HashSet<>();
        int max = 0;

        for(int i = 0; i < points.length; i++){

            int[] point = points[i];

            for(double[] x : YKXTimes){
                if(Math.abs(point[1] - ((point[0]-x[2])*x[1]+x[0])) < 0.0000000001 || (point[0] == x[2] && x[1] == 0)){
                    temp.add(x);
                }
            }
            for(double[] x : temp){
                YKXTimes.add(new double[]{point[1],x[1],point[0],x[3]+1});
                YKXTimes.remove(x);
            }

            boolean test;
            for(Map.Entry<Integer, int[]> x : pointsUsed.entrySet()){
                Double k = (double)(point[1]-x.getValue()[1])/(double)(point[0]-x.getValue()[0]);
                if(k.isInfinite()){
                    k = 0.0;
                }
                test = true;
                for(double[] z : temp){
                    if(z[1] == k && k != 0){
                        test = false;
                    }
                }
                if(test){
                    YKXTimes.add(new double[]{point[1],k,point[0],x.getValue()[2]+1});
                }
            }
            temp = new HashSet<>();

            if(pointsUsed.containsKey(Arrays.hashCode(point))){
                pointsUsed.get(Arrays.hashCode(point))[2]++;
            }else{
                pointsUsed.put(Arrays.hashCode(point),new int[]{point[0],point[1],1});
            }
        }



        for(double[] x : YKXTimes){
            if(x[3] > max){
                max = (int) x[3];
            }
        }

        return max;
    }


    public static boolean parseBoolExpr(String expression) {
        if(expression.charAt(0) == '&'){
            return and(solver(expression));
        }else if(expression.charAt(0) == '|'){
            return or(solver(expression));
        }else if(expression.charAt(0) == '!'){
            return not(solver(expression));
        }else return expression.charAt(0) != 'f';
    }

    public static boolean and (String[] expressions){
        boolean ret = true;

        for(int i = 0; i < expressions.length; i++){
            if(expressions[i].charAt(0) == 'f'){
                return false;
            }else if(expressions[i].charAt(0) == 't'){
            }else if(expressions[i].charAt(0) == '!'){
                ret &= not(solver(expressions[i]));
            }else if(expressions[i].charAt(0) == '&'){
                ret &= and(solver(expressions[i]));
            }else{
                ret &= or(solver(expressions[i]));
            }
        }
        return ret;
    }
    public static boolean not (String[] expressions){
        if(expressions[0].charAt(0) == 'f'){
            return true;
        }else if(expressions[0].charAt(0) == 't'){
            return false;
        }else if(expressions[0].charAt(0) == '!'){
            return !not(solver(expressions[0]));
        }else if(expressions[0].charAt(0) == '&'){
            return !and(solver(expressions[0]));
        }else{
            return !or(solver(expressions[0]));
        }
    }
    public static boolean or (String[] expressions){
        boolean ret = false;
        for(int i = 0; i < expressions.length; i++){
            if(expressions[i].charAt(0) == 't'){
                return true;
            }else if(expressions[i].charAt(0) == 'f'){
            }else if(expressions[i].charAt(0) == '!'){
                ret |= not(solver(expressions[i]));
            }else if(expressions[i].charAt(0) == '|'){
                ret |= or(solver(expressions[i]));
            }else{
                ret |= and(solver(expressions[i]));
            }
            if(ret){return true;}
        }
        return ret;
    }
    public static String[] solver(String exression){

        char[] arr = exression.substring(2,exression.length()-1).toCharArray();
        int klammern = 0;
        List<String> list = new ArrayList<>();
        StringBuilder toAdd = new StringBuilder();

        for(char i : arr) {
            if (i == '(') {
                klammern++;
            } else if (i == ')') {
                klammern--;
            }
            if (i == ',' && klammern == 0) {
                list.add(toAdd.toString());
                toAdd = new StringBuilder();
            } else {
                toAdd.append(i);
            }
        }

        list.add(toAdd.toString());
        return list.toArray(new String[0]);
    }
    public static String test = "OP";
    public static void test(){

        test.indexOf("a");
    }


    public static int gettimes(double d){
        d = d%1;
        double times = 1;

        while (d%1 > 0.00001){
            d = d%1;
            d = 1/d;
            times *= d;
        }

        return (int)times;
    }

    public static int[] nums;
    public static Boolean splitArraySameAverage(int[] A){


        if (A.length <= 1) return false;
        if (A.length == 2) return A[0] == A[1];

        nums = A;
        Arrays.sort(nums);

        int sum = 0;
        for(int x : nums){
            sum += x;
        }

        double avg = (double)sum/nums.length;
        int minnum = gettimes(avg);

        for(int i = minnum; i <= (nums.length / 2)-((nums.length / 2)%minnum); i += minnum){
            int minsum = 0;
            for(int j = 0; j < i-1; j++) minsum += nums[j];
            if(solveForNumber(i,nums.length-1, (int) (avg*i), minsum)) return true;
        }
        return false;
    }

    public static boolean solveForNumber(int n, int end, int sum, int minsum){

        if(n == 1){
            if(Arrays.binarySearch(nums,n-1,end+1,sum) >= 0)
                return true;
            return false;
        }

        end = binarySearch0(nums, n-1, end, sum-minsum)+1;

        int maxsum = 0;
        for(int x = end; x > end - n; x--) maxsum += nums[x];

        for(int i = end; i >= n; i--){
            if(maxsum < sum-nums[i])
                return false;
            if(i == end || nums[i] != nums[i+1]){
                if(solveForNumber(n-1,  i-1, sum-nums[i], minsum-nums[n-2]))
                    return true;
            }
            maxsum = maxsum-nums[i]+nums[i-n];
        }

        return false;
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

    public static boolean isPalindrome(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int leftAdd = 0;
        int rightAdd = 0;

        for(int i = 0; i+i+rightAdd+leftAdd < cs.length-1; i++){

            while(i+leftAdd < cs.length && (cs[i+leftAdd] < 65 || cs[i+leftAdd] > 90) && (cs[i+leftAdd] < 97 || cs[i+leftAdd] > 122)){
                leftAdd++;
            }
            while(i+rightAdd < cs.length && (cs[cs.length-(1+i+rightAdd)] < 65 || cs[cs.length-(1+i+rightAdd)] > 90) && (cs[cs.length-(1+i+rightAdd)] < 97 || cs[cs.length-(1+i+rightAdd)] > 122)){
                rightAdd++;
            }
            if(i+rightAdd < cs.length && i+leftAdd < cs.length && cs[i+leftAdd] != cs[cs.length-(1+i+rightAdd)]){
                return false;
            }
        }
        return true;
    }



    public static boolean checkPossibility(int[] nums) {
        if(nums.length <= 2){
            return true;
        }

        int x = 1;
        while(nums[x-1] <= nums[x] && x < nums.length-1){
            x++;
        }
        if(x != nums.length-1 && x >= 2){
            if(nums[x-1] > nums[x+1] && nums[x-2] > nums[x]){
                return false;
            }
        }
        x++;
        for(int i = x;i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }
}
