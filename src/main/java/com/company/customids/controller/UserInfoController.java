package com.company.customids.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class UserInfoController {

    @PreAuthorize("isAuthenticated()")
    @QueryMapping("userInfo")
    public UserInfo userInfo() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return new UserInfo(username);
        }
        throw new AccessDeniedException("Unable to extract authenticated user information");
    }

    public static class UserInfo {
        private final String username;

        public UserInfo(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}
