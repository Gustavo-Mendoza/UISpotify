import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem





@Composable
fun SpotifyPlaylistScreen(
    coverImage: Int,
    title: String,
    description: String,
    songs: List<Song>
) {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(padding)
        ) {
            // Imagen de portada
            Image(
                painter = painterResource(id = coverImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Título y descripción
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(title, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(description, color = Color.Gray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón play
            IconButton(
                onClick = { /* Acción de reproducir */ },
                modifier = Modifier
                    .size(56.dp)
                    .background(Color.Green, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.Black,
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Lista de canciones
            LazyColumn {
                items(songs) { song ->
                    SongItem(song)
                }
            }
        }
    }
}

@Composable
fun SongItem(song: Song) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = song.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(song.title, color = Color.White, fontWeight = FontWeight.Bold)
            Text(song.artist, color = Color.Gray, fontSize = 12.sp)
        }
    }
}


@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.Black
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /* Acción Home */ },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White) },
            label = { Text("Home", color = Color.White) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Acción Search */ },
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White) },
            label = { Text("Search", color = Color.White) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Acción Library */ },
            icon = { Icon(Icons.Filled.LibraryMusic, contentDescription = "Library", tint = Color.White) },
            label = { Text("Library", color = Color.White) }
        )
    }
}



// Modelo de canción
data class Song(val title: String, val artist: String, val imageRes: Int)

