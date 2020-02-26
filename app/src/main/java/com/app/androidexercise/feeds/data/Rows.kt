package com.app.androidexercise.feeds.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "rows")
data class Rows(
    /*@PrimaryKey
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("parent_id")
    val parentId: Int? = null,*/

    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("imageHref")
    val imageHref: String? = null
) {
    override fun toString() = "title = $title description = $description imageHref = $imageHref"
}