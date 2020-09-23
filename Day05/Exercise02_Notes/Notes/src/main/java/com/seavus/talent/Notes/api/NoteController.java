package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RequestMapping
@RestController
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {

        this.noteService = noteService;
    }

    @PostMapping("/api/notes")
    public void createNote(@RequestBody CreateNoteRequest request) {

        noteService.createNote(request.title, request.content, request.userId);
    }

    public static class CreateNoteRequest {
        public String title;
        public String content;
        public Long userId;
    }

    @GetMapping("/api/notes/{id}")
    public Note findNote(@PathVariable Long id) {
        return noteService.findNote(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/notes")
    public List<Note> findNotes() {

        return noteService.findNotes();
    }

    @GetMapping("api/notes/tags/{id}")
    public List<Note> findNotesByTagId(@PathVariable Long id) {
        return noteService.findNotesByTagId(id);
    }


    @PutMapping("/api/notes/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note note) {

        noteService.updateNote(id, note);

    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {

        noteService.deleteNote(id);

    }


}
