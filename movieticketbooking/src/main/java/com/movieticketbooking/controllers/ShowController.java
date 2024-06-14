package com.movieticketbooking.controllers;

import com.movieticketbooking.DTO.ShowRequestDTO;
import com.movieticketbooking.models.Show;
import com.movieticketbooking.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = showService.getShowById(id);
        return show != null ? ResponseEntity.ok(show) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody ShowRequestDTO showRequestDTO) {
        return ResponseEntity.ok(showService.createShow(showRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show updatedShow = showService.updateShow(id, show);
        return updatedShow != null ? ResponseEntity.ok(updatedShow) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        boolean isDeleted = showService.deleteShow(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
