package com.factoriaf5.myfavoriteimages.domain.services;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.infra.repositories.IMyImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MyImageService {

    @Autowired
    private IMyImageRepository myImageRepository;
    @Autowired
    private CloudinaryImageService cloudinaryImageService;

    public MyImageService(IMyImageRepository myImageRepository, CloudinaryImageService cloudinaryImageService) {
        this.myImageRepository = myImageRepository;
        this.cloudinaryImageService = cloudinaryImageService;
    }

    public List<MyImage> findAll() {
        return this.myImageRepository.findAll();
    }

    public MyImage findById(Long id) {
        var optionalCharacter = this.myImageRepository.findById(id);
        if(optionalCharacter.isEmpty()) throw new RuntimeException("La imagen con id: " + id + " no existe");
        return optionalCharacter.get();
    }

    public MyImage create(String title, String description, MultipartFile image) throws IOException {
        String imageUrl = (String) cloudinaryImageService.upload(image).get("url");

        MyImage project = new MyImage(title, description, imageUrl);
        return myImageRepository.save(project);
    }

    public void delete(Long id) {
        this.myImageRepository.deleteById(id);
    }

    public MyImage update(Long id, String title, String description, MultipartFile image) throws IOException {
        MyImage existingImage = this.findById(id);

        if (existingImage != null) {
            String imageUrl = (String) cloudinaryImageService.upload(image).get("url");

            existingImage.setTitle(title);
            existingImage.setDescription(description);
            existingImage.setImage(imageUrl);

            return myImageRepository.save(existingImage);
        }
        return null;
    }
}
