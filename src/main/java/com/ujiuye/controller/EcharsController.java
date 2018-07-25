package com.ujiuye.controller;

import com.ujiuye.bean.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EcharsController {

    @RequestMapping("/bar.action")
    @ResponseBody
    public List<ResultBean> bar(){
    ResultBean rb = new ResultBean();
    rb.setName("A");
    rb.setValue(100);
        ResultBean rb2 = new ResultBean();
        rb2.setName("B");
        rb2.setValue(200);
        ResultBean rb3 = new ResultBean();
        rb3.setName("C");
        rb3.setValue(150);

        List<ResultBean> list = new ArrayList<ResultBean>();
        list.add(rb);
        list.add(rb2);
        list.add(rb3);

        return list;
    }


    @RequestMapping("/pie.action")
    @ResponseBody
    public List<ResultBean> pie(){
        ResultBean bean = new ResultBean();
        bean.setName("一班");
        bean.setValue(50);

        ResultBean bean2 = new ResultBean();
        bean2.setName("二班");
        bean2.setValue(80);

        ResultBean bean3 = new ResultBean();
        bean3.setName("三班");
        bean3.setValue(120);

        ResultBean bean4 = new ResultBean();
        bean4.setName("四班");
        bean4.setValue(100);

        List<ResultBean> list = new ArrayList<>();
        list.add(bean);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);

        return list;
    }
    @RequestMapping("/line.action")
    @ResponseBody
    public List<ResultBean> line(){
        ResultBean bean = new ResultBean();
        bean.setName("A");
        bean.setValue(122);
        ResultBean bean2 = new ResultBean();
        bean2.setName("B");
        bean2.setValue(235);
        ResultBean bean3 = new ResultBean();
        bean3.setName("C");
        bean3.setValue(122);
        ResultBean bean4 = new ResultBean();
        bean4.setName("D");
        bean4.setValue(345);
        List<ResultBean> list = new ArrayList<>();


        return list;

    }
 }
