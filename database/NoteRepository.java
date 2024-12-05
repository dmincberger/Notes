package com.example.notesdm.database;

import com.example.notesdm.model.Note;

import java.util.Collections;
import java.util.List;

public class NoteRepository implements NoteDAO{

    private NoteDAO dao;

    public NoteRepository(NoteDAO dao) {

        this.dao = dao;
    }

    @Override
    public List<Note> getAll() {
        return Collections.emptyList();
    }

    @Override
    public void insertAll(Note... notes) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(Note note) {

    }

    @Override
    public void insertOne(Note note) {
    dao.insertOne(note);
    }
}