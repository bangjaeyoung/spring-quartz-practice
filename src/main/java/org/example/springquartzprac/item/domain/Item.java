package org.example.springquartzprac.item.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    
    private LocalDate today = LocalDate.of(1999, 9, 8);
    
    @Builder
    private Item(String itemName, Long price) {
        this.itemName = itemName;
        this.price = price;
    }
}
