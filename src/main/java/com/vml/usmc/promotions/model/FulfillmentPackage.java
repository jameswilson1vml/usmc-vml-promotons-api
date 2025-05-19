package com.vml.usmc.promotions.model;

import java.util.List;

import lombok.Data;

@Data
public class FulfillmentPackage {
    private String image;
    private List<FulfillmentItem> items;
}
