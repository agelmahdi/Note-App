package com.agelmahdi.noteapp.feature_note.presentation.add_edit_note

sealed class UIEvent{
    data class showSnakbar(val message: String): UIEvent()
    object saveNote: UIEvent()
}