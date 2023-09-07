package springboot.cimelot.repository;

import springboot.cimelot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MypageRepository extends JpaRepository<Member, Long> {
    Member findAllByUserid(String userid);
}
