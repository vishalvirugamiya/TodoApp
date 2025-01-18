package com.example.todos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class

Data(

    @SerializedName("_id"       ) var Id        : String,
    @SerializedName("todo"      ) var todo      : String,
    @SerializedName("completed" ) var completed : Boolean


//      @SerializedName("_id"       ) var Id        : String,
//      @SerializedName("todo"      ) var todo      : String,
//      @SerializedName("completed" ) var completed : Boolean,
//      @SerializedName("date"      ) var date      : String

):Serializable
