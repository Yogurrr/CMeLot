package springboot.cimelot.repository;

import springboot.cimelot.model.Movie;
// import com.team.thebox.model.MovieStillcut;
// import com.team.thebox.model.MovieView;
// import com.team.thebox.model.Movielocation;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
// import java.util.Map;
// import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop5ByOrderByReservationRateDesc();

    List<Movie> findAllByOrderByReservationRateDesc();

    @Query(value = "SELECT * FROM movie WHERE opening_day <= CURDATE() ORDER BY reservation_rate DESC", nativeQuery = true)
    List<Movie> findCurrentMovie();

    @Query(value = "SELECT * FROM movie WHERE opening_day > CURDATE() ORDER BY reservation_rate DESC", nativeQuery = true)
    List<Movie> findSoonMovie();


//    @Query("SELECT m.movtitle FROM Movie m WHERE m.movno = :movno")
//    List<String> findMovTitleByMovno(@Param("movno") long movno);

    // Movie findMovTitleByMovno(Long movno);



//    @Query("SELECT m.movno, m.movtitle, m.movactor, m.movgrade, m.movreleasedate, mp.url, AVG(r.star) AS avg_star " +
//        "FROM Movie m " +
//        "JOIN MovieReply r ON m.movno = r.movno " +
//        "LEFT JOIN MoviePoster mp ON m.movno = mp.movie.movno " +
//        "GROUP BY m.movno, m.movtitle, m.movactor, m.movgrade, m.movreleasedate, mp.url " +
//        "ORDER BY avg_star DESC")
    // @Query("SELECT m.movno, m.movtitle, m.movactor, m.movgrade, m.movreleasedate,m.movmainposter, m.tsales, AVG(r.star) AS avg_star " +
    //         "FROM Movie m JOIN MovieReply r ON m.movno = r.movno " +
    //         "GROUP BY m.movno, m.movtitle, m.movactor, m.movgrade, m.movreleasedate, m.movmainposter, m.tsales " +
    //         "ORDER BY avg_star DESC")
    // List<Object[]> findMoviesOrderByAvgStarDesc();


    // @Query("from Movie order by tsales desc")
    // List<Movie> findAllByOrderByTsalesDesc();

    // @Query("from Movie order by movreleasedate desc")
    // List<Movie> findAllOrderBYMovreleasedateDesc();

    // Optional<Movie> findByMovno(Long movno);

    // Movie getMovieByMovno(Long movno);

    // MovieStillcut getMovieStillcutByMovno(Long movno);
    // @Modifying
    // @Query("UPDATE Movie m SET m.movgenre = :movgenre, m.movtitle = :movtitle, m.movdirector = :movdirector, m.movactor = :movactor, m.movreleasedate = :movreleasedate, m.movcountry = :movcountry, m.movgrade = :movgrade, m.movruntime = :movruntime, m.movdetail = :movdetail, m.movmainposter = :movmainposter, m.videourl = :videourl WHERE m.movno = :movno")
    // void updateMovie(
    //         @Param("movgenre") String movgenre,
    //         @Param("movtitle") String movtitle,
    //         @Param("movdirector") String movdirector,
    //         @Param("movactor") String movactor,
    //         @Param("movreleasedate") String movreleasedate,
    //         @Param("movcountry") String movcountry,
    //         @Param("movgrade") String movgrade,
    //         @Param("movruntime") String movruntime,
    //         @Param("movdetail") String movdetail,
    //         @Param("movmainposter") String movmainposter,
    //         @Param("videourl") String videourl,
    //         @Param("movno") Long movno
    // );

    @Query(value = "select mvno from Movie where title = :mvname")
    Long findMvnoByMvno(@Param("mvname") String mvname);

    @Query(value = "select poster from Movie where title = :title")
    List<Movie> findPosterByTitle(@Param("title") String title);

    @Query(value = "select poster from Movie where title = :title")
    String findMoviePoster(@Param("title") String title);
}
