package springboot.cimelot.repository;

import springboot.cimelot.model.CancellationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancellationdetailsRepository extends JpaRepository<CancellationDetails, Long> {
    List<CancellationDetails> findAllByUseridOrderByCancellationDate(String userid);
}
