package org.pentaho.osgi.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.pentaho.osgi.BeanFactoryLocator;

/**
 * User: nbaker
 * Date: 12/17/10
 */
public class BeanFactoryActivator implements BundleActivator {

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    bundleContext.registerService(BeanFactoryLocator.class.getName(), new BeanFactoryLocatorImpl(), null);
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {

  }
}
