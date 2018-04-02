package com.epam.rd.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardsList {

    private Long id;
    private String name;
    private List<Card> cards;

    public CardsList(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addCard(Card card) {
        if (Objects.isNull(this.cards)) {
            this.cards = new ArrayList<>();
        }

        this.cards.add(card);
    }
}
