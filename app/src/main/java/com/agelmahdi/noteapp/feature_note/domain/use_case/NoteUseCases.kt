package com.agelmahdi.noteapp.feature_note.domain.use_case

data class NoteUseCases(
    val getNodes: GetNodesUC,
    val deleteNote: DeleteNoteUC,
    val addNote: AddNoteUC
)