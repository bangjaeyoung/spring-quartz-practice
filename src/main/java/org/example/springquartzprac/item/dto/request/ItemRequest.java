package org.example.springquartzprac.item.dto.request;

import lombok.Getter;
import org.example.springquartzprac.item.domain.Item;

@Getter
public class ItemRequest {
    
    private String itemName;
    private Long price;
    
    public static Item toEntity(final ItemRequest itemRequest) {
        return Item.builder()
                .itemName(itemRequest.getItemName())
                .price(itemRequest.getPrice())
                .build();
    }
}
