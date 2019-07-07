package com.finapp.gramfin.finapp.api.question_model.data_reqord;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopicsRestModel {
    @SerializedName("id") @Expose public int id;
    @SerializedName("chapters_id") @Expose public int chapters_id;
    @SerializedName("name") @Expose public String name;
}
