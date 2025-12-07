package pt.iade.ei.pops

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.pops.model.Game
import pt.iade.ei.pops.model.GameItem
import pt.iade.ei.pops.model.GameStoreRepository
import pt.iade.ei.pops.ui.screens.GameDetailScreen
import pt.iade.ei.pops.ui.theme.PopsTheme

class GameDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val game: Game? = intent.getParcelableExtra(GAME_EXTRA_KEY)
        if (game == null) {
            Toast.makeText(this, "Jogo não encontrado", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        setContent {
            PopsTheme {
                GameDetailScreen(
                    game = game,
                    onBack = ::finish,
                    onConfirmPurchase = ::showPurchaseToast
                )
            }
        }
    }

    private fun showPurchaseToast(item: GameItem) {
        Toast.makeText(
            this,
            "Acabou de comprar o item ${item.name} por ${"%.2f".format(item.priceUsd)}€",
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        const val GAME_EXTRA_KEY = "game_extra_key"
    }
}

@Preview(showBackground = true)
@Composable
private fun GameDetailPreview() {
    PopsTheme {
        GameDetailScreen(
            game = GameStoreRepository.sampleGames().first(),
            onBack = {},
            onConfirmPurchase = {}
        )
    }
}

