package springboot.cimelot.service;

import springboot.cimelot.model.BookingDetails;
import springboot.cimelot.model.Movie;
import springboot.cimelot.model.MovieStillcut;
import springboot.cimelot.model.Review;

import java.util.List;
import java.util.Map;

public interface MovieService {

    Map<String, Object> readTop5Movie();

    Map<String, Object> readAllMovie();

    Map<String, Object> readCurrentMovie();

    Map<String, Object> readSoonMovie();

    Movie readOneMovie(int mvno);

    boolean newReview(Review reviewContent);

    List<Review> readOneReview(int mvno);

    void modifyReview(String revisedReviewContent, int rvno, Double star);

    void removeReview(int rvno);

    Map<String, Object> readScreeningSchedule();

    List<MovieStillcut> readOneStillcut(int mvno);

    boolean newBooking(BookingDetails bk);
}
