package springboot.cimelot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bookingdetails")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bkno;

    private String bookingNum;
    private String userid;
    private String title;
    private String cinemaType;
    private String region;
    private String theater;
    private int adult;
    private int teen;
    private String seats;
    private String viewingDay;
    private int totalPrice;
    private String paymentDate;
}
