package springboot.cimelot.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "movie")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mvno;

    private String title;
    private String poster;
    private String rating;
    private double reservationRate;
    private String openingDay;
    private int runningTime;
    private String movieStory;
    private String director;
    private String actors;
    private String genre;
    private String country;
    private String trailer;
}
