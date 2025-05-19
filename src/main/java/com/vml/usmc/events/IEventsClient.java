package com.vml.usmc.events;

import java.util.Set;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vml.usmc.events.model.Event;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "eventsClient", url = "${eventsClient.url}")
public interface IEventsClient {

    @GetMapping("/api/v1/events/{id}")
    Event getEvent(@PathVariable UUID id);

    @GetMapping("/api/v1/events")
    Event getAllEvents(@PathVariable UUID id);

    @GetMapping("/api/v1/events")
    Set<Event> getEventsByPromotionId(@RequestParam("promotionId") UUID promotionId);

    @PostMapping("/api/v1/events")
    Event addEvent(@RequestBody Event event);
}
