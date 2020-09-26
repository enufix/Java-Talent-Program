package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Note;
import com.seavus.talent.Notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Set<Note> findNotesByTagsId(Long id);

    Set<Note> findByUser(User user);
}

