package com.agelmahdi.noteapp.feature_note.domain.use_case

import com.agelmahdi.noteapp.feature_note.domain.model.Note
import com.agelmahdi.noteapp.feature_note.domain.repository.NoteRepository

class GetNoteUC(
    val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteByID(id)
    }
}