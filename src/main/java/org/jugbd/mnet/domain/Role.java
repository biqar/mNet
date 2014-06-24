package org.jugbd.mnet.domain;

/**
 * Created by Bazlur Rahman Rokon on 6/28/14.
 */
public enum Role {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    private String naturalName;

    Role(String name) {
        this.naturalName = name;
    }

    @Override
    public String toString() {
        return this.naturalName;
    }
}
