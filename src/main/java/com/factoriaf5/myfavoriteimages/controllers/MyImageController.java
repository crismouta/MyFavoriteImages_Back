package com.factoriaf5.myfavoriteimages.controllers;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.domain.services.MyImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/images")
public class MyImageController {

    private final MyImageService myImageService;

    public MyImageController(MyImageService myImageService) {
        this.myImageService = myImageService;
    }

    @GetMapping
    public ResponseEntity<List<MyImage>> getAll(){
        return ResponseEntity.ok(this.myImageService.findAll());
    }
}
