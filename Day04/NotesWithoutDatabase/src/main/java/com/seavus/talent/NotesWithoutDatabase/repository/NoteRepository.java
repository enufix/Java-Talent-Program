package com.seavus.talent.NotesWithoutDatabase.repository;

import com.seavus.talent.NotesWithoutDatabase.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {

    private long nextId = 101;

    private ArrayList<Note> notes = new ArrayList<>();

    public void save(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public List<Note> findAll() {

        return notes;
    }

    public void updateNoteById(Long id, Note note) {
        notes.forEach(note1 -> {
            if (note1.getId().equals(id)) {
                note1.setTitle(note.getTitle());
                note1.setContent(note.getContent());
            }
        });

    }

    public void deleteNoteById(Long id) {
        notes.remove(findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }


}
