package com.example.project1movie.data.source.remote

import com.example.project1movie.data.model.Genres
import com.example.project1movie.data.model.GenresEntry
import org.json.JSONObject

@Suppress("UNCHECKED_CAST")
class ParseJsonToModel {

    @Throws(Exception::class)
    fun parseJsonToGenres(jsonObject: JSONObject?): Genres? =
            jsonObject?.run {
                Genres(
                        getInt(GenresEntry.ID),
                        getString(GenresEntry.NAME)
                )
            }

}
