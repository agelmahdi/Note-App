package com.agelmahdi.noteapp.di

import android.app.Application
import androidx.room.Room
import com.agelmahdi.noteapp.feature_note.data.data_source.NoteDatabase
import com.agelmahdi.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.agelmahdi.noteapp.feature_note.domain.repository.NoteRepository
import com.agelmahdi.noteapp.feature_note.domain.use_case.AddNoteUC
import com.agelmahdi.noteapp.feature_note.domain.use_case.DeleteNoteUC
import com.agelmahdi.noteapp.feature_note.domain.use_case.GetNodesUC
import com.agelmahdi.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDAO)
    }

    @Provides
    @Singleton
    fun provideUseCases(noteRepository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNodes = GetNodesUC(noteRepository),
            deleteNote = DeleteNoteUC(noteRepository),
            insert = AddNoteUC(noteRepository)
        )
    }
}