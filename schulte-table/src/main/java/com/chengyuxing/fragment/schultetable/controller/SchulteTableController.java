package com.chengyuxing.fragment.schultetable.controller;

import com.chengyuxing.fragment.schultetable.service.ISchulteTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/3/15
 * Time: 下午5:30
 * Desc:
 */
@Controller
public class SchulteTableController {

    @Autowired
    private ISchulteTableService iSchulteTableService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "SchulteTableController";
    }

    @ResponseBody
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public String random(){
        int[] ints = iSchulteTableService.random25Ints();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < ints.length; i++){
            sb.append(ints[i]).append(" ");
        }
        return sb.toString();
    }
}
