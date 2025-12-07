package pt.iade.ei.pops.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.pops.model.Game
import pt.iade.ei.pops.model.GameStoreRepository
import pt.iade.ei.pops.ui.components.BottomNavigationBar
import pt.iade.ei.pops.ui.components.CompanyHeader
import pt.iade.ei.pops.ui.components.GameCardWithBackground
import pt.iade.ei.pops.ui.theme.PopsTheme

@Composable
fun GameStoreScreen(
    games: List<Game>,
    onGameSelected: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                CompanyHeader()
            }
            items(games) { game ->
                GameCardWithBackground(
                    game = game,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
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
