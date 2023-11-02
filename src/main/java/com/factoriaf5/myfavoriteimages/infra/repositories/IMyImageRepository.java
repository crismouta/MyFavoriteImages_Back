package com.factoriaf5.myfavoriteimages.infra.repositories;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMyImageRepository extends JpaRepository <MyImage, Long> {
}
