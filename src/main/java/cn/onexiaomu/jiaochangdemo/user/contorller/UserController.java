package cn.onexiaomu.jiaochangdemo.user.contorller;


import cn.onexiaomu.jiaochangdemo.user.entity.UserEntity;
import cn.onexiaomu.jiaochangdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

  /*  @RequestMapping("/test")
    public String test(){
        return "没问题";
    }*/
    @ResponseBody
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map){
       return userService.getAll(map);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody UserEntity userEntity){
        userService.add(userEntity);
        return  "success";
    }

    @RequestMapping("/go")
    public String goAdd(){
        return  "redirect:/save.html";
    }

    @RequestMapping("/delete")
    public  String delete(Integer id){
        userService.delete(id);
        return "redirect:/index.html";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public UserEntity findById(Integer id){
        return userService.findById(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody UserEntity userEntity){
        userService.update(userEntity);
        return "success";
    }

}
