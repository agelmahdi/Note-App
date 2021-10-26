package com.agelmahdi.noteapp.feature_note.data.repository

import com.agelmahdi.noteapp.feature_note.data.data_source.NoteDAO
import com.agelmahdi.noteapp.feature_note.domain.model.Note
import com.agelmahdi.noteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDAO) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getALlNotes()
    }

    override suspend fun getNoteByID(id: Int): Note? {
        return dao.getNoteByID(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}