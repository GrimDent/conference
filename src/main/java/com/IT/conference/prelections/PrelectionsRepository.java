package com.IT.conference.prelections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrelectionsRepository extends JpaRepository<Prelections, Long> {

    @Query(value = "SELECT p.title, u.id, p.start_hour, p.thematic_path FROM users u JOIN register_to_prelection r ON u.id = r.user_id JOIN prelections p ON r.prelection_id = p.id WHERE u.id=?1 ;", nativeQuery = true)
    List<Prelections> selectJoin(Long userId);

    @Query(value = "SELECT COUNT(*) FROM users u JOIN register_to_prelection r ON u.id = r.user_id JOIN prelections p ON r.prelection_id = p.id WHERE p.id=?1 ;", nativeQuery = true)
    Long countUsersInPrelection(Long prelectionId);
}
