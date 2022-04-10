package com.shubham.tmdbclient.data.repository.artist

import android.util.Log
import com.shubham.tmdbclient.data.model.artist.Artist
import com.shubham.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.shubham.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.shubham.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.shubham.tmdbclient.domain.repository.ArtistsRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistsRepository {

    override suspend fun getArtists(): List<Artist>? {

        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {

        val newListOfArtist = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.setArtistsToCache(newListOfArtist)

        return newListOfArtist
    }


    private suspend fun getArtistsFromApi(): List<Artist> {

        lateinit var artistsList: List<Artist>

        try {

            val response = artistRemoteDataSource.getArtists()

            val body = response.body()

            if(body != null) {
                artistsList = body.artists
            }

        } catch (e: Exception) {
            Log.i("TMDB_TAG", "Exception: $e")
        }

        return artistsList
    }

    private suspend fun getArtistFromDB(): List<Artist> {

        lateinit var artistsList: List<Artist>

        try {

            artistsList = artistLocalDataSource.getArtistsFromDB()

        } catch (e: Exception) {

            Log.i("TMDB_TAG", "Exception: $e")
        }

        if(artistsList.isNotEmpty()) {

            return artistsList

        } else {

            artistsList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistsList)
        }

        return artistsList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {

        lateinit var artistsList: List<Artist>

        try {

            artistsList = artistCacheDataSource.getArtistsFromCache()

        } catch (e: Exception) {

            Log.i("TMDB_TAG", "Exception: $e")
        }

        if(artistsList.isNotEmpty()) {

            return artistsList

        } else {

            artistsList = getArtistFromDB()
            artistCacheDataSource.setArtistsToCache(artistsList)
        }

        return artistsList
    }

}