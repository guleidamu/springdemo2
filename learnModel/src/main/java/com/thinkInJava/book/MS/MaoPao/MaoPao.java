package com.thinkInJava.book.MS.MaoPao;

public class MaoPao {

    public static void main(String[] args){
        int [] nums = {1,5,8,2,3,9,4,9,85,88,89};
        MaoPao maoPao = new MaoPao();
        final int[] nums1 = maoPao.bubbleSort1(nums);
        System.out.println("\n bubbleSort1:第一次数据");
        for(int k:nums1){
            System.out.print(k + ",");
        }
        final int[] nums2 = maoPao.bubbleSort2(nums);
        int[] nums3 = maoPao.bubbleSort3(nums);
        System.out.println("\n bubbleSort1:第二次数据");
        for(int k:nums1){
            System.out.print(k + ",");
        }
        System.out.println("\n bubbleSort2:");
        System.out.println();
        for(int k:nums2){
            System.out.print(k + ",");
        }
        System.out.println("\n bubbleSort3:");
        for(int k:nums3){
            System.out.print(k + ",");
        }
    }

    private  int[] bubbleSort1(int[] a) {
        int temp = 0;
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    // change
                    temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }


    private  int[] bubbleSort2(int[] nums) {
        int[] numbers = {1,5,8,2,3,9,4,9,85,88,89};
        for(int i = 0; i < numbers.length - 1; i++){
            for (int j = 0; j< i; j++){
                if(numbers[i] < numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }


    private  int[] bubbleSort3(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = 0; j< nums.length - 1 -i; j++){
                if(nums[i] < nums[i+1]){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
//                if(nums[j] > nums[j+1]){
//                    int temp = nums[j+1];
//                    nums[j+1] = nums[j];
//                    nums[j] = temp;
//                }
            }
        }
        return nums;
    }


}
