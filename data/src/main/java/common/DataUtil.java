package common;

/**
 * @author: taotao
 * @date: 2019/10/18 14:35
 * @description: 数据处理工具
 */
public class DataUtil {

    /**
     * 打印数组
     *
     * @param array
     * @param length
     */
    public static void traceArray(int[] array, int length) {
        int v;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(array[i]);
        }
        System.out.print("\n");
    }

    /**
     * 交换两个数据的位置
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.print("111");
        System.out.print("112");

    }
}
