package com.factoriaf5.myfavoriteimages.controllers;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.domain.services.MyImageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application.properties")
@AutoConfigureMockMvc
public class MyImageControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyImageService myImageService;


    @Test
    public void testGetAllImages() throws Exception {
        List<MyImage> images = new ArrayList<>();
        when(myImageService.findAll()).thenReturn(images);

        mockMvc.perform(get("/api/v1/images"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGetImageById() throws Exception {
        Long id = 1L;

        MyImage image = new MyImage();
        image.setId(id);
        image.setTitle("Test Image");
        image.setDescription("Test Description");
        image.setImage("https://example.com/test-image.jpg");

        when(myImageService.findById(id)).thenReturn(image);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/images/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(image.getId().intValue())))
                .andExpect(jsonPath("$.title", is(image.getTitle())))
                .andExpect(jsonPath("$.description", is(image.getDescription())))
                .andExpect(jsonPath("$.image", is(image.getImage())));

    }

    @Test
    public void testDeleteImageById() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/api/v1/images/{id}", id))
                .andExpect(status().isOk());
    }

}
