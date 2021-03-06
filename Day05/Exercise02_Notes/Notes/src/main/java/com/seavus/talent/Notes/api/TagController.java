package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.security.SecurityService;
import com.seavus.talent.Notes.service.NoteService;
import com.seavus.talent.Notes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RequestMapping
@RestController
public class TagController {
    private TagService tagService;
    private SecurityService securityService;
    private NoteService noteService;

    @Autowired
    public TagController(TagService tagService, SecurityService securityService, NoteService noteService) {
        this.tagService = tagService;
        this.securityService = securityService;
        this.noteService = noteService;
    }

    public static class CreateTagRequest {
        public String name;
    }

    @PostMapping("/api/tags")
    public Tag createTag(@RequestBody TagController.CreateTagRequest request) {

        return tagService.createTag(request.name);
    }

    @GetMapping("/api/tags")
    public Set<Tag> findTags() {
        User user = securityService.getAuthenticatedUser();
        return tagService.findTags(user);
    }

    @GetMapping("/api/tags/{id}")
    public Tag findTag(@PathVariable Long id) {
        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/api/tags/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody CreateTagRequest request) {

        return tagService.updateTag(id, request.name);

    }

    @DeleteMapping("/api/tags/{id}")
    public void deleteTag(@PathVariable Long id) {
        Tag tag = tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        noteService.deleteTagFromNote(tag);
        tagService.deleteTag(id);

    }

}
