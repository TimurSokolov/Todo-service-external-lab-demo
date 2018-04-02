package com.epam.rd.service;

import com.epam.rd.dto.User;

public interface SessionUserManager {
    
    User setCurrentSessionUser(User user);
    
    User getCurrentSessionUser();

}
