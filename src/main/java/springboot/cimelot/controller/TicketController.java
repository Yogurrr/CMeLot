package springboot.cimelot.controller;

import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import springboot.cimelot.model.BookingDetails;
import springboot.cimelot.model.Movie;
import springboot.cimelot.repository.MovieRepository;
import springboot.cimelot.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired private MovieService mvsrv;
    private IamportClient api;

    @GetMapping("/booking")
    public ModelAndView booking(){
        ModelAndView mv = new ModelAndView();

        Map<String, Object> schedules = mvsrv.readScreeningSchedule();
        Map<String, Object> posters = mvsrv.readAllMovie();
        
        mv.addObject("schList", schedules.get("schList"));
        mv.addObject("filmList", posters.get("filmList"));
        mv.setViewName("ticket/booking");

        return mv;
    }

    @PostMapping("/booking")
    public String booking(BookingDetails bk){
        String viewPage = "error";

        if (mvsrv.newBooking(bk))
            viewPage = "redirect:/mypage/myticket?userid=" + bk.getUserid();

        return viewPage;
    }

    public TicketController() {
        this.api = new IamportClient("4087057775187445","tJ0vxi9jtc3tU2jo6CMjzzgGQtW4xvqL1S65CIOYgMA525DWr5AJPl3Y7vCZEHKF1ecynsB5Bc0hExnB");
    }

    @ResponseBody
    @RequestMapping(value="/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(
            Model model
            , Locale locale
            , HttpSession session
            , @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException
    {
        return api.paymentByImpUid(imp_uid);
    }





    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();

        Map<String, Object> posters = mvsrv.readAllMovie();

        mv.addObject("filmList", posters.get("filmList"));
        mv.setViewName("ticket/test");

        return mv;
    }
}
