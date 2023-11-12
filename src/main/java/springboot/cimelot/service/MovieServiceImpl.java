package springboot.cimelot.service;

import springboot.cimelot.dao.MovieDAO;
import springboot.cimelot.model.BookingDetails;
import springboot.cimelot.model.Movie;
import springboot.cimelot.model.MovieStillcut;
import springboot.cimelot.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mvsrv")
public class MovieServiceImpl implements MovieService {

    @Autowired private MovieDAO mvdao;

    @Override
    public Map<String, Object> readTop5Movie() {
        return mvdao.selectTop5Movie();
    }

    @Override
    public Map<String, Object> readAllMovie() {
        return mvdao.selectAllMovie();
    }

    @Override
    public Map<String, Object> readCurrentMovie() {
        return mvdao.selectCurrentMovie();
    }

    @Override
    public Map<String, Object> readSoonMovie() {
        return mvdao.selectSoonMovie();
    }

    @Override
    public Movie readOneMovie(int mvno) {
        return mvdao.selectOneMovie(mvno);
    }

    @Override
    public boolean newReview(Review reviewContent) {
        boolean result = false;

        if (mvdao.insertReview(reviewContent) > 0) result = true;
        return result;
    }

    @Override
    public List<Review> readOneReview(int mvno) {
        return mvdao.selectOneReview(mvno);
    }

    @Override
    public void modifyReview(String revisedReviewContent, int rvno, Double star) {
        mvdao.updateReview(revisedReviewContent, rvno, star);
    }

    @Override
    public void removeReview(int rvno) {
        mvdao.deleteReview(rvno);
    }

    @Override
    public Map<String, Object> readScreeningSchedule() {
        return mvdao.selectScreeningSchedule();
    }

    @Override
    public List<MovieStillcut> readOneStillcut(int mvno) {
        return mvdao.selectOneStillcut(mvno);
    }

    @Override
    public boolean newBooking(BookingDetails bk) {
        boolean result = false;

        if (mvdao.insertBooking(bk) > 0) result = true;
        return result;
    }

    @Override
    public Map<String, Object> readOnePoster() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readOnePoster'");
    }
}
