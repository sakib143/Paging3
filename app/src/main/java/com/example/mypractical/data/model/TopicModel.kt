package com.example.mypractical.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class TopicModel(
    @Expose
    @SerializedName("data") val `data`: Data = Data(),
    @Expose
    @SerializedName("message") val message: String = "",
    @Expose
    @SerializedName("status") val status: Boolean = false
) {
    @Keep
    data class Data(
        @Expose
        @SerializedName("topics") val topics: List<Topic> = listOf()
    ) {
        @Keep
        data class Topic(
            @Expose
            @SerializedName("topicicon") val topicicon: String = "",
            @Expose
            @SerializedName("topicid") val topicid: String = "",
            @Expose
            @SerializedName("topicname") val topicname: String = ""
        )
    }
}