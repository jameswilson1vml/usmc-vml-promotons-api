package com.vml.usmc.promotions.controller;

import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.vml.usmc.events.IEventsClient;
import com.vml.usmc.events.model.Event;
import com.vml.usmc.events.model.Event.EventType;

@SpringBootTest
@AutoConfigureMockMvc
class PromotionControllerTest {

    @Mock
    private IEventsClient eventsClient;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPromotions_ShouldReturnPromotionsList() throws Exception {
        when(eventsClient.getEvent(UUID.randomUUID())).thenReturn(new Event(UUID.randomUUID(), "Test Event",
            false, EventType.NATIONAL_PARTNERSHIP, UUID.randomUUID()));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/promotions"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].fulfillmentPackage.image").value("./google"))
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].fulfillmentPackage.items").isArray())
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].fulfillmentPackage.items[0].code").value("Lorem"))
               .andExpect(MockMvcResultMatchers.jsonPath("$[0].fulfillmentPackage.items[0].shortDescription").value("Lorem Ipsum"));
    }

    @Test
    void getPromotion_ShouldReturnEvent() throws Exception {
        when(eventsClient.getEvent(UUID.randomUUID())).thenReturn(new Event(UUID.randomUUID(), "Test Event",
            false, EventType.NATIONAL_PARTNERSHIP, UUID.randomUUID()));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/promotions/018b2f19-e79e-7d6a-a56d-29feb6211b04"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.fulfillmentPackage.image").value("./google"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.fulfillmentPackage.items").isArray())
               .andExpect(MockMvcResultMatchers.jsonPath("$.fulfillmentPackage.items[0].code").value("Lorem"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.fulfillmentPackage.items[0].shortDescription").value("Lorem Ipsum"));
    }
}