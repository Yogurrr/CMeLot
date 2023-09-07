package springboot.cimelot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import springboot.cimelot.model.Review;
import springboot.cimelot.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired private MovieService mvsrv;

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView mv = new ModelAndView();

        Map<String, Object> flms = mvsrv.readAllMovie();

        mv.addObject("filmList", flms.get("filmList"));

        mv.setViewName("movie/all");

        return mv;
    }

    @GetMapping("/current")
    public ModelAndView current() {

        ModelAndView mv = new ModelAndView();

        Map<String, Object> flms = mvsrv.readCurrentMovie();

        mv.addObject("filmList", flms.get("filmList"));

        mv.setViewName("movie/current");

        return mv;
    }

    @GetMapping("/soon")
    public ModelAndView soon() {

        ModelAndView mv = new ModelAndView();

        Map<String, Object> flms = mvsrv.readSoonMovie();

        mv.addObject("filmList", flms.get("filmList"));

        mv.setViewName("movie/soon");

        return mv;
    }

    @GetMapping("/view")
    public ModelAndView view(int mvno) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("film", mvsrv.readOneMovie(mvno));
        mv.addObject("rvList", mvsrv.readOneReview(mvno));
        mv.addObject("stillList", mvsrv.readOneStillcut(mvno));
        mv.setViewName("movie/view");

        return mv;
    }

    @PostMapping("/view")
    public String review(Review reviewContent){
        String viewPage = "error";

        if (mvsrv.newReview(reviewContent))
            viewPage = "redirect:/movie/view?mvno=" + reviewContent.getMvno();

        return viewPage;
    }

    @PostMapping("/modify")
    public String modify(String revisedReviewContent, int rvno, Double star, int mvno){
        String viewPage = "error";

        if (revisedReviewContent != null) {
            mvsrv.modifyReview(revisedReviewContent, rvno, star);
            viewPage = "redirect:/movie/view?mvno=" + mvno;
        }

        return viewPage;
    }

    @GetMapping("/delete")
    public String delete(int rvno, int mvno) {

        mvsrv.removeReview(rvno);

        return "redirect:/movie/view?mvno=" + mvno;
    }
}