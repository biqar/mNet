package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;

/**
 * Created by Bazlur Rahman Rokon on 6/28/14.
 */
@Component
public interface UserService {
    public User findUserByEmail(String email);

    public User findUserByUsername(String username) ;
}
