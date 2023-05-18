package org.tennisplayers.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tennisplayers.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Component("playerRepository")
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {



}