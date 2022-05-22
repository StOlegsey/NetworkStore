package com.hw.networkstore.repos;

import com.hw.networkstore.model.Electronics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicsRepository extends CrudRepository<Electronics, Long> {
}
