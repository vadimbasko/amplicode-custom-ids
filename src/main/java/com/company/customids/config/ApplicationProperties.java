package com.company.customids.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private final UsersProperties users = new UsersProperties();
    private final FrontendProperties frontend = new FrontendProperties();

    public UsersProperties getUsers() {
        return users;
    }

    public FrontendProperties getFrontend() {
        return frontend;
    }

    public static class UsersProperties {
        private final UserCredentials admin = new UserCredentials("admin", "{noop}admin");

        public UserCredentials getAdmin() {
            return admin;
        }
    }

    public static class UserCredentials {
        private String username;
        private String password;

        public UserCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public UserCredentials() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class FrontendProperties {
        private String publicUrl = "front";

        public String getPublicUrl() {
            return publicUrl;
        }

        public void setPublicUrl(String publicUrl) {
            this.publicUrl = publicUrl;
        }
    }
}
