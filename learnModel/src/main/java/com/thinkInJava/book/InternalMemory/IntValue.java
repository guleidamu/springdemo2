package com.thinkInJava.book.InternalMemory;

public class IntValue {

    int a = 666;
    int b = a;

    private int plus(int num){
        num = num+1;
        return num;
    }
    public static void main(String [] args){
        IntValue intValue = new IntValue();
        System.out.println("刚开始a的值"+ intValue.a);
        System.out.println("刚开始b的值"+ intValue.b);
        intValue.plus(intValue.a);
        System.out.println("之后a的值"+ intValue.a);
        System.out.println("之后b的值"+ intValue.b);

        int c = 888;
        int d = c;
        int e = intValue.plus(c);
        System.out.println("之后c的值"+ c);
        System.out.println("之后d的值"+ d);
        System.out.println("之后e的值"+ e);


        int [] nums = {1,5,8,2,3,9,4,9,85,88};
        System.out.println();
        System.out.println("遍历nums的值");
        for (int num: nums){
            System.out.print(num + ",");
        }
        int [] nums1 = nums;
        System.out.println();
        System.out.println("遍历nums1的值");
        for (int num: nums1){
            System.out.print(num + ",");
        }
        nums[3] = 666;
        System.out.println();
        System.out.println("遍历nums修改后的值");
        for (int num: nums){
            System.out.print(num + ",");
        }

        System.out.println();
        System.out.println("遍历nums1修改后的值");
        for (int num: nums1){
            System.out.print(num + ",");
        }

//        intValue.bubbleSort6(nums);
//        System.out.println("遍历之后nums的值");
//        for (int num: nums){
//            System.out.print(num + ",");
//        }

//        int [] nums1 = intValue.bubbleSort5(nums);
//        int [] nums2 = intValue.bubbleSort6(nums);
//        System.out.println();
//        System.out.println("遍历nums的值");
//        for (int num: nums1){
//            System.out.print(num + ",");
//        }
//
//        System.out.println();
//        System.out.println("遍历之后nums2的值");
//        for (int num: nums2){
//            System.out.print(num + ",");
//        }
//    }
//
//    private  int[] bubbleSort5(int[] a) {
//        int temp = 0;
//        for (int j = 0; j < a.length - 1; j++) {
//            for (int i = 0; i < a.length - 1 - j; i++) {
//                if (a[i] > a[i + 1]) {
//                    // change
//                    temp = a[i + 1];
//                    a[i + 1] = a[i];
//                    a[i] = temp;
//                }
//            }
//        }
//        return a;
//    }
//
//
//    private  int[] bubbleSort6(int[] nums) {
//        for(int i = 0; i < nums.length - 1; i++){
//            for (int j = 0; j< nums.length - 1 -i; j++){
//                if(nums[i] < nums[i+1]){
//                    int temp = nums[i];
//                    nums[i] = nums[i+1];
//                    nums[i+1] = temp;
//                }
//            }
//        }
//        return nums;
   }




}
