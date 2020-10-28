package control;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
//    public String handleRequest(Model model) throws Exception {
//        model.addAttribute("message","这是第一个SpringMVC网页");
//        return "index";
//    }
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView model=new ModelAndView("login");
        model.addObject("message","这是第一个SpringMVC网页");
        return model;
    }
    @RequestMapping("/userlogin")
    @ResponseBody//加上这个注解，return 就不会再跳转页面，只是返回数据（json）
    public String userlogin(User user){
        User users = new User();
        user.username="lh";
        user.userpass="123465";
        if (users == null) {
            return "1";
        }
        return "0";
    }
}