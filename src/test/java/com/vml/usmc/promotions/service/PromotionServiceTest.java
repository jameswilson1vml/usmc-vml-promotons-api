package com.vml.usmc.promotions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.vml.usmc.events.IEventsClient;
import com.vml.usmc.events.model.Event;
import com.vml.usmc.events.model.Event.EventType;
import com.vml.usmc.promotions.model.Promotion;

@SpringBootTest
public class PromotionServiceTest {

    @Mock
    private IEventsClient eventsClient;
    
    @InjectMocks
    private PromotionService promotionService;

    @Test
    void createSamplePromotion_ShouldReturnSamplePromotion() throws Exception {
        when(eventsClient.getEvent(UUID.randomUUID())).thenReturn(new Event(UUID.randomUUID(), "Test Event",
            false, EventType.NATIONAL_PARTNERSHIP, UUID.randomUUID()));
        
        Promotion promotion = promotionService.createSamplePromotion(null);

        assertNotNull(promotion);
        assertNotNull(promotion.getFulfillmentPackage());
        assertEquals(promotion.getFulfillmentPackage().getImage(), "./google");
        assertNotNull(promotion.getFulfillmentPackage().getItems());
        assertTrue(promotion.getFulfillmentPackage().getItems().size() > 0);
        assertEquals(promotion.getFulfillmentPackage().getItems().get(0).getCode(), "Lorem");
        assertEquals(promotion.getFulfillmentPackage().getItems().get(0).getShortDescription(), "Lorem Ipsum");
    }
}
