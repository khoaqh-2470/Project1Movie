package com.example.project1movie.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.project1movie.utils.Constants
import com.example.project1movie.utils.TypeModel
import org.json.JSONObject
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class GetJsonFromUrl<T>(
        private val typeMode: TypeModel,
        private val jsonListener: OnFetchDataJsonListener<T>) {
    private val executor: Executor =
            Executors.newSingleThreadExecutor()

    private val handler: Handler = Handler(Looper.getMainLooper())

    fun <R> executeAsync(url: String) {
        executor.execute {
            with(ApiService().httpGet(url)) {
                val jsonObject = JSONObject(this)
                if (jsonObject.getInt(Constants.GET_STATUS) == 200) {
//                    jsonListener.onSuccess(ParseJson().parseJsonArray(jsonObject))

                } else {
//                    viewMain?.onError(jsonObject.getString(Constants.GET_MESSAGE))
                }
                handler.post { jsonListener.onSuccess(this as T) }
            }

        }
    }
}