package com.activ8.chichart.api.rest.converter;

import com.activ8.chichart.api.rest.resource.UserSubscriptionResource;
import com.activ8.chichart.domain.entity.UserSubscription;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserSubscriptionToResourceConverter implements Converter<UserSubscription, UserSubscriptionResource> {

    @Override
    public UserSubscriptionResource convert(UserSubscription source) {
        return UserSubscriptionResource.builder()
                .userKey(source.getUserKey())
                .dateOfCommencement(source.getDateOfCommencement())
                .dateOfExpiry(source.getDateOfExpiry())
                .transactionReceipt(source.getTransactionReceipt())
                .productIdentifier(source.getProductIdentifier())
                .dataSignature(source.getDataSignature())
                .transactionIdentifier(source.getTransactionIdentifier())
                .transactionDate(source.getTransactionDate())
                .build();
    }
}
