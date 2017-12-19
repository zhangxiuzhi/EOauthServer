package com.esteel.oauth;

import java.math.BigDecimal;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-18
 * Time: 18:51
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal jg = new BigDecimal(5010);
        BigDecimal sl = new BigDecimal(31.51);

        BigDecimal multiply = sl.multiply(jg);
        System.out.println(multiply);

        System.out.println(multiply.setScale(2,BigDecimal.ROUND_HALF_UP));


    }
}
