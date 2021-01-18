package basesort;

import common.Constants;

import java.util.Scanner;

import static java.lang.Integer.*;

/**
 * @author: taotao
 * @date: 2019/10/18 14:04
 * @description: Maximum Profit 利润最大话
 * <p>
 * ALDS 1_1_D
 * <p>
 * 第一行输入整数n,接下来输入n行，分别是 Rt(t = 1,2,...,n-1)
 * 在单独行输出最大差值
 */
public class Max {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //System.out.println(n);
        Integer size = Constants.MAX_ARRAY_SIZE;
        int[] R = new int[size];
        for (int i = 0; i < n; i++) {
            R[i] = scanner.nextInt();
        }
        System.out.println(findMaxProfit(n,R));
    }

    /**
     * 最大利润查找方法
     *
     * @param n
     * @param array
     * @return
     */
    private static Integer findMaxProfit(int n, int[] array) {
        int minv = array[0];
        int maxv = MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxv = max(maxv, array[i] - minv);
            minv = min(minv,array[i]);
        }
        return maxv;
    }
}
