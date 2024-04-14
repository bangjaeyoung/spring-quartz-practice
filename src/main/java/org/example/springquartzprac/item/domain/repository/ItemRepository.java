package org.example.springquartzprac.item.domain.repository;

import org.example.springquartzprac.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
