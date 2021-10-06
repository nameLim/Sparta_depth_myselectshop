package com.sparta_depth.fclass.controller;

import com.sparta_depth.fclass.dto.ItemDto;
import com.sparta_depth.fclass.service.ItemSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ItemSearchController {

    private final ItemSearchService itemSearchService;

//    @Autowired
//    public ItemSearchController(ItemSearchService itemSearchService) {
//
//        this.itemSearchService = itemSearchService;
//    }

    @GetMapping("/api/search")
    @ResponseBody
    public List<ItemDto> getItems(@RequestParam String query) throws IOException {
        List<ItemDto> itemDtoList = itemSearchService.getItems(query);

        return itemDtoList;
    }
}