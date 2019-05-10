package com.finapp.gramfin.finapp.feature.question_viewpager.model;

import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;

import java.util.ArrayList;

public class ModelQuestion {

    private int chapter_id;
    private String chapterName;
    private String topicName;
    private int id;
    private int userChoice;
    private String caption;
    private ArrayList<AnswerRecordRestModel> answers;

    public ModelQuestion(int chapter_id, int id, String caption, ArrayList<AnswerRecordRestModel> answers) {
        this.chapter_id = chapter_id;
        this.id = id;
        this.caption = caption;
        this.answers = answers;

        setUserChoice(-1);
    }

    public int getChapterId() {
        return chapter_id;
    }
    public int getId() {
        return id;
    }
    public int getUserChoice() { return userChoice; }

    public String getCaption() { return caption; }
    public String getChapterName() { return chapterName; }
    public String getTopicName() { return topicName; }

    public ArrayList<AnswerRecordRestModel> getAnswers() {
        return answers;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
