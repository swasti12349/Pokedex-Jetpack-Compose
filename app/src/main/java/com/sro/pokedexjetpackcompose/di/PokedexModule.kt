package com.sro.pokedexjetpackcompose.di

import com.sro.pokedexjetpackcompose.data.remote.PokeApi
import com.sro.pokedexjetpackcompose.repository.PokemonRepository
import com.sro.pokedexjetpackcompose.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokedexModule {
    @Singleton
    @Provides
    fun providePokeApi() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(PokeApi::class.java)

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

}

