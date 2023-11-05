package com.factoriaf5.myfavoriteimages.repositories;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.infra.repositories.IMyImageRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MyImageRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IMyImageRepository myImageRepository;

    @Test
    public void testSaveImage() {
        MyImage image = new MyImage("Test Image", "Description", "image_url");

        MyImage savedImage = myImageRepository.save(image);

        assertNotNull(savedImage.getId());
    }

    @Test
    public void testFindImageById() {
        MyImage image = new MyImage("Test Image", "Description", "image_url");
        entityManager.persist(image);

        Long imageId = image.getId();

        Optional<MyImage> foundImage = myImageRepository.findById(imageId);

        assertTrue(foundImage.isPresent());
        assertEquals(imageId, foundImage.get().getId());
    }

    @Test
    public void testDeleteImageById() {
        MyImage image = new MyImage("Test Image", "Description", "image_url");
        entityManager.persist(image);

        Long imageId = image.getId();

        myImageRepository.deleteById(imageId);

        Optional<MyImage> deletedImage = myImageRepository.findById(imageId);

        assertFalse(deletedImage.isPresent());
    }
}