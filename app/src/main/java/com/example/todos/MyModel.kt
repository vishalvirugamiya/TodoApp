package com.example.todos

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MyModel (

    @SerializedName("Status"  ) var Status  : String,
    @SerializedName("Message" ) var Message : String,
    @SerializedName("Data"    ) var Data    : ArrayList<Data> = arrayListOf()

)