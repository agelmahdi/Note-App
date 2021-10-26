package com.agelmahdi.noteapp.feature_note.domain.use_case

import com.agelmahdi.noteapp.feature_note.domain.model.Note
import com.agelmahdi.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNoteUC(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        return noteRepository.deleteNote(note)
    }
}