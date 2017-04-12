package com.chengyuxing.fragment.schultetable.service.impl;

import com.chengyuxing.fragment.schultetable.service.ISchulteTableService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/3/15
 * Time: 下午8:00
 * Desc:
 */
@Service
public class SchulteTableServiceImpl implements ISchulteTableService {

    private static final int NUM = 10000;

    public int[] randomInts() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= NUM; ++i) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] result = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
