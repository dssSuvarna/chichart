package com.activ8.chichart.api.service;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.domain.entity.*;
import com.activ8.chichart.domain.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.EntityNotFoundException;


@Service
@Transactional
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    private final UserSubscriptionRepository userSubscriptionRepository;

    @Autowired
    public UserSubscriptionServiceImpl(UserSubscriptionRepository userSubscriptionRepository) {
        this.userSubscriptionRepository = userSubscriptionRepository;
    }

    @Override
    public UserSubscription getByUserKey(String userKey) {
        UserSubscription userSubscription = userSubscriptionRepository.findFirstByUserKeyOrderByIdDesc(userKey);
        if (userSubscription != null) {
            return userSubscription;
        } else {
            return null;
        }

    }

    @Override
    public UserSubscription create(CreateUserSubscriptionCommand command) {
        UserSubscription userSubscription = UserSubscription.builder()
                .userKey(command.getUserKey())
                .dateOfCommencement(command.getDateOfCommencement())
                .dateOfExpiry(command.getDateOfExpiry())
                .transactionReceipt(command.getTransactionReceipt())
                .productIdentifier(command.getProductIdentifier())
                .dataSignature(command.getDataSignature())
                .transactionIdentifier(command.getTransactionIdentifier())
                .transactionDate(command.getTransactionDate())
                .build();
        return userSubscriptionRepository.saveAndFlush(userSubscription);
    }

    @Override
    public UserSubscription update(UpdateUserSubscriptionCommand command) {
        UserSubscription userSubscription = getByUserKey(command.getUserKey());

        userSubscription.setDateOfCommencement(command.getDateOfCommencement());
        userSubscription.setDateOfExpiry(command.getDateOfExpiry());
        userSubscription.setTransactionReceipt(command.getTransactionReceipt());
        userSubscription.setProductIdentifier(command.getProductIdentifier());
        userSubscription.setDataSignature(command.getDataSignature());
        userSubscription.setTransactionIdentifier(command.getTransactionIdentifier());
        userSubscription.setTransactionDate(command.getTransactionDate());

        return userSubscriptionRepository.saveAndFlush(userSubscription);
    }

}
