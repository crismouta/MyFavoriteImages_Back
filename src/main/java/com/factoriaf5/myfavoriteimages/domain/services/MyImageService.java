package com.factoriaf5.myfavoriteimages.domain.services;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import com.factoriaf5.myfavoriteimages.infra.repositories.IMyImageRepository;
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
}
