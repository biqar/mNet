package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.User;

/**
 * Created by bazlur on 7/3/14.
 */
public interface UserService {
    public void create(User user);

    public User findByUserName(String username);

    public User findById(Long id);
}
