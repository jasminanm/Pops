package pt.iade.ei.pops.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.pops.model.Game
import pt.iade.ei.pops.model.GameStoreRepository
import pt.iade.ei.pops.ui.components.GameCard
import pt.iade.ei.pops.ui.components.GameStoreTopBar
import pt.iade.ei.pops.ui.components.HeroSection
import pt.iade.ei.pops.ui.theme.PopsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameStoreScreen(
    games: List<Game>,
    onGameSelected: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { GameStoreTopBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item { HeroSection(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) }
            items(games) { game ->
                GameCard(
                    game = game,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                    onClick = { onGameSelected(game) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GameStoreScreenPreview() {
    PopsTheme {
        GameStoreScreen(
            games = GameStoreRepository.sampleGames(),
            onGameSelected = {}
        )
    }
}
