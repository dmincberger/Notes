package com.example.notesdm.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.notesdm.model.Note;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOne(Note note);

    @Query("SELECT * FROM NoteTBL")
    List<Note> getAll();

    @Insert
        void insertAll(Note... notes);

    @Query("DELETE FROM NoteTBL")
    void deleteAll();

    @Delete
    void delete(Note note);
}
