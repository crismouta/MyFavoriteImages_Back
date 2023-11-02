package com.factoriaf5.myfavoriteimages.domain.services;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.infra.repositories.IMyImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyImageService {

    private final IMyImageRepository myImageRepository;

    public MyImageService(IMyImageRepository myImageRepository) {
        this.myImageRepository = myImageRepository;
    }

    public List<MyImage> findAll() {
        return this.myImageRepository.findAll();
    }

    public MyImage findById(Long id) {
        var optionalCharacter = this.myImageRepository.findById(id);
        if(optionalCharacter.isEmpty()) throw new RuntimeException("La imagen con id: " + id + " no existe");
        return optionalCharacter.get();
    }

    public MyImage create(MyImage image) {
        return this.myImageRepository.save(image);
    }

    public void delete(Long id) {
        this.myImageRepository.deleteById(id);
    }

    public MyImage update(Long id, MyImage updatedImage) {
        MyImage existingImage = this.findById(id);

        existingImage.setTitle(updatedImage.getTitle());
        existingImage.setDescription(updatedImage.getDescription());
        existingImage.setImage(updatedImage.getImage());

        return myImageRepository.save(existingImage);
    }
}
