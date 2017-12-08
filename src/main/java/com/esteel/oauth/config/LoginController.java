package com.esteel.oauth.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-10-16
 * Time: 17:12;
 */
@Controller
public class LoginController {

    @RequestMapping("/sucess")
    public String login(){
        return "sucess";
    }
}
