package org.rumos.blog.model.enums;

/**
 * Enum representing roles for users in the blog application.
 */
public enum Role {
    /**
     * Administrator role.
     */
    ADMIN("admin"),

    /**
     * Regular user role.
     */
    USER("user");

    private String role;

    /**
     * Constructs a Role enum with the specified role name.
     *
     * @param role The name of the role.
     */
    Role(String role) {
        this.role = role;
    }

    /**
     * Retrieves the name of the role.
     *
     * @return The name of the role.
     */
    public String getRole() {
        return role;
    }
}

