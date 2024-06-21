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
import com.jeison.library.api.dto.request.LoanReq;
import com.jeison.library.api.dto.request.LoanReqToUpdate;
import com.jeison.library.api.dto.response.LoanRespWithDetails;
import com.jeison.library.infrastructure.abstract_services.ILoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private final ILoanService service;

    @Operation(summary = "Get a loan by its ID number")
    @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @GetMapping("/{id}")
    public ResponseEntity<LoanRespWithDetails> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Create a loan")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @PostMapping
    public ResponseEntity<LoanRespWithDetails> createLoan(@Validated @RequestBody LoanReq loanReq) {
        return ResponseEntity.ok(service.create(loanReq));
    }

    @Operation(summary = "Update a loan by its ID number")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @PutMapping("{id}")
    public ResponseEntity<LoanRespWithDetails> updateLoan(@Validated @RequestBody LoanReqToUpdate loanReq,
            @PathVariable Long id) {
        return ResponseEntity.ok(service.update(loanReq, id));
    }

    @Operation(summary = "Delete a loan by its ID number")
    @ApiResponse(responseCode = "204", description = "Loan deleted successfully")
    @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResp.class))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
