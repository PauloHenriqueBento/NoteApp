package br.senac.noteapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senac.noteapp.model.Note

@Dao
interface NoteDao {

    @Insert
    fun inserir(note: Note)

    @Query("SELECT * FROM note")
    fun listar(): List<Note>

}