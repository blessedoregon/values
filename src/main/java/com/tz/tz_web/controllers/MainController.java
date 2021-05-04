package com.tz.tz_web.controllers;

import com.tz.tz_web.Models.player;
import com.tz.tz_web.repo.player_repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tz.tz_web.Parser;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private player_repository player_repository;
    @GetMapping("/")
    public String main(Model model)
    {
        Parser parser=new Parser();
        Iterable<player> player= player_repository.findAll();
        model.addAttribute("title", "Трансферная стоимость");
        model.addAttribute("parse",parser);
        model.addAttribute("player",player);
        return "main";
    }
    @RequestMapping("/bd")
    public String bd(Model model, @Param("keyword") String keyword)/*по request включаем param keyword*/
    {
        long starttime=System.currentTimeMillis();
        Iterable<player> player= player_repository.search(keyword);/*search создан в репозитории*/
        logger.info(keyword);
        model.addAttribute("player",player);
        System.out.println("time:".concat(Long.toString(System.currentTimeMillis()-starttime)).concat("ms"));
        return "main";
    }

}
