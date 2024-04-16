package org.example.springquartzprac.item.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {
    
    FOOD("음식"),
    NOT_FOOD("물건");
    
    private final String description;
}
