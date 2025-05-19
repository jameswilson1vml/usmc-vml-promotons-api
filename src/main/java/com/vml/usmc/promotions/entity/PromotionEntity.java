package com.vml.usmc.promotions.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "aitsPromotionAggregate")
@Data
public class PromotionEntity {
    @Id
    private UUID id;
    private String aitsBaselineId;
    private String fk_marketingCampaignId;
    private String name;
    private String statusLookup;
    private Date startDateGmt;
    private Date endDateGmt;
    private boolean isRecurrence;
    private boolean isWebfacing;
    private String submitter;
    private Date submittedDateGmt;
    private String shortDescription;
    private String detailedDescription;
    private String landingPageUriAfterPromo;
    private String landingPageUriDuringPromo;
    private String fk_reviewId;
    private String createdBy;
    private Date createdDateGMT;
    private String updatedBy;
    private Date updatedDateGmt;
}
