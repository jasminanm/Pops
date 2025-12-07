package pt.iade.ei.pops

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.pops.model.Game
import pt.iade.ei.pops.model.GameStoreRepository
import pt.iade.ei.pops.ui.screens.GameStoreScreen
import pt.iade.ei.pops.ui.theme.PopsTheme

class MainActivity : ComponentActivity() {

    private val featuredGames by lazy { GameStoreRepository.sampleGames() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PopsTheme {
                GameStoreScreen(
                    games = featuredGames,
                    onGameSelected = ::openGameDetails
                )
            }
        }
    }

    private fun openGameDetails(game: Game) {
        val intent = Intent(this, GameDetailActivity::class.java).apply {
            putExtra(GameDetailActivity.GAME_EXTRA_KEY, game)
        }
        startActivity(intent)
    }
}

@Preview(showBackground = true)
@Composable
private fun MainActivityPreview() {
    PopsTheme {
        GameStoreScreen(
            games = GameStoreRepository.sampleGames(),
            onGameSelected = {}
        )
    }
}