package com.jeison.library.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeison.library.api.dto.errors.ErrorResp;
import com.jeison.library.api.dto.request.ReservationReq;
import com.jeison.library.api.dto.request.ReservationToUpdate;
import com.jeison.library.api.dto.response.ReservationRespWithDetails;
import com.jeison.library.infrastructure.abstract_services.IReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private final IReservationService service;

    @Operation(summary = "Get a reservation by its ID number")
    @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @GetMapping("/{id}")
    public ResponseEntity<ReservationRespWithDetails> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Create a reservation")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @PostMapping
    public ResponseEntity<ReservationRespWithDetails> createReservation(
            @Validated @RequestBody ReservationReq reservationReq) {
        return ResponseEntity.ok(service.create(reservationReq));
    }

    @Operation(summary = "Update a reservation by its ID number")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @PutMapping("{id}")
    public ResponseEntity<ReservationRespWithDetails> updateReservation(
            @Validated @RequestBody ReservationToUpdate reservationReq, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(reservationReq, id));
    }

    @Operation(summary = "Delete a reservation by its ID number")
    @ApiResponse(responseCode = "204", description = "Reservation deleted successfully")
    @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
