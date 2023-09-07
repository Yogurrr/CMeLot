package springboot.cimelot.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "screening_schedule")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schno;

    private String title;
    private String screeningDate;
    private String cinemaType;
    private String region;
    private String theater;
    private String startTime;
    private String endTime;
    private String rating;
}
