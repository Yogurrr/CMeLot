package springboot.cimelot.dao;

import springboot.cimelot.model.Member;
import springboot.cimelot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public int selectLogin(Member m) {

        return memberRepository.countByUseridAndPasswd(m.getUserid(), m.getPasswd());
    }
}
