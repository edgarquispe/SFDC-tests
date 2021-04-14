package org.example.sfdc.pages;

import org.example.core.Env;

public final class SFDCEnvironment {

    private SFDCEnvironment() {
    }

    public static Experience getExperience() {
        return Experience.valueOf(Env.getInstance().getExperience().toUpperCase());
    }

    public static boolean isLightningExperience() {
        return Experience.valueOf(Env.getInstance().getExperience().toUpperCase()).equals(Experience.LIGHTNING);
    }
}
