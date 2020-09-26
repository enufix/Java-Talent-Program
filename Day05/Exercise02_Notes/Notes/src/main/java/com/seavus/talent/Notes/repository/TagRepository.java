package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Tag;
import com.seavus.talent.Notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Set<Tag> findByUser(User user);
}
