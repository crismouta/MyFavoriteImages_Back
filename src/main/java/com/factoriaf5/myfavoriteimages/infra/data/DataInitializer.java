package com.factoriaf5.myfavoriteimages.infra.data;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.infra.repositories.IMyImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private IMyImageRepository myImageRepository;

    @Override
    public void run(String... args) throws Exception {
        MyImage image1 = new MyImage();
        image1.setTitle("Image 1");
        image1.setDescription("Description 1");
        image1.setImage("https://picsum.photos/200");
        myImageRepository.save(image1);

        MyImage image2 = new MyImage();
        image2.setTitle("Image 2");
        image2.setDescription("Description 2");
        image2.setImage("https://picsum.photos/200");
        myImageRepository.save(image2);

        MyImage image3 = new MyImage();
        image3.setTitle("Image 3");
        image3.setDescription("Description 3");
        image3.setImage("https://picsum.photos/200");
        myImageRepository.save(image3);
    }
}
