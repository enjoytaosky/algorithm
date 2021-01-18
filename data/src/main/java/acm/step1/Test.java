package acm.step1;

import common.Constants;

/**
 * @author: taotao
 * @date: 2019/12/16 15:40
 * @description:
 */
public class Test {

    public static void main(String[] args) {

        Integer maxArraySize = Constants.MAX_ARRAY_SIZE;
        int two = getTwo();
        if (maxArraySize == two){
            System.out.println("true");
        }else {
            System.out.println("false");
        }


    }

    public static int getTwo(){
        return 200000;
    }
}
