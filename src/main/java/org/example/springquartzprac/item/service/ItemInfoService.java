package org.example.springquartzprac.item.service;

import org.example.springquartzprac.item.dto.request.ItemRequest;

import java.time.LocalDate;

public interface ItemInfoService {
    
    Long addItemInfo(ItemRequest itemRequest);
    
    void updateItemDate(LocalDate today);
}
