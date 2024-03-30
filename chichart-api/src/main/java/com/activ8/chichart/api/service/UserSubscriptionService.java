package com.activ8.chichart.api.service;

import com.activ8.chichart.api.command.*;
import com.activ8.chichart.domain.entity.*;

public interface UserSubscriptionService {
    UserSubscription getByUserKey(String userKey);
    UserSubscription create(CreateUserSubscriptionCommand command);
    UserSubscription update(UpdateUserSubscriptionCommand command);
}
