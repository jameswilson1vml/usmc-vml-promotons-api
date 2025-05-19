package com.vml.usmc.promotions.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vml.usmc.promotions.entity.PromotionEntity;

@Repository
public interface IPromotionsRepository extends JpaRepository<PromotionEntity, UUID> {
    //custom queries can go here
    //crud supported by id inherited
}
