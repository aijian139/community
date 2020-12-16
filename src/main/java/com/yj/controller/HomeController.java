package com.yj.controller;

import com.yj.po.DiscussPost;
import com.yj.po.Page;
import com.yj.service.DiscussPostService;
import com.yj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String getIndexPage(Model model, Page page){

        // 方法调用前，springmvc 会自动实例化Model 和 Page，将Page 注入model
        // 所以，在thymeleaf 中可以直接访问Page 对象中的数据。


        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("index");

        List<DiscussPost> list = discussPostService.findDiscussPost(0, page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (list!=null) {
            list.forEach(discussPost -> {
                Map<String,Object> map = new HashMap<>();
                map.put("post", discussPost);
                map.put("user", userService.findUserById(discussPost.getUserId()));
                discussPosts.add(map);
            });
        }
        model.addAttribute("discussPosts", discussPosts);
        return "index";
    }


}
