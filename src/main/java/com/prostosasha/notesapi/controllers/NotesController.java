package com.prostosasha.notesapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prostosasha.notesapi.entities.Note;
import com.prostosasha.notesapi.services.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notes")
// @!C!r!o!s!s!O!r!i!g!i!n!(!o!r!i!g!i!n!s! = "!h!t!t!p!:!//!l!o!c!a!l!h!o1s1t!:!4!2!0!01")
public class NotesController {
    @Autowired
    private NotesService notesService;
    @Autowired
    ObjectMapper objectMapper;

    private final static Logger LOGGER = LoggerFactory.getLogger(NotesController.class);
    private final ResponseStatusException serverException = new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "\n                        SORRY :( \n" +
                    "We know about this trouble and will correct it soon");

    @RequestMapping(method = RequestMethod.GET)
    public List<Note> load(@RequestParam String username, @RequestParam String password) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Input username = " + username + " password = " + password);
        }

        List<Note> notes = new ArrayList<>();

        try {
            notes = notesService.load(username, password);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Returned notes = " + notes.toString());
        }

        System.out.println("Load Output CONTROLLER");
        for (Note note : notes) {
            System.out.println(note.toString());
        }

        return notes;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Boolean save(@RequestParam String jsonNotesArr) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Input jsonNotesArr = " + jsonNotesArr);
        }

        boolean wasSaved = false;

        try {
            List<Note> notes = objectMapper.readValue(jsonNotesArr, new TypeReference<List<Note>>() {
            });

            System.out.println("Save Parsed Input CONTROLLER");
            for (Note note : notes) {
                System.out.println(note.toString());
            }

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Parsed jsonNotesArr = " + notes.toString());
            }

            wasSaved = notesService.save(notes);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Return " + wasSaved);
            }

            System.out.println("Save Controller wasSaved = " + wasSaved);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn(e.getMessage());
            throw serverException;
        }

        return wasSaved;
    }
}
