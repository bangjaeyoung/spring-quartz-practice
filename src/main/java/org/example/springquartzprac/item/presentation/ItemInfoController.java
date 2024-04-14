package org.example.springquartzprac.item.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springquartzprac.item.service.ItemInfoService;
import org.example.springquartzprac.item.dto.request.ItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemInfoController {
    
    private final ItemInfoService itemInfoService;
    
    @PostMapping
    public ResponseEntity<Long> postItemInfo(@RequestBody ItemRequest requestDto) {
        Long addedItemId = itemInfoService.addItemInfo(requestDto);
        return new ResponseEntity<>(addedItemId, HttpStatus.CREATED);
    }
}
