package com.vml.usmc.promotions.controller;

import com.vml.usmc.promotions.model.Promotion;
import com.vml.usmc.promotions.service.PromotionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/promotions")
@Validated
@Tag(name = "Promotions", description = "Promotions management APIs")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @Operation(summary = "Get all promotions", description = "Returns a list of all available promotions")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved promotions",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Promotion.class)))
    })
    @GetMapping
    public ResponseEntity<Set<Promotion>> getPromotions() {
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @Operation(summary = "Get a promotion", description = "Returns a promotion by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved an promotion",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Promotion.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotion(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(promotionService.getPromotionById(id));
    }

    @Operation(summary = "Post a promotion", description = "Adds a promotion")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created a promotion",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Promotion.class)))
    })
    @PostMapping
    public ResponseEntity<Promotion> addPromotion(@Valid @RequestBody Promotion promotion) {
        UUID id = promotionService.addNewPromotion(promotion);

        promotion.setId(id);

        return ResponseEntity.created(URI.create("/promotions/" + id.toString()))
            .body(promotion);
    }
}
