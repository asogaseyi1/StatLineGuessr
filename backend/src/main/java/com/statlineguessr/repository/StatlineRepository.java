package com.statlineguessr.repository;

import com.statlineguessr.model.Statline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatlineRepository extends JpaRepository<Statline, Long> {
    List<Statline> findByPlayer_Id(Long playerId);

    @Query(value = "SELECT * FROM statline ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Statline> findRandom();
}
