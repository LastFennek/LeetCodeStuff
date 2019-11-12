package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        //int[] x = new int[]{0,1,0,2,3,4,0,0,0,5,6,7,0,8,0};
        //int[] x = new int[]{0};
        //int[] t = new int[]{2,2};
        //removeDuplicates(x,3);
        //System.out.println(containsDuplicate(x,3,3));
        //x = intersect(x,t);

        //x = plusOne(x);
        //moveZeroes(x);
        //System.out.println(isValidSudoku(new char[][]{{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));
        //prime(10);
      //  int[] x = (productExceptSelf(new int[]{1,2,3,4}));
        //Random rand = new Random();
        //for(int i = 0; i < 10; i++){
          //  System.out.print(rand.nextInt(5)+",");
        //}
        //System.out.println();
      //  System.out.println("hi");
        //for (int y : x){
          //  System.out.print(y+" | ");
        //}
        //int[] x = productExceptSelf3(new int[]{1,1,1,1,-1,1,5,1,-1,-1,-1,1,-1,1,-3,1,1,1,1,-1,1,-1,1,1,5,-1,1,-1,1,1,3,-1,-5,-1,1,-1,1,-1,-3,1,2,-1,1,-1,1,-1,1,1,1,1,1,-1,-1,-1,-3,-1,-1,4,-1,1,-1,1,-1,-1,-1,-1,3,1,4,-5,-1,1,1,1,1,1,-4,1,1,-3,-1,-1,1,3,-1,1,-2,1,-1,1,1,1,-1,1,1,1,-1});,1,1,1
        //ArrayList x = (ArrayList) spiralOrder2(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});//,{13,14,15,16}});
        //ArrayList x = (ArrayList) spiralOrder2(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        //ArrayList x = (ArrayList) spiralOrder2(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}});
        //ArrayList x = (ArrayList) spiralOrder2(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        //ArrayList x = (ArrayList) spiralOrder2(new int[][]{});
        //int[][] y = generateMatrix(5);[]
        //int[][] a = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        //int[][] a = new int[][]{{1},{1},{1}};
        //int[][] a = new int[][]{{1}};
        int x = maxPoints(new int[][]{{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}});
        //int[] a = new int[]{1,0,0,2,0,0,3};
        //int[] a = new int[]{0,0,0,0,0,0,0};
        //int[] a = new int[]{8,4,5,0,0,0,0,7};
        //int[] a = new int[]{1,2,0,3,4,0,5,6,0,7,0};
        //int[] a = new int[]{0,1};
        //duplicateZeros(a);
        //ArrayList x = (ArrayList) spiralOrder2(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        //for (int[] c : a){
            //for(int i : c){
            //    System.out.print(i +" ");
            //}
            //System.out.println();
        //}

        //System.out.println(maxAreaOfIsland(a));


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
                tempNew = nums[0+times];
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
            if(!(atm1 >= nums1.length || atm2 >= nums2.length)){
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
        int ret[];

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
        int sqrtZahl = (int)Math.sqrt((double)maxZahl);

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

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        if(grid.length == 0){
            return 0;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                    if(i == 0){
                        grid[i][j] += grid[i][j+1];
                    }else{
                        grid[i][j] += grid[i][j+1] + grid[i-1][j];
                    }
                    if(grid[i][j] > max){
                        max = grid[i][j];
                    }
            }
        }

        return max;
    }

    public static int summeArray(int[] arr){
        int summe = 0;
        for(int i : arr){
            summe += i;
        }
        return summe;
    }

    public static int maxPoints(int[][] points) {
        int num;
        HashMap<Integer, Integer> nums = new HashMap<>();

        for(int[] x : points){

        }

        return 0;
    }
}