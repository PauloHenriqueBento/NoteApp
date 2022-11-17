package br.senac.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.databinding.ActivityNewNoteBinding
import br.senac.noteapp.db.Database
import br.senac.noteapp.model.Note

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            inserirNota()
        }
    }

    fun inserirNota() {
        // 1 - Instancia room
        val db = Room.databaseBuilder(this, Database::class.java, "notes").build()

        //2 - Carregar parametros
        val nota = Note(title = binding.etTitle.text.toString(), desc = binding.etDesc.text.toString())

        //3 - Obter e executar a funcao do DAO
        Thread{
            db.noteDao().inserir(nota)
            finish()
        }.start()
    }

}