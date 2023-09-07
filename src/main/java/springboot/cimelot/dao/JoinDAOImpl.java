package springboot.cimelot.dao;

import springboot.cimelot.model.Member;
import springboot.cimelot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jndao")
public class JoinDAOImpl implements JoinDAO {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public int insertMember(Member m) {
        int isSaved = -1;

        m = memberRepository.save(m);
        if (m != null) isSaved = Math.toIntExact(m.getMno());

        return isSaved;
    }

    @Override
    public Member selectOneMember(String findByName, String findByPhone) {

        return memberRepository.findAllByNameAndPhone(findByName, findByPhone);
    }

    @Override
    public boolean existsUserid(String userid) {

        return memberRepository.existsByUserid(userid);
    }
}
