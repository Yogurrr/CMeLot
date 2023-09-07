package springboot.cimelot.model;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "reviews")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rvno;

    private String reviewContent;
    private String userid;
    private Long mvno;
    private Double star;

    @CreatedDate
    // @Column(insertable = false, updatable = false)
    @Column(insertable = false)
    private LocalDateTime reviewRegdate;
}
