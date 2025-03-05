package controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.astrapay.controller.NotesController;
import com.astrapay.dto.NotesDto;
import com.astrapay.repository.Notes;
import com.astrapay.service.NotesService;

class NotesControllerTest {

    @Mock
    private NotesService notesService;

    @InjectMocks
    private NotesController notesController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllNotes() {
        List<Notes> notes = Arrays.asList(new Notes(1L, "Title1", "Desc1", null),
                new Notes(2L, "Title2", "Desc2", null));

        when(notesService.getAllNotes()).thenReturn(notes);

        ResponseEntity<List<Notes>> response = notesController.getAllNotes();

        assertEquals(2, response.getBody().size());
        assertEquals("Title1", response.getBody().get(0).getName());
    }

    @Test
    void testAddNotes() {
        NotesDto notesDto = new NotesDto("Title", "Description");
        Notes note = new Notes(1L, "Title", "Description", null);

        when(notesService.addNotes("Title", "Description")).thenReturn(note);

        ResponseEntity<Notes> response = notesController.addNote(notesDto);

        assertNotNull(response.getBody());
        assertEquals("Title", response.getBody().getName());
    }

    @Test
    void testDeleteNotes() {
        doNothing().when(notesService).deleteNotes(1L);

        ResponseEntity<Void> response = notesController.deleteNotes(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(notesService, times(1)).deleteNotes(1L);
    }
}
