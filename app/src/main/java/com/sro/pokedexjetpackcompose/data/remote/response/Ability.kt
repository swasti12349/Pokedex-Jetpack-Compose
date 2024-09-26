package com.sro.pokedexjetpackcompose.data.remote.response

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)