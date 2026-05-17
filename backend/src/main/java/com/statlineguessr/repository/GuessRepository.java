package com.statlineguessr.repository;

import com.statlineguessr.model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long> {
    List<Guess> findByStatline_Id(Long statlineId);
}
