package pt.iade.ei.pops.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.iade.ei.pops.model.Game

@Composable
fun GameInfoSection(game: Game) {
    Column(verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)) {
        Text(
            text = game.shortDescription,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Destaque: ${game.featuredTag}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Divider()
    }
}

