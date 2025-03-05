package com.astrapay.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.astrapay.repository.Notes;

@Service
public class NotesServiceImpl implements NotesService {

    private final List<Notes> notes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public List<Notes> getAllNotes() {
        return notes;
    }

    @Override
    public Notes addNotes(String name, String description) {
        Notes note = new Notes(counter.getAndIncrement(), name, description, LocalDateTime.now());
        notes.add(note);
        return note;
    }

    @Override
    public void deleteNotes(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

}
