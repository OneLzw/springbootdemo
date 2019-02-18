package com.example.bootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.bootdemo.bean.Account;
import com.example.bootdemo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {

    Logger logger =  LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAccounts(ModelMap modelMap) {
        logger.info("get list");
        modelMap.addAttribute("accountList",accountService.findAccountList());
        return "/view/account/accountList";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JSONObject updateAccount(@PathVariable("id") int id,
                                    @RequestParam(value = "name", required = true) String name,
                                    @RequestParam(value = "money", required = true) double money) {
        JSONObject json = new JSONObject();
        int t= accountService.update(name,money,id);
        if(t==1) {
            json.put("status" , 0);
            json.put("msg" , -1);
            return json;
        }else {
            json.put("status" , "fail");
            json.put("msg" , "fail");
            return json;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JSONObject delete(@PathVariable(value = "id")int id) {
        int t= accountService.delete(id);
        JSONObject json = new JSONObject();
        if(t==1) {
            json.put("status" , 0);
            json.put("msg" , "success");
            return json;
        }else {
            json.put("status" , -1);
            json.put("msg" , "fail");
            return json;
        }
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        int t= accountService.add(name,money);
        return "redirect:/account/list";
    }
}
