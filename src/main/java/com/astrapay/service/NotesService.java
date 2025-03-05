package com.astrapay.service;

import java.util.List;

import com.astrapay.repository.Notes;

public interface NotesService {

    List<Notes> getAllNotes();

    Notes addNotes(String name, String description);

    void deleteNotes(Long id);
}
