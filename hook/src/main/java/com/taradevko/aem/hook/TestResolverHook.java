package com.taradevko.aem.hook;

import org.osgi.framework.hooks.resolver.ResolverHook;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleRevision;

import java.util.*;

public class TestResolverHook implements ResolverHook {

    private static final Map<String, List<String>> restictions = new HashMap<>();

    static {
        restictions.put("org.apache.abdera.parser", Arrays.asList("org.apache.abdera.server", "org.apache.abdera.client"));
    }

    @Override
    public void filterResolvable(Collection<BundleRevision> candidates) {

    }

    @Override
    public void filterSingletonCollisions(BundleCapability singleton, Collection<BundleCapability> collisionCandidates) {

    }

    public void filterMatches(BundleRequirement requirement, Collection<BundleCapability> candidates) {
        candidates.removeIf(candidate -> {

            final String candidateName = candidate.getRevision().getSymbolicName();
            final String requirementName = requirement.getRevision().getSymbolicName();

            final List<String> allowedList = restictions.get(candidateName);
            return allowedList != null && !allowedList.contains(requirementName);
        });
    }

    @Override
    public void end() {

    }
}
