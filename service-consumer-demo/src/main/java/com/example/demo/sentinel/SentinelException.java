package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
public class SentinelException {

    public static String  handleException(BlockException e) {
        return "sentinel block "+e;
    }

}
