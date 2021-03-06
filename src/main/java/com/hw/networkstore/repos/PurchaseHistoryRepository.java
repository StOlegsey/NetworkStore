package com.hw.networkstore.repos;

import com.hw.networkstore.model.PurchaseHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryRepository extends CrudRepository<PurchaseHistory, Long> {
}
