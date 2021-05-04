package com.tz.tz_web.repo;

import com.tz.tz_web.Models.player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface player_repository extends CrudRepository<player,Long>
{
    @Query("SELECT p FROM player p WHERE p.name LIKE %?1% " +
            "or p.count LIKE %?1%" +
            "or p.position LIKE %?1%" +
            "or p.age LIKE %?1%" +
            "or p.price LIKE %?1%")
    public List<player> search(String keyword);
}

