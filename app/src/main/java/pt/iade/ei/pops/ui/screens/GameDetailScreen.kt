package pt.iade.ei.pops.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import pt.iade.ei.pops.model.Game
import pt.iade.ei.pops.model.GameItem
import pt.iade.ei.pops.model.GameStoreRepository
import pt.iade.ei.pops.ui.components.CoverSection
import pt.iade.ei.pops.ui.components.DetailTopBar
import pt.iade.ei.pops.ui.components.GameInfoSection
import pt.iade.ei.pops.ui.components.PurchasableItemRow
import pt.iade.ei.pops.ui.components.SelectedItemBottomSheet
import pt.iade.ei.pops.ui.theme.PopsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    game: Game,
    onBack: () -> Unit,
    onConfirmPurchase: (GameItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var selectedItem by rememberSaveable { mutableStateOf<GameItem?>(null) }

    SelectedItemBottomSheet(
        selectedItem = selectedItem,
        sheetState = sheetState,
        onDismiss = {
            coroutineScope.launch {
                sheetState.hide()
                selectedItem = null
            }
        },
        onConfirm = { item ->
            onConfirmPurchase(item)
            coroutineScope.launch {
                sheetState.hide()
                selectedItem = null
            }
        }
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DetailTopBar(
                title = game.title,
                onBack = onBack
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { CoverSection(game = game) }
            item { GameInfoSection(game = game) }
            item {
                Text(
                    text = "Itens compráveis",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
            items(game.purchasableItems) { item ->
                PurchasableItemRow(
                    item = item,
                    onClick = {
                        selectedItem = item
                        coroutineScope.launch { sheetState.show() }
                    }
                )
            }
            item { Spacer(modifier = Modifier.height(32.dp)) }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GameDetailScreenPreview() {
    PopsTheme {
        GameDetailScreen(
            game = GameStoreRepository.sampleGames().first(),
            onBack = {},
            onConfirmPurchase = {}
        )
    }
}
