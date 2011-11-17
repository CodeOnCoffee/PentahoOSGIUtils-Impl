package org.pentaho.osgi.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationAdmin;
import org.pentaho.osgi.BeanFactoryLocator;

/**
 * User: nbaker
 * Date: 12/17/10
 */
public class BeanFactoryActivator implements BundleActivator {

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    bundleContext.registerService(BeanFactoryLocator.class.getName(), new BeanFactoryLocatorImpl(), null);
    ServiceReference ref = bundleContext.getServiceReference(ConfigurationAdmin.class.getName());
    ConfigurationAdmin admin = (ConfigurationAdmin) bundleContext.getService(ref);
    new PluginDirWatcher(admin).start();
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {

  }
}
  