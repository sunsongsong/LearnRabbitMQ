package com.example.rabbitmq.web;

import com.example.rabbitmq.common.vo.JsonResult;
import com.example.rabbitmq.config.beanSender.RabbitUser;
import com.example.rabbitmq.config.beanSender.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private UserSender userSender;

    /**
     * 实体测试 -- 实体类传输
     * 说明：springboot完美的支持对象的发送和接收，不需要格外的配置。
     * 实体类（必须实现序列化接口）
     * @return
     */
    @RequestMapping(value = "/userSender",method = RequestMethod.GET)
    public String userSender() {
        RabbitUser user = new RabbitUser();//必须实现序列化接口
        user.setName("好名字");
        user.setPass("好密码");
        userSender.send(user);
        String msg = "实体对象User发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

}
