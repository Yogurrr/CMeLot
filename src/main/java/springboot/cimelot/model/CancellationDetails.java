package springboot.cimelot.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cancellationdetails")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CancellationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnno;

    private String userid;
    private LocalDateTime cancellationDate;
    private String title;
    private String cinemaType;
    private String region;
    private String viewingDay;
    private int totalPrice;

}
