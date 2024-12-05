package com.example.notesdm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notesdm.database.NoteDatabase;
import com.example.notesdm.database.NoteRepository;
import com.example.notesdm.model.Note;
import com.example.notesdm.model.Settings;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    private MutableLiveData<List<Note>> mutableNotesList;

    private NoteRepository noteRepository;

    private NoteDatabase noteDatabase;

    public NotesViewModel(@NonNull Application application) {
        super(application);

        noteDatabase = NoteDatabase.getInstance(application.getApplicationContext());

        noteRepository = new NoteRepository(noteDatabase.noteDAO());

        this.mutableNotesList = new MutableLiveData<>();
        this.mutableNotesList.setValue(noteRepository.getAll());

    }

    public MutableLiveData<List<Note>> getObservedNotes() {
        return mutableNotesList;
    }

    public void addNote(Note note){
        noteRepository.insertOne(note);
        this.mutableNotesList.setValue(noteRepository.getAll());
    }
}


