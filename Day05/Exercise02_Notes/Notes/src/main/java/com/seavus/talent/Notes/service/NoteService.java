package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.NoteRepository;
import com.seavus.talent.Notes.repository.TagRepository;
import com.seavus.talent.Notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private SecurityService securityService;
    private TagRepository tagRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, SecurityService securityService, TagRepository tagRepository) {

        this.noteRepository = noteRepository;
        this.securityService = securityService;
        this.tagRepository = tagRepository;
    }

    public Note createNote(String title, String content) {
        User user = securityService.getAuthenticatedUser();
        Set<Long> tagIds = new HashSet<>();
        tagIds.add(user.getId());
        Set<Tag> tags = tagRepository.findAllById(tagIds).stream().filter(tag -> tag.getUser().equals(user)).collect(Collectors.toSet());
        Note note = new Note(title, content, user, tags);
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(Long id) {

        return noteRepository.findById(id);

    }

    public Set<Note> findNotes(User user) {
        return noteRepository.findByUser(user);
    }

    public Set<Note> findNotesByTagId(Long id) {

        return noteRepository.findNotesByTagsId(id);
    }

    public Note updateNote(String title, String content, Long id) {
        User user = securityService.getAuthenticatedUser();
        Set<Long> tagIds = new HashSet<>();
        tagIds.add(user.getId());
        Set<Tag> tags = tagRepository.findAllById(tagIds).stream().filter(tag -> tag.getUser().equals(user)).collect(Collectors.toSet());
        Note note = noteRepository.findById(id).get();
        note.setTitle(title);
        note.setContent(content);
        note.setTags(tags);
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public void deleteTagFromNote(Tag tag) {

        noteRepository.findAll().forEach(note -> note.getTags().remove(tag));

    }
}
