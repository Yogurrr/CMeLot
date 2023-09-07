package springboot.cimelot.controller;

import springboot.cimelot.model.Member;
import springboot.cimelot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    private MemberService msrv;

    @PostMapping("/login")
    public String login(Member m, HttpSession sess) {
        String returnPage = "redirect:/loginfail";

        if (msrv.checkLogin(m, sess)) {
            returnPage = "redirect:/";
        }

        return returnPage;
    }

    @GetMapping("/logout")
    public String logout(HttpSession sess) {
        sess.invalidate();

        return "redirect:/";
    }
}
