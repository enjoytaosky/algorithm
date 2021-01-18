package basesort;

import common.DataUtil;

import java.util.Scanner;

/**
 * @author: taotao
 * @date: 2019/10/18 15:53
 * @description: 冒泡排序算法
 * 1.假设第一个是有序的
 * 2.重复下面操作
 * 1.在无序的部分，比较相邻的两个原素，小的放前面
 * 2.如果都有序了就不用重复
 */
public class BubbleSort {
    public static void main(String[] args) {
        int N, i, j;
        int[] array = new int[100];
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int k = 0; k < N; k++) {
            array[k] = scanner.nextInt();
        }
        DataUtil.traceArray(array, N);
        bubbleSort(array, N);
        DataUtil.traceArray(array, N);
    }


    /**
     * 冒泡排序
     *
     * @param array
     * @param length
     */
    private static int bubbleSort(int[] array, int length) {
        boolean tag = true;
        int sawp = 0;
        for (int i = 0; tag; i++) {
            tag = false;
            for (int j = length - 1; j >= i + 1; j--) {
                if (array[j] < array[j - 1]) {
                    DataUtil.swap(array, j, j - 1);
                    tag = true;
                    sawp++;
                }
            }
        }
        return sawp;
    }
}

