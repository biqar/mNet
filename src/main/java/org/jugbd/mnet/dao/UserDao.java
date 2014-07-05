package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Component
public interface UserDao extends CrudDao<User, Long> {
    public User findByUsername(String username);
}
