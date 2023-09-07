package springboot.cimelot.repository;

import springboot.cimelot.model.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMvnoOrderByReviewRegdateAsc(long mvno);
}
