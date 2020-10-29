package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.Corp;
import com.datasupermacy.recruit_cat.entity.User;
import com.datasupermacy.recruit_cat.service.CorpService;
import com.datasupermacy.recruit_cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/user","/corp"})
public class LoginApi {
    @Autowired
    private UserService userService;
    @Autowired
    private CorpService corpService;



}
