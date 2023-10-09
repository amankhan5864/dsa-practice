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
}
