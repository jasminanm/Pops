package pt.iade.ei.pops.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import pt.iade.ei.pops.model.GameItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedItemBottomSheet(
    selectedItem: GameItem?,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onConfirm: (GameItem) -> Unit
) {
    if (selectedItem == null) return
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        PurchaseSheetContent(
            item = selectedItem,
            onCancel = onDismiss,
            onConfirm = { onConfirm(selectedItem) }
        )
    }
}

