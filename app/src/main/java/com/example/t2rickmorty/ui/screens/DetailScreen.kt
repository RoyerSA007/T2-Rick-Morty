package com.example.t2rickmorty.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.t2rickmorty.ui.data.RetroFitInstance
import com.example.t2rickmorty.ui.model.Character

@Composable
fun DetailScreen(characterId : Int){
    var character by remember{
        mutableStateOf<Character?>(null) }

    LaunchedEffect(characterId) {
        val fetchedCharacter = RetroFitInstance.api.getCharacterById(characterId).body()
        character = fetchedCharacter
    }

    character?.let {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ){
            AsyncImage(
                model = it.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop)

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.name)
            Text(text = "Status: ${it.status}")
            Text(text = "Species: ${it.species}")
            Text(text = "Gender: ${it.gender}")
            Text(text = "Location: ${it.location.name}")
        }
    }
}