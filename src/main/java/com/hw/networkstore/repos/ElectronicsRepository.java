package com.hw.networkstore.repos;

import com.hw.networkstore.model.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Integer> {

}
