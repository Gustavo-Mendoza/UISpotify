package com.example.uispotify

import Song
import SpotifyPlaylistScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.PlayArrow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sampleSongs = listOf(
                Song("Busy Woman", "Sabrina Carpenter", R.drawable.song1),
                Song("Die With A Smile", "Lady Gaga, Bruno Mars", R.drawable.song2),
                Song("Luther", "Kendrick Lamar, SZA", R.drawable.song3),
                Song("Messy", "Lola Young", R.drawable.song4)
            )

            SpotifyPlaylistScreen(
                coverImage = R.drawable.cover_playlist,
                title = "Today's Top Hits",
                description = "The hottest 50. Cover: Sabrina Carpenter",
                songs = sampleSongs
            )
        }
    }
}
