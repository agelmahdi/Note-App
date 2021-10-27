package com.agelmahdi.noteapp.feature_note.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotesUC,
    val deleteNote: DeleteNoteUC,
    val addNote: AddNoteUC,
    val getNote: GetNoteUC
)