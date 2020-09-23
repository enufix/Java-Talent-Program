package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findNotesByTagsId(Long id);

}

