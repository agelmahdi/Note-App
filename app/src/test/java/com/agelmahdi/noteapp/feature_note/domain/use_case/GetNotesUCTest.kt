package com.agelmahdi.noteapp.feature_note.domain.use_case

import com.agelmahdi.noteapp.feature_note.data.repository.FakeNoteRepository
import com.agelmahdi.noteapp.feature_note.domain.model.Note
import com.agelmahdi.noteapp.feature_note.domain.util.NoteOrder
import com.agelmahdi.noteapp.feature_note.domain.util.OrderType
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesUCTest {

    private lateinit var getNotes: GetNotesUC
    private lateinit var fackRepository: FakeNoteRepository

    @Before
    fun setup() {

        fackRepository = FakeNoteRepository()
        getNotes = GetNotesUC(fackRepository)

        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = index.toLong(),
                    color = index

                )
            )
        }

        notesToInsert.shuffle()

        runBlocking {
            notesToInsert.forEach {
                fackRepository.insertNote(it)
            }
        }
    }
    @Test
    fun `Order note by Title ascending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.ASD)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].title).isLessThan(notes[i+1].title)
        }
    }

    @Test
    fun `Order note by Title descending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.DES)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].title).isGreaterThan(notes[i+1].title)
        }
    }

    @Test
    fun `Order note by Content ascending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.ASD)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].content).isLessThan(notes[i+1].content)
        }
    }

    @Test
    fun `Order note by Content descending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.DES)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].content).isGreaterThan(notes[i+1].content)
        }
    }

    @Test
    fun `Order note by Date ascending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.ASD)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].timestamp).isLessThan(notes[i+1].timestamp)
        }
    }

    @Test
    fun `Order note by Date descending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.DES)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].timestamp).isGreaterThan(notes[i+1].timestamp)
        }
    }

    @Test
    fun `Order note by Color ascending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.ASD)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].color).isLessThan(notes[i+1].color)
        }
    }

    @Test
    fun `Order note by Color descending, correct order` () = runBlocking{
        val notes = getNotes(NoteOrder.Title(OrderType.DES)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].color).isGreaterThan(notes[i+1].color)
        }
    }
}
