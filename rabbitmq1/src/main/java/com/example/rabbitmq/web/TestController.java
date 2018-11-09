package com.example.rabbitmq.web;

import com.example.rabbitmq.common.vo.JsonResult;
import com.example.rabbitmq.config.one2one.One2OneSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private One2OneSender one2oneSender;

    @RequestMapping(value = "/one2one", method = RequestMethod.GET)
    public String testOne2One(String name){
        one2oneSender.send("吴亦凡 skr...");
        String msg = "点对点发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

}
