package com.factoriaf5.myfavoriteimages.infra.repositories;

import com.factoriaf5.myfavoriteimages.domain.models.MyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyImageRepository extends JpaRepository <MyImage, Long> {
}
