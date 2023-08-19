package com.hzbank.sort;

import javafx.beans.binding.When;
import jdk.nashorn.internal.ir.IfNode;
import org.junit.rules.Stopwatch;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description   选择排序方法
 * @Auther: fyd20
 * @Date: 2023/8/15 08:30
 * @Description: SelectSortTest
 * @Version 1.0.0
 */
public class SelectSortTest {

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        // 考虑边界问题
        if (arr == null || arr.length < 2){
            // 不需要排序
            return;
        }
        // 0 ~ n -1
        // 1 ~ n -1
        int N = arr.length;

        // 遍历
        for (int i = 0; i < N; i++) {
            // 找出最小的元素下表
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            // 交换位置
            swap(arr,i,minValueIndex);
        }


    }
    public static void bubbleSort(int[] arr){
        // 考虑边界问题
        if (arr == null || arr.length < 2){
            // 不需要排序
            return;
        }

        // 0 - n - 1
        // 0 - n -2
        for (int end = arr.length - 1; end > 0 ; end--) {
            // 比较前后两个数的大小，并进行交换
            for (int second = 1 ;second < end; second++){
                if (arr[second] < arr[second - 1]){
                    // 交换
                    swap(arr,second,second - 1);
                }

            }
        }
    }
    public static void insertSort1(int[] arr){
        // 考虑边界问题
        if (arr == null || arr.length < 2){
            // 不需要排序
            return;
        }
        // 0 - 1
        // 0 - 2
        // 0 - 3
        for (int i = 1; i < arr.length; i++) {
            int curIndex = i;
            while (curIndex - 1 >= 0 && arr[curIndex] < arr[curIndex - 1]){
                // 交换位置
                swap(arr,curIndex,curIndex - 1);
                // 往左移动
                curIndex--;
            }
        }

    }
    public static void insertSort2(int[] arr){
        // 考虑边界问题
        if (arr == null || arr.length < 2){
            // 不需要排序
            return;
        }
        // 0 - 1
        // 0 - 2
        // 0 - 3
        for (int end = 1; end < arr.length; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr,pre,pre + 1);
            }
        }

    }
    public static void  swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main2(String[] args) {
        int[] arr =   {1,4,2,0,1,3,21};
        printArr(arr);
        insertSort2(arr);
        printArr(arr);
        System.out.println("================");

        int sum = add(arr, 1, 2);
//        System.out.println("累加和为: " + sum);

        System.out.println("------------------");
        double min = Math.min(Math.random(), Math.random());
        System.out.println("min" + min);
        System.out.println("------------");
        // math.random [0,1)
        int times = 100000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            if (Math.random() * 8  < 4){
                count++;
            }
        }
        count = 0;
        double x =  0.36;
        for (int i = 0; i < times; i++) {
            if (xToX3() < x){
                count++;
            }
        }
        System.out.println("概率"+ (double)count / ( double) times);
        System.out.println((double)1 - Math.pow( (double) 1 - x,3));
        System.out.println("================");
        int[] counts = new int[8];
        for (int i = 0; i < times; i++) {
            int num = g();
            counts[num]++;

        }
        for (int i = 0; i < 8; i++) {
            System.out.println("这个数"+ i + "出现了" + counts[i] + "次");
        }
        System.out.println("===========");
        for (int i = 0; i < times; i++) {
            int num = f5();
            counts[num]++;

        }
        for (int i = 0; i < 8; i++) {
            System.out.println("这个数"+ i + "出现了" + counts[i] + "次");
        }
        System.out.println("===========");
        int i = f7();
        count = 0;
        int count2 = 0;
        for (int j = 0; j < times; j++) {
            if (f7() == 1){
                count++;
            }else {
                count2++;
            }
        }
        System.out.println("0次数" + count2);
        System.out.println("1次数" + count);

    }
    public static   double xToX3(){
        return Math.min(Math.random(),Math.min(Math.random(),Math.random()));
    }


    // 3-7之间累加和
    public static int add(int[] arr,int begin, int end){
        if (arr == null || begin > end){
            return -1;
        }
        int sum = 0;
        int[] temp = new int[arr.length];
        for (int i = 1; i < temp.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum+= arr[j];
            }

            temp[i] = sum;
            System.out.println(Arrays.toString(temp));
        }
        if (begin <= 0){
            return temp[end];
        }

        return temp[end] - temp[begin];



    }



    // 0~5上面等概率返回
    public static int f1(){
        return (int)(Math.random() * 5) + 1;
    }

    // 等概率返回0，1
    public static int f2(){
        int ans = 0;
        do {
             ans = f1();
        }while (ans == 3);

        return ans > 3 ? 1 : 0;


    }

    // 0~7等概率
    public static int f3(){
        return (f2() << 2) + (f2() << 1) + f2();
    }
    public static int f4(){
        int ans = 0;
        do {
            ans = f3();
        }while (ans == 7);
            return ans;
    }
    public static int g(){
        return f4() + 1;
    }

    // 1~7等概率
    public static int f5(){
        return (int) (Math.random() * 7) + 1;
    }

    public static int f6(){
        return Math.random() < 0.88 ? 0 : 1;
    }

    public static int f7(){
        int ans = 0;
        do {
            ans = f6();
        }while (ans == f6());
        // 不等则返回
        return ans;
    }

    /**
     * 对数器
     * @return
     */
    public static int[] randomArray(int maxLeg,int maxVal){
        // 长度随机
        int[] newArr = new int[maxLeg];
        for (int i = 0; i < newArr.length; i++) {
            // 值随机
            newArr[i] = (int)(Math.random() * maxVal);
        }
        return newArr;

    }

    /**
     * 判断是否是有序
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr){
        if (arr.length <= 2){
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] < arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main3(String[] args) {
        int maxLeg = 4;
        int maxVal = 1000;
        int[] arr = randomArray(maxLeg, maxVal);
//        insertSort1(arr);
//        if (isSorted(arr)){
//            System.out.println(Arrays.toString(arr));
//            System.out.println("是有序的");
//        }
        System.out.println("==============");
        int[] arr1 = {1,1,1,1,1,1,2,4};
        boolean b = doubleSearch(arr1, 5);
        System.out.println(b);

    }

    public static boolean doubleSearch(int[] arr,int num){
        if (arr == null || arr.length < 2){
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (num > arr[mid]){
                left = mid + 1;
            }else if (num == arr[mid]){
                return true;
            }else{
                right = mid - 1;
            }
        }

        return false;


    }


    // arr有序 找一个数 >= num 最左的数
    public static int findNumNoOtherMore(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int r = 0;
        int l = arr.length - 1;
        int ans = -1;
        int mid = (r + l) / 2;
        while (l <= r){
            if (arr[mid] >= num){
                ans = arr[mid];
                r = mid - 1;
            }else { // arr[mid] < num
                l = mid + 1;
            }
        }

        return ans;

    }

    // 找一个<= num 最右的值
    public static int findRightNoOtherMore(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int r = 0;
        int l = arr.length - 1;
        int ans = -1;
        int mid = (r + l) / 2;
        while (l <= r){
            if (arr[mid] <= num){
                ans = arr[mid];
                r = mid - 1;
            }else { // arr[mid] < num
                l = mid + 1;
            }
        }

        return ans;
    }

    // 二分法查找
    public static void binarySearch(int[] arr){
        if (arr == null || arr.length <= 2){
            return;
        }
        int rightIndex = 0;
        int leftIndex = arr.length - 1;
        int mid = (rightIndex + leftIndex) / 2;
        while (rightIndex < leftIndex){
            // 一直循环
            // 左半部分与mid比较
            if (arr[mid] < arr[rightIndex]){
                swap(arr,mid,rightIndex);
                rightIndex++;
            }
            // 右半部分与mid比较
            if (arr[mid] > arr[leftIndex]){
                swap(arr,mid,rightIndex);
                leftIndex--;
            }


        }


    }



    //////////////////////////////////////////

    // 局部最小
    public static int findMin(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        if (arr.length < 2){
            return 0;
        }
        int N = arr.length;
        if (arr[0] < arr[1]){
            return 0;
        }
        if (arr[N -1]<arr[N - 2]){
            return N - 1;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = (r + l) / 2;
        while (l < r - 1){
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }else {
                if (arr[mid] > arr[mid - 1]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }

        }
        return arr[l] < arr[r] ? l : r;
    }

    // 随机数组，左右不等
    public static int[] generateRandomArray(int maxLength,int maxValue){
        int len = (int) (Math.random() * maxLength);
        int[] arr = new int[len];
        if (len > 0){
            arr[0] = (int) (Math.random() * maxValue);

                for (int i = 1; i < len  ; i++) {
                    do {
                        arr[i] = (int) (Math.random() * maxValue);
                    }while (arr[i] == arr[i - 1]);
                }

        }

        return arr;

    }
    // 检验是否为局部最小
    public static boolean check(int[] arr , int minIndex){
        if (arr == null){
            return false;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftCheck = left < 0 || arr[left] > arr[minIndex];
        boolean rightCheck = right > arr.length - 1 || arr[right] > arr[minIndex];
        return leftCheck && rightCheck;


    }

    // 打印数组
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();

    }

    public static void main(String[] args){
        int maxLen = 9;
        int maxVal = 100;
        int testTimes = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxLen,maxVal);
            int ans = findMin(arr);
            if (!check(arr,ans)){
                System.out.println("失败");
                print(arr);
                System.out.println(ans);
                break;
            }

        }
        System.out.println("测试结束");
    }

}
