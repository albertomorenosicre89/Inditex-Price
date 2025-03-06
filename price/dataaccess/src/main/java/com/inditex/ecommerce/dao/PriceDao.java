package com.inditex.ecommerce.dao;

import com.inditex.ecommerce.entities.PriceEntity;
import com.inditex.ecommerce.entities.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceDao extends JpaRepository<PriceEntity, PriceId> {

    @Query(value = "select pe from PriceEntity pe where " +
            "( :selectedDate is null or (:selectedDate is not null and pe.startDate <=:selectedDate and pe.endDate >=:selectedDate)) and "+
            "( :productId is null or pe.priceId.productId = :productId) and " +
            "( :brandId is null or pe.priceId.brandId = :brandId) order by pe.priceList desc limit 1")
    PriceEntity getPrice(@Param("selectedDate") LocalDateTime selectedDate, @Param("productId") Integer productId , @Param("brandId") Integer brandId);

}