package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private UserRepository userRepository;


    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {

        this.noteRepository = noteRepository;
        this.userRepository = userRepository;


    }

    public void createNote(String title, String content, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Note note = new Note(title, content, user);
        noteRepository.save(note);

    }

    public Optional<Note> findNote(Long id) {

        return noteRepository.findById(id);

    }

    public List<Note> findNotes() {

        return noteRepository.findAll();

    }

    public List<Note> findNotesByTagId(Long id) {
        return noteRepository.findNotesByTagsId(id);
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
