package com.tz.tz_web.repo;

import com.tz.tz_web.Models.player;
import org.springframework.stereotype.Service;

@Service
public interface Player_service

{
    public void save(player pars);
    public boolean isExist(String fly_t);
    public Iterable<player> listAll(String keyword);

}