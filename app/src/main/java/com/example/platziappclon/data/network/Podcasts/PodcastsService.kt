package com.example.platziappclon.data.network.Podcasts


import com.example.platziappclon.core.MediaHelper
import com.example.platziappclon.core.RetrofitHelper
import com.example.platziappclon.data.model.PodcastsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class PodcastsService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val mediaPlayer = MediaHelper.getMedia()

    suspend fun getPodcasts():List<PodcastsModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PodcastsApiClient::class.java).getAllPodcasts()
            response.body() ?: emptyList()
        }
    }

    fun preparePodcast(url:String){
        if (!mediaPlayer.isPlaying){
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    suspend fun togglePodcast(){
        return withContext(Dispatchers.IO){
            try {
                if (!mediaPlayer.isPlaying){
                    mediaPlayer.start()
                }else{
                    mediaPlayer.stop()
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}