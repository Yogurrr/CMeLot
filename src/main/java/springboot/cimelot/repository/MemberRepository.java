package springboot.cimelot.repository;

import springboot.cimelot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    int countByUseridAndPasswd(String userid, String passwd);

    Member findAllByNameAndPhone(String findByName, String findByPhone);

    boolean existsByUserid(String userid);
}
