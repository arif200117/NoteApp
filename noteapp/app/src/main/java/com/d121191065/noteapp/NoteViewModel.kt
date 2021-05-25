package com.d121191065.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.d121191065.noteapp.database.note.Note
import com.d121191065.noteapp.database.note.NoteRepository

class NoteViewModel (application: Application) : AndroidViewModel(application) {

    private var noteRepository = NoteRepository(application)
    private var notes: LiveData<List<Note>>? = noteRepository.getNotes()

    fun insertNote(note: Note){
        noteRepository.insert(note)
    }

    fun getNotes(): LiveData<List<Note>>? {
        return notes
    }

    fun deleteNote(note: Note){
        noteRepository.delete(note)
    }

    fun updateNote(note: Note){
        noteRepository.update(note)
    }
}