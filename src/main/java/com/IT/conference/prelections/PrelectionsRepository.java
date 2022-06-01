package com.IT.conference.prelections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrelectionsRepository extends JpaRepository<Prelections, Long> {

}
