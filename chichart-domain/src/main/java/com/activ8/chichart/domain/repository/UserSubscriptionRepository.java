package com.activ8.chichart.domain.repository;

import com.activ8.chichart.domain.entity.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    UserSubscription findFirstByUserKeyOrderByIdDesc(String userKey);
}
