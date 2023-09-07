package springboot.cimelot.dao;

import springboot.cimelot.model.CancellationDetails;
import springboot.cimelot.model.Member;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface MypageDAO {
    Member selectOneMember(String userid);

    Map<String, Object> selectBookingDetails(String userid);

    Map<String, Object> selectCancellationDetails(String userid);

    Map<String, Object> selectTop2(String userid);

    void updateEmail(String userid, String fillEmail);

    void updatePhnum(String userid, String changePhnum);

    void updatePswd(String userid, String newPswd2);

    void deleteMember(String userid);

    void delBkNinsCan(int bkno, CancellationDetails cds);

    void updateProfile(String userid, MultipartFile attach);
}
