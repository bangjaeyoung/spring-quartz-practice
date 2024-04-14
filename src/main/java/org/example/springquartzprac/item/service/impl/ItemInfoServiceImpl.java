package org.example.springquartzprac.item.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springquartzprac.item.domain.Item;
import org.example.springquartzprac.item.domain.repository.ItemRepository;
import org.example.springquartzprac.item.dto.request.ItemRequest;
import org.example.springquartzprac.item.service.ItemInfoService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemInfoServiceImpl implements ItemInfoService {
    
    private final ItemRepository itemRepository;
    
    @Override
    public Long addItemInfo(ItemRequest itemRequest) {
        Item item = ItemRequest.toEntity(itemRequest);
        itemRepository.save(item);
        return item.getItemId();
    }
}
