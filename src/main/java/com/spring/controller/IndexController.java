package com.spring.controller;

import com.spring.server.BlackfinComms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.irisys.Blackfin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 15-5-28.
 */
@Controller
public class IndexController {
    private final String _pagePath = "index.ftl";

    @RequestMapping("num_index")
    public String index(Model model) {
        try {
            Blackfin blackfin = BlackfinComms.blackfin;
            if (blackfin != null) {
                Blackfin.Count count = blackfin.GetCurrentCount();
//                Calendar start = Calendar.getInstance();
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                Date date = format.parse("2015-12-17 00:00:00");
//                start.setTime(date);
//                Calendar end = Calendar.getInstance();
//                Date date2 = format.parse("2015-12-18 00:00:00");
//                end.setTime(date2);
//                List<Blackfin.Count> counts = blackfin.GetCounts(start, end);
                model.addAttribute("count1", count.countLines.get(0).toString());
                model.addAttribute("count2", count.countLines.get(1).toString());
                int count1 = Integer.parseInt(count.countLines.get(1).toString());
                int count0 = Integer.parseInt(count.countLines.get(0).toString());
                model.addAttribute("count3", count0 - count1);
                model.addAttribute("logs",BlackfinComms.lqueue);
            } else {
                model.addAttribute("count1", 0);
                model.addAttribute("count2", 0);
                model.addAttribute("count3", 0);
                model.addAttribute("logs",new ArrayList<String>());
                model.addAttribute("mess", "正在连接设备，请等待...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("_pagePath", _pagePath);
        return "layout";
    }

}
