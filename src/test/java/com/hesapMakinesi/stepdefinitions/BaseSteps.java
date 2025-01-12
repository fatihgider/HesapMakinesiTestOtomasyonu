package com.hesapMakinesi.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseSteps {
    protected final Logger logger;

    public BaseSteps() {
        this.logger = LogManager.getLogger(this.getClass());
    }
}
