package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.security.SecurityService;
import com.seavus.talent.Notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@RequestMapping
@RestController
public class NoteController {

    private NoteService noteService;
    private SecurityService securityService;

    @Autowired
    public NoteController(NoteService noteService, SecurityService securityService) {

        this.noteService = noteService;
        this.securityService = securityService;
    }

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody CreateNoteRequest request) {
        return noteService.createNote(request.title, request.content, request.tagIds);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
        public Set<Long> tagIds = new HashSet<>();
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/notes")
    public Set<Note> findNotes() {
        User user = securityService.getAuthenticatedUser();
        return noteService.findNotes(user);
    }

    @GetMapping("api/tags/{id}/notes")
    public Set<Note> findNotesByTagId(@PathVariable Long id) {

        return noteService.findNotesByTagId(id);
    }

    @PutMapping("/api/notes/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody CreateNoteRequest request) {

        return noteService.updateNote(request.title, request.content, id, request.tagIds);

    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {

        noteService.deleteNote(id);

    }
}
