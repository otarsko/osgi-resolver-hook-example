package com.taradevko.aem.hook;

import org.osgi.framework.hooks.resolver.ResolverHook;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;
import org.osgi.framework.wiring.BundleRevision;
import org.apache.felix.scr.annotations.*;

import java.util.Collection;

@Component(immediate = true)
@Service(value = ResolverHookFactory.class)
public class TestHooksFactory implements ResolverHookFactory {

    public ResolverHook begin(Collection<BundleRevision> triggers) {
        return new TestResolverHook();
    }
}
