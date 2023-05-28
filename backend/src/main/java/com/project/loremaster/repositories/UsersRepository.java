package com.project.loremaster.repositories;

import com.project.loremaster.entity.UsersEntity;
import com.project.loremaster.models.LeaderRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    @Query("select u from UsersEntity u where u.email = ?1")
    Optional<UsersEntity> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update UsersEntity u set u.runeterraHighscore = ?2 where u.username = ?1 and (u.runeterraHighscore < ?2 or u.runeterraHighscore = null)")
    void setRuneterraHighscore(String username, int score);

    @Modifying
    @Transactional
    @Query("update UsersEntity u set u.demaciaHighscore = ?2 where u.username = ?1 and (u.demaciaHighscore < ?2 or u.demaciaHighscore = null)")
    void setDemaciaHighscore(String username, int score);

    @Modifying
    @Transactional
    @Query("update UsersEntity u set u.noxusHighscore = ?2 where u.username = ?1 and (u.noxusHighscore < ?2 or u.noxusHighscore = null)")
    void setNoxusHighscore(String username, int score);

    @Query("select u from UsersEntity u where u.runeterraHighscore is not null order by u.runeterraHighscore desc")
    List<UsersEntity> getAllLeaders();
}
