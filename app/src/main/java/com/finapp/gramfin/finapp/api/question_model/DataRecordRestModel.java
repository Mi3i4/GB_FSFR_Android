package com.finapp.gramfin.finapp.api.question_model;

import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.ChaptersRestModel;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.TopicsRestModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataRecordRestModel {
    @SerializedName("id") @Expose public int id;
    @SerializedName("chapters_id") @Expose public int chapters_id;
    @SerializedName("topics_id") @Expose public int topics_id;
    @SerializedName("content") @Expose public String content;
    @SerializedName("chapters") @Expose public ChaptersRestModel chapters;
    @SerializedName("topics") @Expose public TopicsRestModel topics;
    @SerializedName("answers") @Expose public ArrayList<AnswerRecordRestModel> answers;
}
