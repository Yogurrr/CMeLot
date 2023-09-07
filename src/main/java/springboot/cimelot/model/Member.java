package springboot.cimelot.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    // @NotBlank(message = "아이디는 필수항목입니다.")
    // @Length(min=6, max=16, message = "아이디는 최소6자, 최대16자이어야 합니다!!")
    private String userid;

    // @NotBlank(message = "비밀번호는 필수항목입니다.")
    // @Length(min=6, max=16, message = "비밀번호는 최소6자, 최대16자이어야 합니다!!")
    private String passwd;

    // @NotBlank(message = "이름은 필수항목입니다.")
    private String name;

    private String email;

    // @NotBlank(message = "전화번호는 필수항목입니다.")
    private String phone;

    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime regdate;

    private String profilepic;
    private String pictype;



    @Transient
    // @NotBlank(message = "전화번호는 필수항목입니다!!")
    private String tel2;

    @Transient
    // @NotBlank(message = "전화번호는 필수항목입니다!!")

    private String tel3;

    @Transient
    // @NotBlank(message = "이메일 입력하셔야 됩니다. ")
    private String email1;

    @Transient
    // @NotBlank(message = "이메일 입력하셔야 됩니다. ")
    private String email2;

}
