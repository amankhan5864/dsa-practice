package org.example;
import java.util.*;

public class ArraysPractice {

    /***
     * this below function shows basics of array means how to create it, call it's value and update it
     */
    public static void arrayBasics(){
        int numbers[] = new int[5];
        Scanner sc = new Scanner(System.in);

        numbers[0] = sc.nextInt();
        numbers[1] = sc.nextInt();
        numbers[2] = sc.nextInt();

        int percentage = (numbers[0]+numbers[1]+numbers[2])/3;

        System.out.println("Physics :"+numbers[0]);
        System.out.println("Maths :"+numbers[1]);
        System.out.println("Chemistry :"+numbers[2]);
        System.out.println("Result : "+percentage + "%");

    }

    /***
     *
     * this below functions is showing that the arrays is always use call by reference means
     * if we are changing or updating the array in other method it will change in parent function also
     */
    public static int[] update(int marks[]){
        for (int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;
        }

        return marks;
    }

    public static void arrayCallByReference (){
        int marks[] = {56,59,99};
        update(marks);

        //to print the array
        for (int i = 0; i<marks.length; i++){
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    /***
     *this below functions are to practice linear search
     * time complexity is O(n)
     */
    public static int linearSearch(int numbers[], int key){
        for (int i=0; i<numbers.length; i++){
            if (key == numbers[i]){
                return i;
            }
        }
        return -1;
    }

    public static void callingLinearSearch(){
        int numbers[] = {2,4,6,8,10,12,14,16};
        int key = 12;
        int result = linearSearch(numbers, key);

        System.out.print(result);
    }

    /***
     *this code will return the largest from an array of integer values
     * time complexity - O(n)
     */
    public static int largestElement(int numbers[]){
        int largest = Integer.MIN_VALUE;

        for (int number : numbers){
            if (largest < number){
                largest = number;
            }
        }

        return largest;
    }

    public static void callingLargestElement(){
        int numbers[] = {23,56,12,45,22,89};

        int largestElement = largestElement(numbers);
        System.out.println(largestElement);
    }

    /***
     * will be understanding the binary search,
     * pre-requisite is that the array should be sorted, increasing or decreasing order
     * time complexity - O(log n) which is far way better than linear search
     */

    public static int binarySearch(int numbers[], int key){
        int start = 0, end = numbers.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // comparison
            if (numbers[mid] == key) {
                return mid;
            }
            //right side check
            else if (numbers[mid] < key) {
                start = mid+1;
            }
            //left side check
            else if (numbers[mid] > key) {
                end = mid -1;
            }
        }
        return -1;
    }

    public static void callingBinarySearch(){
        int numbers[] = {2,4,6,8,10,12,14,16};
        int key = 12;
        int result = binarySearch(numbers, key);

        System.out.print(result);
    }

    /***
     * below is the exercise where we are reversing an array with the efficient manner
     * time complexity is O(n)
     */

    public static int[] reverseArray(int numbers[]){
        int start = 0;
        int last = numbers.length-1;

        while (start < last){
            int temp = numbers[start];
            numbers[start] = numbers[last];
            numbers[last] = temp;

            start++;
            last--;
        }
        return numbers;
    }

    public static void callingReverseArray(){
        int numbers[] = {23,5,76,9,12,55,88,33};
        reverseArray(numbers);
        for (int number: numbers){
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /***
     * below question is to find out the total possible pairs in the array
     * time complexity is O(n2) because as we have 2 nested loops in the solution
     */

    public static void printPairs(int numbers[]){
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                System.out.print(String.format("(%d,%d)",numbers[i],numbers[j]));
            }
            System.out.println();
        }
    }
    public static void callingPrintPairs(){
        int numbers[] = {23,13,14,15,6};
        printPairs(numbers);
    }

    /***
     * here we have to print subArrays from the given array
     * time complexity here is O(n3) which is one of the worst time complexity
     */

    public static void printSubArrays(int numbers[]){
        int totalSubArrays = 0;
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                int end = j;
                for (int start = i; start<=end; start++){
                    System.out.print(numbers[start] + " ");
                }
                totalSubArrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total number of sub arrays are : "+totalSubArrays);
    }

    public static void callingPrintSubArrays(){
        int numbers[] = {12,13,15,16,18,19};
        printSubArrays(numbers);
    }

    /***
     * below is the problem where we have to find the maximum sum of the sub arrays in an array
     * time complexity for the calculation of maximum sum of the sub array is O(n3) which is worst,
     * and we can improve it but using different methods....
     * "Brute Force"
     */

    public static int maxSumOfSubArray(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                int currSum = 0;
                for (int k=i; k<=j; k++){
                    currSum += numbers[k];
                }
                if (maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void callingMaxSumOfSubArray(){
        int numbers[] = {12,13,15,16,18,19};
        int numbers1[] = {-2,-3,4,-1,-2,1,5,-3};
        int maxValue = maxSumOfSubArray(numbers);
        int maxValue1 = maxSumOfSubArray(numbers1);
        System.out.println(maxValue);
        System.out.println(maxValue1);
    }

    /***
     * This is a bit improvised way to solve and find the maximum sum of the sub array
     * this method is called "Prefix Sum Approach"
     * Time Complexity for this is O(n2) i.e optimized solution but we have more optimized solution than this
     * which is kadane's algorithm
     */

    public static int sumOfSubArrayByPrefixSumApproach(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int prefixArray[] = new int[numbers.length];

        // Calculating prefix array
        prefixArray[0] = numbers[0];
        for (int i=1; i<numbers.length; i++){
                prefixArray[i] = numbers[i] + prefixArray[i - 1];
        }

        for (int i =0; i<numbers.length; i++){
            int start = i;
            for (int j=i; j<numbers.length; j++){
                int end = j;

                int currSum = start==0 ? prefixArray[end] : prefixArray[end] - prefixArray[start-1];

                if (maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void callingSumOfSubArrayByPrefixSumApproach(){
        int numbers[] = {12,13,15,16,18,19};
        int numbers1[] = {-2,-3,4,-1,-2,1,5,-3};
        int maxSum = sumOfSubArrayByPrefixSumApproach(numbers);
        int maxSum1 = sumOfSubArrayByPrefixSumApproach(numbers1);
        System.out.println(maxSum);
        System.out.println(maxSum1);
    }

    /***
     * This below problem is same to find the max sum of a sub array from the given array
     * with kadane's algorithms which is the most optimized solution for the problem
     * kadane's : when we are adding a -ve number and a +ve, and it gives -ve result so we can take 0 as the sum
     * ignoring the negative value...
     *
     * TimeComplexity is O(n)
     */

    public static int kadanes(int numbers[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        boolean havePositive = false;
        for (int i=0; i<numbers.length; i++){
            cs = numbers[i] + cs;
            if (cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
            if (numbers[i] > 0){
                havePositive = true;
            }
        }
        /***
         * here i want to elaborate a case where there is no positive integer in that case
         * maximum sum should be a negative number only but here it will return 0
         * so to handle that case writing a special case below
         */
        if (ms == 0 && !havePositive) {
            ms = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                ms = Math.max(ms,numbers[i]);
            }
        }
        return ms;
    }

    public static void callingKadanes(){
        int numbers[] = {12,13,15,16,18,19};
        int numbers1[] = {-2,-3,4,-1,-2,1,5,-3};
        int numbers2[] = {-2,-3,-1,-2,-3};
        int maxSum = kadanes(numbers);
        int maxSum1 = kadanes(numbers1);
        int maxSum2 = kadanes(numbers2);
        System.out.println(maxSum);
        System.out.println(maxSum1);
        System.out.println(maxSum2);
    }

    /***
     * Trapping Rain Water :
     * Given a non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining
     * arrays consists of the height of each bar
     *
     * height = [4,2,0,6,3,2,5]
     * we will use and learn the concept of Auxiliary Arrays or helping arrays
     * here we created 2 auxiliary or helping arrays : "left_max","right_max"
     * time complexity is O[n]
     */

    public static int rainWaterTrap(int heights[]){
       int leftMax[] = new int[heights.length];
       int rightMax[] = new int[heights.length];
       int totalWaterTrap = 0;

       //getting all left max
        for (int i=0; i<heights.length; i++){
            if (i==0){
                leftMax[i] = heights[i];
            } else if (i != 0){
                leftMax[i] = Math.max(heights[i], leftMax[i-1]);
            }
        }

        //getting all right max
        for (int i = heights.length-1; i >= 0; i--){
            if ( i == heights.length-1){
                rightMax[i] = heights[i];
            } else if (i != heights.length-1){
                rightMax[i] = Math.max(heights[i], rightMax[i+1]);
            }
        }

        //calculating water trap
        for (int i=0; i<heights.length; i++){
            int water_trap = Math.min(leftMax[i],rightMax[i]) - heights[i];
            if (water_trap > 0){
                totalWaterTrap += water_trap;
            }
        }

        return totalWaterTrap;
    }

    public static void callingRainWaterTrap(){
        int heights[] = {4,2,0,6,3,2,5};
        int totalWaterTrap = rainWaterTrap(heights);
        System.out.println(totalWaterTrap);
    }

    /***
     * Buy & Sell Stocks
     * you are given an array prices where prices[i] is the price of a given stock on the
     * ith day. you want to maximize the profit by choosing a single day yo buy one stock
     * and choosing the different day in the future to sell the stock.
     * prices = [7,1,5,3,6,4]
     */

    public static int buyAndSellStocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++){
            if (buyPrice < prices[i]){
                maxProfit = prices[i]-buyPrice > maxProfit ? prices[i]-buyPrice : maxProfit;
            } else if(buyPrice > prices[i]){
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void callingBuyAndSellStocks(){
        int prices[] = {7,1,5,3,6,4};
        int maxProfit = buyAndSellStocks(prices);
        System.out.println(maxProfit);
    }

}
