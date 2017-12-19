package com.esteel.oauth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2017-12-18
 * Time: 10:27
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/ulogin",method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public String doLogin(){
        return "haha";
    }

}
