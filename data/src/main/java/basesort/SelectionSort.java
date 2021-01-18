package basesort;

import common.DataUtil;

import java.util.Scanner;

/**
 * @author: taotao
 * @date: 2019/10/18 18:00
 * @description: 选择排序
 * <p>
 * 前i个作为已经排序部分
 * 重复下面操作；
 * 1.找出未排序部分最小值的位置minj
 * 2.将minj位置的原素和未排序部分的开始位置的原素进行交换
 */
public class SelectionSort {

    public static void main(String[] args) {
        int N, i, j;
        int[] array = new int[100];
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int k = 0; k < N; k++) {
            array[k] = scanner.nextInt();
        }
        DataUtil.traceArray(array, N);
        selectionSort(array, N);
        DataUtil.traceArray(array, N);
    }


    /**
     * 选择排序
     *
     * @param array
     * @param length
     */
    private static void selectionSort(int[] array, int length) {

        for (int i = 0; i < length - 1; i++) {
            int minj = i;
            for (int j = i; j < length; j++) {
                if (array[j] < array[minj]) {
                    minj = j;
                }
            }
            DataUtil.swap(array, i, minj);
        }
    }
}
