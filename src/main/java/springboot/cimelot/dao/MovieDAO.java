package springboot.cimelot.dao;

import springboot.cimelot.model.BookingDetails;
import springboot.cimelot.model.Movie;
import springboot.cimelot.model.MovieStillcut;
import springboot.cimelot.model.Review;

import java.util.List;
import java.util.Map;

public interface MovieDAO {


    Map<String, Object> selectTop5Movie();

    Map<String, Object> selectAllMovie();

    Map<String, Object> selectCurrentMovie();

    Map<String, Object> selectSoonMovie();

    Movie selectOneMovie(int mvno);

    int insertReview(Review reviewContent);

    List<Review> selectOneReview(int mvno);

    void updateReview(String revisedReviewContent, int rvno, Double star);

    void deleteReview(int rvno);

    Map<String, Object> selectScreeningSchedule();

    List<MovieStillcut> selectOneStillcut(int mvno);

    int insertBooking(BookingDetails bk);
}
