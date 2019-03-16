package com.finapp.gramfin.finapp.feature.second_screen.model;

public class ModelChapter {

    private String chapter;
    private int numberOfQuetions;
    private int itemIKnow;
    private int itemIdontKnow;

    public ModelChapter(String chapter, int numberOfQuetions, int itemIKnow, int itemIdontKnow) {
        this.chapter = chapter;
        this.numberOfQuetions = numberOfQuetions;
        this.itemIKnow = itemIKnow;
        this.itemIdontKnow = itemIdontKnow;
    }

    public String getChapter() {
        return chapter;
    }

    public int getNumberOfQuetions() {
        return numberOfQuetions;
    }

    public int getItemIKnow() {
        return itemIKnow;
    }

    public int getItemIdontKnow() {
        return itemIdontKnow;
    }
}
