package springboot.cimelot.repository;

import springboot.cimelot.model.ScreeningSchedule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningScheduleRepository extends JpaRepository<ScreeningSchedule, Long> {

    List<ScreeningSchedule> findAllByOrderByStartTime();
}
