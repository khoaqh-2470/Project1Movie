package com.example.project1movie.data.source.remote

import com.example.project1movie.data.model.GenresEntry
import com.example.project1movie.utils.TypeModel
import org.json.JSONArray
import org.json.JSONObject

class ParseDataWithJson {

    fun parseJson(jsonString: String, typeModel: TypeModel): Any? {
        return try {
            when (typeModel) {
                TypeModel.GENRES -> {
                    parseJsonToList(
                            JSONObject(jsonString).getJSONArray(GenresEntry.LIST_GENRES),
                            typeModel
                    )
                }
                TypeModel.HOT -> {
                    parseJsonToList(
                            JSONObject(jsonString).getJSONArray(GenresEntry.LIST_GENRES),
                            typeModel
                    )
                }
                else -> null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    @Throws(Exception::class)
    private fun parseJsonToList(jsonArray: JSONArray?, typeModel: TypeModel): Any {
        val data = mutableListOf<Any?>()
        for (i in 0 until (jsonArray?.length() ?: 0)) {
            val jsonObject = jsonArray?.getJSONObject(i)
            data.add(parseJsonToObject(jsonObject, typeModel))
        }
        return data.filterNotNull()
    }

    @Throws(Exception::class)
    private fun parseJsonToObject(jsonObject: JSONObject?, typeModel: TypeModel): Any? {
        val parseJsonToModel = ParseJsonToModel()
        return when (typeModel) {
            TypeModel.GENRES -> {
                parseJsonToModel.parseJsonToGenres(jsonObject)
            }
            else -> null
        }
    }
}