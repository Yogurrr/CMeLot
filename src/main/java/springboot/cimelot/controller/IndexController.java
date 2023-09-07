package springboot.cimelot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import springboot.cimelot.service.MovieService;

@Controller
public class IndexController {

    @Autowired private MovieService mvsrv;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();

        Map<String, Object> top5s = mvsrv.readTop5Movie();

        mv.addObject("top5List", top5s.get("top5List"));

        mv.setViewName("index");

        return mv;
    }
}
