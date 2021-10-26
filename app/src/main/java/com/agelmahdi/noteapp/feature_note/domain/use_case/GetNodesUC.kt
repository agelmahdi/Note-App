package com.agelmahdi.noteapp.feature_note.domain.use_case

import androidx.compose.ui.text.toLowerCase
import com.agelmahdi.noteapp.feature_note.domain.model.Note
import com.agelmahdi.noteapp.feature_note.domain.repository.NoteRepository
import com.agelmahdi.noteapp.feature_note.domain.util.NoteOrder
import com.agelmahdi.noteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNodesUC(
    val noteRepository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.DES)
    ): Flow<List<Note>> {

        return noteRepository.getAllNotes().map { notes ->

            when (noteOrder.orderType) {

                is OrderType.ASD -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }

                is OrderType.DES -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }

            }
        }
    }
}