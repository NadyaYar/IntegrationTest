package com.example.IntegrationTest.cat.controller;

import com.example.IntegrationTest.cat.model.Cat;
import com.example.IntegrationTest.cat.service.impl.CatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cat")
public class CatController {
    private final CatServiceImpl catService;

    @GetMapping("/getFact")
    public Cat getFacts() {
        return catService.getFact();
    }
}
