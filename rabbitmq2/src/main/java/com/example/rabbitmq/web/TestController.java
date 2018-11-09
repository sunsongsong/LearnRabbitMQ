package com.example.rabbitmq.web;

import com.example.rabbitmq.common.vo.JsonResult;
import com.example.rabbitmq.config.beanSender.RabbitUser;
import com.example.rabbitmq.config.beanSender.UserSender;
import com.example.rabbitmq.config.callback.CallBackSender;
import com.example.rabbitmq.config.fanout.FanoutSender;
import com.example.rabbitmq.config.more2more.More2MoreSender1;
import com.example.rabbitmq.config.more2more.More2MoreSender2;
import com.example.rabbitmq.config.one2more.One2MoreSender;
import com.example.rabbitmq.config.one2one.One2OneSender;
import com.example.rabbitmq.config.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private One2OneSender one2oneSender;

    /**
     * 一对一测试 -- 单生产者和单消费者
     * @return
     */
    @RequestMapping(value = "/one2one", method = RequestMethod.GET)
    public String testOne2One(String name){
        one2oneSender.send("吴亦凡 skr...");
        String msg = "点对点发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

    /**
     * 一对多测试 -- 单生产者-多消费者
     * 说明：一个生成者的生产结果被多个消费者消费
     * @return
     */
    @Autowired
    private One2MoreSender one2MoreSender;

    @RequestMapping(value = "/one2more",method = RequestMethod.GET)
    public String one2more() {
        for(int i=0;i<10;i++){
            one2MoreSender.send("吴亦凡 skr..."+ i + " ");
        }
        String msg = "一对多发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

    @Autowired
    private More2MoreSender1 more2MoreSender1;
    @Autowired
    private More2MoreSender2 more2MoreSender2;

    /**
     * 多对多测试 -- 多生产者-多消费者
     * 说明：多个生成者的生产结果被多个消费者消费
     * @return
     */
    @RequestMapping(value = "/more2more",method = RequestMethod.GET)
    public String more2more() {
        for(int i=0;i<10;i++){
            more2MoreSender1.send("send1 吴亦凡 skr... "+ i + " ");
            more2MoreSender2.send("send2 吴亦凡 skr... "+ i + " ");
        }
        String msg = "多对多发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

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

    @Autowired
    private TopicSender topicSender;
    /**
     * topic ExChange示例  主题转发器
     * 说明：消息通过一个特定的路由键发送到所有与绑定键匹配的队列中。
     *      https://blog.csdn.net/a491857321/article/details/50616323
     *      类似与通配符的监听
     *
     *      sender1发送的消息,目的队列是“topic.one”，
     *      sender2发送的消息，目的队列是“topic.two”，
     *      发送过程中使用到了转发器,根据路由键的转发规则进行了队列匹配
     *      队列（topic.one）绑定的路由键是“topic.one” 所以只能接收“topic.one”
     *      队列（topic.two）绑定的路由键是“topic.#” 所以能接收“topic.one”和“topic.two”
     * @return
     */
    @RequestMapping(value = "/topicSender",method = RequestMethod.GET)
    public String topicSender() {
        topicSender.send();
        String msg = "Topic消息发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

    @Autowired
    private FanoutSender fanoutSender;
    /**
     * 广播模式 一个消息发给多个消费者使用
     * 说明：给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息
     * @return
     */
    @RequestMapping(value = "/fanoutSender",method = RequestMethod.GET)
    public String fanoutSender() {
        fanoutSender.send();
        String msg = "Fanout消息发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }

    @Autowired
    private CallBackSender callBackSender;

    /**
     * 带回调的消息发送
     * @return
     */
    @RequestMapping(value = "/callBackSender",method = RequestMethod.GET)
    public String callBackSender() {
        callBackSender.send();
        String msg = "callBackSender消息发送成功,执行结果请看控制台";
        return JsonResult.okResult(msg);
    }


}
