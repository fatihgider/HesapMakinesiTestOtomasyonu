package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {
    protected final Logger logger;

    public BasePage() {
        this.logger = LogManager.getLogger(this.getClass());
    }
}
