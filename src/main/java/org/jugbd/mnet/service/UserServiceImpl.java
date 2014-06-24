package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by Bazlur Rahman Rokon on 6/28/14.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
