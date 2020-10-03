package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.TagRepository;
import com.seavus.talent.Notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TagService {
    private TagRepository tagRepository;
    private SecurityService securityService;

    @Autowired
    public TagService(TagRepository tagRepository, SecurityService securityService) {
        this.tagRepository = tagRepository;
        this.securityService = securityService;
    }

    public Tag createTag(String name) {
        User user = securityService.getAuthenticatedUser();
        Tag tag = new Tag(name, user);
        return tagRepository.save(tag);
    }

    public Set<Tag> findTags(User user) {

        return tagRepository.findByUser(user);
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public Tag updateTag(Long id, String name) {
        Tag tag = tagRepository.findById(id).get();
        tag.setName(name);
        return tagRepository.save(tag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }


}
