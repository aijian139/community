package com.yj;

import com.yj.mapper.DiscussPostMapper;
import com.yj.mapper.UserMapper;
import com.yj.po.DiscussPost;
import com.yj.po.User;
import com.yj.utils.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;


    @Test
    void contextLoads() {
        int i = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(i);

        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
       list.forEach(discussPost -> {
           System.out.println(discussPost);
       });

    }


    @Test
    public void sendMessage(){
        mailClient.sendMessage("2641349779@qq.com", "Test", "welcome");
    }

    @Test
    public void sendMessageHtml(){
        Context context = new Context();
        context.setVariable("username", "易健");
        String content = templateEngine.process("/mail/demo", context);
        mailClient.sendMessage("2641349779@qq.com", "Test", content);


    }

}
