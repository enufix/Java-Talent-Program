package com.seavus.talent.Notes.api;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RequestMapping
@RestController
public class TagController {
    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    public static class CreateTagRequest {
        public String name;
        public Long userId;
    }

    @PostMapping("/api/tags")
    public void createTag(@RequestBody TagController.CreateTagRequest request) {

        tagService.createTag(request.name, request.userId);
    }


    @GetMapping("/api/tags")
    public List<Tag> findTags() {

        return tagService.findTags();
    }

    @GetMapping("/api/tags/{id}")
    public Tag findTag(@PathVariable Long id) {
        return tagService.findTag(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/api/tags/{id}")
    public void deleteTag(@PathVariable Long id) {

        tagService.deleteTag(id);

    }

}
