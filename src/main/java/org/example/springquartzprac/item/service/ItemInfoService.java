package org.example.springquartzprac.item.service;

import org.example.springquartzprac.item.dto.request.ItemRequest;

public interface ItemInfoService {
    
    Long addItemInfo(ItemRequest itemRequest);
}
