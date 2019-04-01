package com.finapp.gramfin.finapp.api.question_model.data_reqord;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerRecordRestModel {
    @SerializedName("id") @Expose public int id;
    @SerializedName("question_id") @Expose public int question_id;
    @SerializedName("content") @Expose public String content;
    @SerializedName("is_correct") @Expose public int is_correct;
}
