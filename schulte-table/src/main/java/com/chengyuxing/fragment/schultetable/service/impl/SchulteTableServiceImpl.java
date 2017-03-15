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
    public int[] random25Ints() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 25; ++i) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] result = new int[25];
        for (int i = 0; i < 25; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
