package org.example.springquartzprac.item.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    
    private String itemName;
    
    private Long price;
    
    @Temporal(TemporalType.DATE)
    private Date today = Date.valueOf(LocalDate.of(1999, 9, 8));
    
    @Builder
    private Item(String itemName, Long price) {
        this.itemName = itemName;
        this.price = price;
    }
}
