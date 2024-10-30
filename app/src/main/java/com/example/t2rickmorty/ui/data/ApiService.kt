package com.example.t2rickmorty.ui.data

import com.example.t2rickmorty.ui.model.Character
import com.example.t2rickmorty.ui.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCharacter(): Response<CharacterResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") characterId : Int) : Response<Character>
}