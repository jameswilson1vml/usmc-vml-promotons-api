package com.vml.usmc.promotions.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vml.usmc.events.IEventsClient;
import com.vml.usmc.events.model.Event;
import com.vml.usmc.promotions.entity.PromotionEntity;
import com.vml.usmc.promotions.model.FulfillmentItem;
import com.vml.usmc.promotions.model.FulfillmentPackage;
import com.vml.usmc.promotions.model.Promotion;
import com.vml.usmc.promotions.repository.IPromotionsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PromotionService {

    @Autowired
    private IPromotionsRepository promotionsRepo;

    @Autowired
    private IEventsClient eventsClient;
    
    public Promotion createSamplePromotion(UUID id) {
        Promotion samplePromotion = new Promotion();
        if(id != null) {
            samplePromotion.setId(id);
        } else {
            samplePromotion.setId(UUID.randomUUID());
        }
        FulfillmentItem item = new FulfillmentItem();
        item.setCode("Lorem");
        item.setShortDescription("Lorem Ipsum");
        FulfillmentPackage fulfillmentPackage = new FulfillmentPackage();
        fulfillmentPackage.setImage("./google");
        fulfillmentPackage.setItems(Arrays.asList(item));
        samplePromotion.setFulfillmentPackage(fulfillmentPackage);
        samplePromotion.setEvent(eventsClient.getEvent(UUID.randomUUID()));
        return samplePromotion;
    }

    public Set<Promotion> getAllPromotions() {
        List<PromotionEntity> entities = promotionsRepo.findAll();
        Set<Promotion> promotoins = new HashSet<Promotion>();
        Promotion promo;
        Set<Event> events;

        for(PromotionEntity entity : entities) {
            promo = new Promotion();
            promo.setId(entity.getId());
            events = eventsClient.getEventsByPromotionId(promo.getId());
            if(events.size() > 0) {
                promo.setEvent(events.iterator().next());
            } else {
                promo.setEvent(new Event());
            }
            promotoins.add(promo);
        }

        return promotoins;
    }

    public Promotion getPromotionById(UUID id) {
        Promotion promo = new Promotion();

        try {
            if(id != null) {
                promo.setId(id);
                promo.setEvent(eventsClient.getEventsByPromotionId(id).iterator().next());
            } else {
                promo = createSamplePromotion(null);
            }
        } catch(EntityNotFoundException e) {
            //add logging
            promo = createSamplePromotion(id);
        }

        return promo;
    }

    public UUID addNewPromotion(Promotion promotion) {
        PromotionEntity entity = new PromotionEntity();
        UUID id = UUID.randomUUID();

        entity.setId(id);

        promotion.getEvent().setPromotionId(id);
        eventsClient.addEvent(promotion.getEvent());

        promotionsRepo.save(entity);

        return id;
    }
    
}