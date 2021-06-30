package com.example.rank.Casino.Repository;

import com.example.rank.Casino.Entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {
}
