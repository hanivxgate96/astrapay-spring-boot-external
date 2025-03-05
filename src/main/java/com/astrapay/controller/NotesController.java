package com.astrapay.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrapay.dto.NotesDto;
import com.astrapay.repository.Notes;
import com.astrapay.service.NotesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {

    private final NotesService notesService;

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @PostMapping
    public ResponseEntity<Notes> addNote(@RequestBody NotesDto notesDto) {
        if (notesDto.getName().isEmpty() || notesDto.getDescription().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(notesService.addNotes(notesDto.getName(), notesDto.getDescription()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotes(@PathVariable Long id) {
        notesService.deleteNotes(id);
        return ResponseEntity.noContent().build();
    }
}
