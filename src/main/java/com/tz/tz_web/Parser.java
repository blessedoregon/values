package com.tz.tz_web;

import com.tz.tz_web.Models.player;
import com.tz.tz_web.repo.player_repository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;

@Component
public class Parser {

    @Autowired
    private player_repository player_repository;
    private static Document page;
    private static Document get_page(int a) throws IOException //Document-для возвращения html-кода
    {
        String url="https://www.transfermarkt.ru/spieler-statistik/wertvollstespieler/marktwertetop?page="+a; //Трансфермаркт
        Document page=Jsoup.parse(new URL(url),3000);//Сам документ
        return page;
    }
    @Scheduled(fixedDelay = 30000)
    public void transfer_values() throws Exception {
        player_repository.deleteAll();
        System.out.println("[db update]");
        for (int a = 1; a <= 20 ; a++) {
            page = get_page(a);
            Elements table = page.select("table[class = items]");
            Elements tbody = table.select("tbody");
            Element player;
            Elements params;
            for (int i = 0; i < tbody.size() * 3 - 5; i += 3) {
                player = tbody.select("tr").get(i);
                params = player.select("td");
                player player1 = new player();
                player1.setCount(params.get(0).text());
                player1.setImgP(params.get(1).select("img").attr("src"));
                player1.setName(params.get(3).text());
                player1.setPosition(params.get(4).text());
                player1.setAge(params.get(5).text());
                player1.setImgC(params.get(6).select("img").attr("src"));
                player1.setImgCl(params.get(7).select("img").attr("src"));
                player1.setPrice(params.get(8).text());
                player_repository.save(player1);
            }
        }
    }
}