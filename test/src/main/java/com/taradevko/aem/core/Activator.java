package com.taradevko.aem.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private static final Logger LOG = LoggerFactory.getLogger(Activator.class);

    @Override
    public void start(final BundleContext context) throws Exception {
        LOG.info("Test bundle started");
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        LOG.info("Test bundle stopped");
    }
}
