package springboot.cimelot.repository;

import springboot.cimelot.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingdetailsRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findAllByUserid(String userid);

    // @Query("select poster from BookingDetails where userid = :userid order by bkno")
    // Map<String, Object> findPoster(@Param("userid") String userid);

    BookingDetails findAllByBkno(int bkno);
}