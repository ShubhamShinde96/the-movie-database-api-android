package com.shubham.tmdbclient.presentation.di.core

import com.shubham.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.shubham.tmdbclient.presentation.di.movie.MovieSubComponent
import com.shubham.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataSourceModule::class,
        DatabaseModule::class,
        LocalDataSourceModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory

}