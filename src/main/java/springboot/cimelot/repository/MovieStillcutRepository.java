package springboot.cimelot.repository;

import springboot.cimelot.model.MovieStillcut;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStillcutRepository extends JpaRepository<MovieStillcut, Long> {

    List<MovieStillcut> findByMvnoOrderByStlno(long mvno);
}
