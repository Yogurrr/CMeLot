package springboot.cimelot.dao;

import springboot.cimelot.model.Member;

public interface MemberDAO {
    int selectLogin(Member m);
}
