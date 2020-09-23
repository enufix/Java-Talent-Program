package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
