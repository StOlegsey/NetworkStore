package com.hw.networkstore.repos;

import com.hw.networkstore.model.NetworkPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkPlanRepository extends JpaRepository<NetworkPlan, Long> {
}
