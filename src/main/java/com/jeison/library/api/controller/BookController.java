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
import com.jeison.library.api.dto.request.BookReq;
import com.jeison.library.api.dto.response.BookResp;
import com.jeison.library.api.dto.response.BookRespWithDetails;
import com.jeison.library.infrastructure.abstract_services.IBookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final IBookService service;

    @Operation(summary = "Get a book by its ID number")
    @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookRespWithDetails> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Create a book")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @PostMapping
    public ResponseEntity<BookResp> createUser(@Validated @RequestBody BookReq userReq) {
        return ResponseEntity.ok(service.create(userReq));
    }

    @Operation(summary = "Update a book by its ID number")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @PutMapping("{id}")
    public ResponseEntity<BookResp> updateUser(@Validated @RequestBody BookReq userReq, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(userReq, id));
    }

    @Operation(summary = "Delete a book by its ID number")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
