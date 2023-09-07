package springboot.cimelot.service;

import springboot.cimelot.dao.JoinDAO;
import springboot.cimelot.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jnsrv")
public class JoinServiceImpl implements JoinService{
    @Autowired private JoinDAO jndao;

    @Override
    public boolean newMember(Member m) {
        boolean result = false;

        if (jndao.insertMember(m) > 0) result = true;

        return result;
    }

    // @Override
    // public int checkUserid(String uid) {
    //     return jndao.selectOneUserid(uid);
    // }

    @Override
    public Member readOneMember(String findByName, String findByPhone) {
        
        return jndao.selectOneMember(findByName, findByPhone);
    }

    @Override
    public boolean checkUserid(String userid) {
        boolean result = false;

        if (jndao.existsUserid(userid)) result = true;

        return result;
    }
}
