package com.inditex.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {

    @EmbeddedId
    private PriceId priceId;

    @NotNull
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "price_list")
    private Integer priceList;

    @NotNull
    @Column(name = "price")
    private Double price;

    @NotNull
    @Size(min=1, max=45)
    @Column(name = "curr")
    private String curr;
}