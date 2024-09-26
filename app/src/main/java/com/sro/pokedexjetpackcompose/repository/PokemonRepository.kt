package com.sro.pokedexjetpackcompose.repository

import com.sro.pokedexjetpackcompose.data.remote.PokeApi
import com.sro.pokedexjetpackcompose.data.remote.response.Pokemon
import com.sro.pokedexjetpackcompose.data.remote.response.PokemonList
import com.sro.pokedexjetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class PokemonRepository(private val api: PokeApi) {


    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {

            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(poekemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(poekemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }

        return Resource.Success(response)
    }
}