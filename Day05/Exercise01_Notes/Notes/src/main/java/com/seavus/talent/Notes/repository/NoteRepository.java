package com.seavus.talent.Notes.repository;

import com.seavus.talent.Notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}

