package springboot.cimelot.dao;

import springboot.cimelot.repository.BookingdetailsRepository;
import springboot.cimelot.repository.MovieRepository;
import springboot.cimelot.repository.MovieStillcutRepository;
import springboot.cimelot.repository.ScreeningScheduleRepository;
import springboot.cimelot.repository.ReviewRepository;
import springboot.cimelot.model.BookingDetails;
import springboot.cimelot.model.Movie;
import springboot.cimelot.model.MovieStillcut;
import springboot.cimelot.model.Review;
import springboot.cimelot.model.ScreeningSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository("mvdao")
public class MovieDAOImpl implements MovieDAO {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookingdetailsRepository bookingdetailsRepository;

    @Autowired
    ScreeningScheduleRepository screeningScheduleRepository;

    @Autowired
    MovieStillcutRepository movieStillcutRepository;

    @Override
    public Map<String, Object> selectTop5Movie() {
        List<Movie> top5List = movieRepository.findTop5ByOrderByReservationRateDesc();

        Map<String, Object> top5s = new HashMap<>();
        top5s.put("top5List", top5List);

        return top5s;
    }

    @Override
    public Map<String, Object> selectAllMovie() {

        List<Movie> filmList = movieRepository.findAllByOrderByReservationRateDesc();

        Map<String, Object> flms = new HashMap<>();
        flms.put("filmList", filmList);

        return flms;
    }

    @Override
    public Map<String, Object> selectCurrentMovie() {
        List<Movie> filmList = movieRepository.findCurrentMovie();

        Map<String, Object> flms = new HashMap<>();
        flms.put("filmList", filmList);

        return flms;
    }

    @Override
    public Map<String, Object> selectSoonMovie() {
        List<Movie> filmList = movieRepository.findSoonMovie();

        Map<String, Object> flms = new HashMap<>();
        flms.put("filmList", filmList);

        return flms;
    }

    @Override
    public Movie selectOneMovie(int mvno) {
        return movieRepository.findById((long) mvno).get();
    }

    @Override
    public int insertReview(Review reviewContent) {

        return Math.toIntExact(reviewRepository.save(reviewContent).getMvno());
    }

    @Override
    public List<Review> selectOneReview(int mvno) {

        return reviewRepository.findByMvnoOrderByReviewRegdateAsc((long) mvno);
    }

    @Override
    public void updateReview(String revisedReviewContent, int rvno, Double star) {
        Review rv = reviewRepository.findById((long) rvno).get();

        LocalDateTime now = LocalDateTime.now();

        rv.setReviewContent(revisedReviewContent);
        rv.setReviewRegdate(now);
        rv.setStar(star);
        reviewRepository.save(rv);
    }

    @Override
    public void deleteReview(int rvno) {
        reviewRepository.deleteById((long) rvno);
    }

    @Override
    public Map<String, Object> selectScreeningSchedule() {
        List<ScreeningSchedule> schList = screeningScheduleRepository.findAllByOrderByStartTime();

        Map<String, Object> schedules = new HashMap<>();
        schedules.put("schList", schList);

        return schedules;
    }

    @Override
    public List<MovieStillcut> selectOneStillcut(int mvno) {
        return movieStillcutRepository.findByMvnoOrderByStlno((long) mvno);
    }

    @Override
    public int insertBooking(BookingDetails bk) {
        return Math.toIntExact(bookingdetailsRepository.save(bk).getBkno());
    }
}
