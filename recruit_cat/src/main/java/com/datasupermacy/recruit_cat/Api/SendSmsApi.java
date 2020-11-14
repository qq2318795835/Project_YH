package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.service.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

public class SendSmsApi {
    @Autowired
    private SendSms sendSms;

    @GetMapping("/send/{phone}")
    public void code(@PathVariable("phone") String phone){
        HashMap<String,Object> param = new HashMap<>();
        param.put("code","1234");
        sendSms.send(phone,"SMS_205439062",param);
    }
}
