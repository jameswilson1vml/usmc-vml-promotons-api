package com.vml.usmc.promotions.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import com.vml.usmc.events.model.Event;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Promotion {
    private UUID id;
    private String landingPageDuringPromo;
    private String landingPageAfterPromo;
    private Date endDate;
    private String heroImage;
    @NotBlank(message = "Vanity Code is not allowed to be blank")
    private String vanityCode;
    private Event event;
    private FulfillmentPackage fulfillmentPackage;
    private Category category;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Promotion myObject = (Promotion) obj;
        return id.equals(myObject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
