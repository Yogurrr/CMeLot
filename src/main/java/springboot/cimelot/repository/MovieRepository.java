package springboot.cimelot.repository;

import springboot.cimelot.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop5ByOrderByReservationRateDesc();

    List<Movie> findAllByOrderByReservationRateDesc();

    @Query(value = "SELECT * FROM movie WHERE opening_day <= CURDATE() ORDER BY reservation_rate DESC", nativeQuery = true)
    List<Movie> findCurrentMovie();

    @Query(value = "SELECT * FROM movie WHERE opening_day > CURDATE() ORDER BY reservation_rate DESC", nativeQuery = true)
    List<Movie> findSoonMovie();

    @Query(value = "select mvno from Movie where title = :mvname")
    Long findMvnoByMvno(@Param("mvname") String mvname);

    @Query(value = "select poster from Movie where title = :title")
    List<Movie> findPosterByTitle(@Param("title") String title);

    @Query(value = "select poster from Movie where title = :title")
    String findMoviePoster(@Param("title") String title);
}
