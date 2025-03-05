package service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.astrapay.repository.Notes;
import com.astrapay.service.NotesServiceImpl;

class NotesServiceTest {

    private NotesServiceImpl notesService;

    @BeforeEach
    void setUp() {
        notesService = new NotesServiceImpl();
    }

    @Test
    void testAddNotes() {
        Notes note = notesService.addNotes("Test Title", "Test Description");

        assertNotNull(note);
        assertEquals("Test Title", note.getName());
        assertEquals("Test Description", note.getDescription());
        assertNotNull(note.getTime());
    }

    @Test
    void testGetAllNotes() {
        notesService.addNotes("Title 1", "Description 1");
        notesService.addNotes("Title 2", "Description 2");
        notesService.addNotes("Title 3", "Description 3");
        notesService.addNotes("Title 4", "Description 4");
        notesService.addNotes("Title 5", "Description 5");
        notesService.addNotes("Title 6", "Description 6");

        List<Notes> notesList = notesService.getAllNotes();
        assertEquals(2, notesList.size());
    }

    @Test
    void testDeleteNotes() {
        Notes note = notesService.addNotes("Title", "Description");
        assertEquals(1, notesService.getAllNotes().size());

        notesService.deleteNotes(note.getId());
        assertEquals(0, notesService.getAllNotes().size());
    }
}
