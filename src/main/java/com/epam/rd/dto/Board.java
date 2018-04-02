package com.epam.rd.dto;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Long id;
    private String name;
    private List<CardsList> cardsLists;
    private String userLoginOwner;

    public Board(Long id, String name, String userLoginOwner) {
        this.id = id;
        this.name = name;
        this.userLoginOwner = userLoginOwner;
        this.cardsLists = new ArrayList<>();
        this.cardsLists.add(new CardsList("Нужно сделать"));
        this.cardsLists.add(new CardsList("В работе"));
        this.cardsLists.add(new CardsList("Сделано"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CardsList> getCardsLists() {
        return cardsLists;
    }

    public void setCardsLists(List<CardsList> cardsLists) {
        this.cardsLists = cardsLists;
    }

    public String getUserLoginOwner() {
        return userLoginOwner;
    }

    public void setUserLoginOwner(String userLoginOwner) {
        this.userLoginOwner = userLoginOwner;
    }

}
