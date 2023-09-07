package springboot.cimelot.controller;

import springboot.cimelot.model.Member;
import springboot.cimelot.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired private JoinService jnsrv;

    @GetMapping("/policy")
    public String policy() {

        return "join/policy";
    }

    @GetMapping("/signup")
    public String signup(Model m){
        m.addAttribute("member", new Member());
        
        return "join/signup";
    }

    @GetMapping("/checkUserid")
    @ResponseBody
	public boolean checkUserid( @RequestParam String userid ) {
        boolean result = jnsrv.checkUserid(userid);
        
        return result;
	}

    @PostMapping("/signup")
    public String signupok(@Valid Member member, BindingResult br){
        String viewPage = "redirect:/";

        if (br.hasErrors())
            viewPage = "join/signup";
        else {
            jnsrv.newMember(member);
        }

        return viewPage;
    }

    @GetMapping("/find_id")
    public String find_id() {

        return "join/find_id";
    }

    @GetMapping("/getIdByNameAndPhone")
    @ResponseBody
	public Map<String,Object> getIdByNameAndPhone( @RequestParam String findByName, @RequestParam String findByPhone ) {
		Member rom = jnsrv.readOneMember(findByName, findByPhone);

        Map<String, Object> returnMap = new HashMap<>();

        returnMap.put("userid", rom.getUserid());
        returnMap.put("regdate", rom.getRegdate());
        
        return returnMap;
	}

    @GetMapping("/find_pass")
    public String find_pass() {

        return "join/find_pass";
    }
}
