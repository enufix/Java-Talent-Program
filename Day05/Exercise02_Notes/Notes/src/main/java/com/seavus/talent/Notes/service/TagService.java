package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.TagRepository;
import com.seavus.talent.Notes.repository.UserRepository;
import com.seavus.talent.Notes.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private TagRepository tagRepository;
    private UserRepository userRepository;
    private SecurityService securityService;

    @Autowired
    public TagService(TagRepository tagRepository, UserRepository userRepository, SecurityService securityService) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    public void createTag(String name) {
        User user = securityService.getAuthenticatedUser();
        Tag tag = new Tag(name, user);
        tagRepository.save(tag);
    }


    public List<Tag> findTags(User user) {

        return tagRepository.findByUser(user);
    }

    public Optional<Tag> findTag(Long id) {
        return tagRepository.findById(id);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
