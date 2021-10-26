package com.agelmahdi.noteapp.feature_note.presentation.notes

import com.agelmahdi.noteapp.feature_note.domain.model.Note
import com.agelmahdi.noteapp.feature_note.domain.util.NoteOrder
import com.agelmahdi.noteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.DES),
    val isOrderSectionVisible: Boolean = false
)