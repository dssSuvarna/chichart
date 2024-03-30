package com.activ8.chichart.core;

import com.activ8.chichart.core.service.*;

public class AbstractUnitTest {
    protected DataService getDataService() {
        return ServiceFactory.getInstance().getDataService();
    }
}
