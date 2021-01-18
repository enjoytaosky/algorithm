package basesort;

import common.DataUtil;

import java.util.Scanner;

/**
 * @author: taotao
 * @date: 2019/10/18 15:18
 * @description:插入排序 1.将头部元素视作已经排序的
 * 2.重复下面操作：
 * 1.将未排序的原素头部存入 V中;
 * 2.从后往前将已经排序的部分和V进行比较，比V大的就不断往后移动一个单位；
 * 3.将V放入空位；
 * (N*N),处理相对有序的数组就有优势了，很稳定的算
 */
public class InsertSort {

    public static void main(String[] args) {
        int N, i, j;
        int[] array = new int[100];
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int k = 0; k < N; k++) {
            array[k] = scanner.nextInt();
        }
        DataUtil.traceArray(array, N);
        insertSort(array, N);
    }


    /**
     * 插入排序
     *
     * @param array
     * @param N
     */
    private static void insertSort(int[] array, int N) {
        int v, j;
        for (int i = 1; i < N; i++) {
            v = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > v) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = v;
            DataUtil.traceArray(array, N);
        }
    }

}
