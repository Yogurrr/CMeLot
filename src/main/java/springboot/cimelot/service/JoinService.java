package springboot.cimelot.service;

import springboot.cimelot.model.Member;



public interface JoinService {

    boolean newMember(Member m);

    Member readOneMember(String findByName, String findByPhone);

    boolean checkUserid(String userid);
}
