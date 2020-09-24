package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.UserRepository;
import com.seavus.talent.Notes.security.SecurityService;
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
    private SecurityService securityService;


    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository, SecurityService securityService) {

        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.securityService = securityService;


    }

    public void createNote(String title, String content) {
        User user = securityService.getAuthenticatedUser();
        Note note = new Note(title, content, user);
        noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {

        return noteRepository.findById(id);

    }

    public List<Note> findNotes(User user) {
        return noteRepository.findByUser(user);
    }

    public List<Note> findNotesByTagId(Long id) {

        return noteRepository.findNotesByTagsId(id);
    }

    public void updateNote(String title, String content, Long id) {
        Note note = noteRepository.findById(id).get();
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);
   }


    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public void deleteTagFromNote(Tag tag) {

        noteRepository.findAll().forEach(note -> note.getTags().remove(tag));

    }
}
