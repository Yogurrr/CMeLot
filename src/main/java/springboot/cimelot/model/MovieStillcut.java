package springboot.cimelot.model;

import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie_stillcut")
public class MovieStillcut{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stlno;

    @Column
    private Long mvno;

    @Column
    private String imageUrl;
}