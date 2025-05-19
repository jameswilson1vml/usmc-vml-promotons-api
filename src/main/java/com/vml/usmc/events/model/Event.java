package com.vml.usmc.events.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private UUID id;
    private String name;
    private boolean includesBattlePositions;
    private EventType type;
    private UUID promotionId;

    public enum EventType {
        NATIONAL_PARTNERSHIP,
        OFFICER_EVENT,
        RS_DISTRICT_INFLUENCER_EVENT,
        BATTLE_POSITION,
    }
}
