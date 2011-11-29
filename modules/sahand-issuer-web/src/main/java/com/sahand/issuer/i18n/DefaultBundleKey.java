package com.sahand.issuer.i18n;

import org.jboss.seam.international.status.builder.BundleKey;

public class DefaultBundleKey extends BundleKey {

    public static final String DEFAULT_BUNDLE_NAME = "messages";

    public DefaultBundleKey(String key) {
        super(DEFAULT_BUNDLE_NAME, key);
    }
}
