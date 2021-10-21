package com.sg.foundations;

public class SummartiveSums {
        public static void main(String[] args) {
            int[] nums1 = {4, 5, 44, 65, 1, 32, 5};
            int[] nums2 = {4, 5, 44, 65, 1, 32, 5, 4, 5, 44, 65, 1, 32, 5};
            int[] nums3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                    140, 150, 160, 170, 180, 190, 200, -99 };
            int sum1,sum2,sum3;
            sum1 = arrayAdder(nums1);
            System.out.println("#1 Array Sum: " + sum1);
            sum2 = arrayAdder(nums2);
            System.out.println("#2 Array Sum: " + sum2);
            sum3 = arrayAdder(nums3);
            System.out.println("#3 Array Sum: " + sum3);
         }

        public static int arrayAdder(int x[]){
            int sum = 0;
            for( int i : x) {
                sum += i;
            }
            return sum;
        }

}
