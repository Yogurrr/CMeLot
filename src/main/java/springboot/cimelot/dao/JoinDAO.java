package springboot.cimelot.dao;

import springboot.cimelot.model.Member;

public interface JoinDAO {

    int insertMember(Member m);

    Member selectOneMember(String findByName, String findByPhone);

    boolean existsUserid(String userid);
}
