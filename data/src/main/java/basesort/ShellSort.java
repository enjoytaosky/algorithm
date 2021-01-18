package basesort;

import common.DataUtil;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: taotao
 * @date: 2019/10/20 13:33
 * @description: 希尔排序
 * <p>
 * 循环 k次的插入排序
 */
public class ShellSort {
    public static Stack<Integer> stack = new Stack<Integer>();


    public static void main(String[] args) {
        int N, i, j;
        int[] array = new int[100];
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int k = 0; k < N; k++) {
            array[k] = scanner.nextInt();
        }
        DataUtil.traceArray(array, N);
        shellShort(array, N);
        DataUtil.traceArray(array, N);

    }

    /**
     * 有步长的插入排序
     *
     * @param array
     * @param length
     * @param g
     */
    private static void insertSort(int[] array, int length, int g) {
        for (int i = g; i < length; i++) {
            int v = array[i];
            int j = i - g;
            while (j >= 0 && array[j] > v) {
                array[j + g] = array[j];
                j = j - g;
            }
            array[j + g] = v;
        }
    }

    private static void shellShort(int array[], int n) {
        for (int h = 1; ; ) {
            if (h > n) {
                break;
            }
            stack.push(h);
            h = 3 * h + 1;
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            Integer push = stack.push(i);
            insertSort(array, n, push);
        }
    }

}
