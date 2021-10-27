package com.agelmahdi.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.agelmahdi.noteapp.feature_note.domain.util.NoteOrder
import com.agelmahdi.noteapp.feature_note.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.DES),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier,
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onChecked = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) })

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                onChecked = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) })

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color,
                onChecked = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.ASD,
                onChecked = {
                    onOrderChange(noteOrder.copy(OrderType.ASD))
                })

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.DES,
                onChecked = {
                    onOrderChange(noteOrder.copy(OrderType.DES))
                })
        }
    }
}