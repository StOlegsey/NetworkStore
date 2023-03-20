package com.hw.networkstore.repos;

import com.hw.networkstore.model.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Integer> {

    @Query("SELECT p FROM PurchaseHistory p WHERE p.user_id = ?1")
    public List<PurchaseHistory> ListByUserId(int id);
}
