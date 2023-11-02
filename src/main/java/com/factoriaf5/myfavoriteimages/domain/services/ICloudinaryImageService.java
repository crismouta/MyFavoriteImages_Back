package com.factoriaf5.myfavoriteimages.domain.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ICloudinaryImageService {
    Map upload(MultipartFile file);
}
