package com.factoriaf5.myfavoriteimages.controllers;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.domain.services.MyImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/{id}")
    public ResponseEntity<MyImage> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.myImageService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<MyImage> create(@RequestParam("title") String title,
                                          @RequestParam("description") String description,
                                          @RequestParam("image") MultipartFile image) throws IOException{
        return ResponseEntity.ok(this.myImageService.create(title, description, image));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        this.myImageService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MyImage> update(@PathVariable Long id,
                                          @RequestParam("title") String title,
                                          @RequestParam("description") String description,
                                          @RequestParam("image") MultipartFile image) throws IOException {

        MyImage updatedImage = this.myImageService.update(id, title, description, image);

        return ResponseEntity.ok(updatedImage);
    }

}
