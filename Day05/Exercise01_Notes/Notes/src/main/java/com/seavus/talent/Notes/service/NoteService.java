package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {

        this.noteRepository = noteRepository;

    }

    public void createNote(String title, String content) {
        Note note = new Note(title, content);
        noteRepository.save(note);

    }

    public Optional<Note> findNote(Long id) {

        return noteRepository.findById(id);

    }

    public List<Note> findNotes() {

        return noteRepository.findAll();

    }

    public void updateNote(Long id, Note note) {
        noteRepository.findAll().forEach(note1 -> {
            if (note1.getId().equals(id)) {
                note1.setTitle(note.getTitle());
                note1.setContent(note.getContent());
            }
        });
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
