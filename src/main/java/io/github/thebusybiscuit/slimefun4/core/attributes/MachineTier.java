package io.github.thebusybiscuit.slimefun4.core.attributes;

import javax.annotation.Nonnull;

public enum MachineTier {

    BASIC("&e기본"),
    AVERAGE("&6평균"),
    MEDIUM("&a중간"),
    GOOD("&2좋음"),
    ADVANCED("&6고급"),
    END_GAME("&4최종");

    private final String prefix;

    MachineTier(@Nonnull String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix;
    }

}
