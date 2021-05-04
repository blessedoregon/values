package com.tz.tz_web.Models;

import com.tz.tz_web.repo.Player_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tz.tz_web.repo.player_repository;

@Service
public class PlayerServiceImp implements Player_service
{
    @Autowired
    player_repository repository;

    @Override
    public Iterable<player> listAll(String keyword)
    {
        if(keyword == "")
        {
            return repository.findAll();

        }
        return repository.search(keyword);
    }
    @Override
    public void save(player player) {
    repository.save(player);
    }

    @Override
    public boolean isExist(String fly_t) {
        return false;
    }


}
