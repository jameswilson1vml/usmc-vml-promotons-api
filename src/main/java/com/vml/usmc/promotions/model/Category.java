package com.vml.usmc.promotions.model;

public enum Category {
    AIR_SHOW("Air Show"),
    AUTO_SHOW("Auto Show"),
    BASEBALL("Baseball"),
    BASKETBALL("Basketball"),
    CAREER_JOB_FAIR("Career Job Fair");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
