package com.example.rabbitmq.web;

import com.example.rabbitmq.common.vo.JsonResult;
import com.example.rabbitmq.config.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    @Autowired
    MsgProducer msgProducer;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String userSender() {
        for(int i=0;i<5000;i++){
            msgProducer.send("ABCDEFG " + i);
        }
        return JsonResult.okResult("成功");
    }

}
