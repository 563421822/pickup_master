package org.wangyl.pickup_master.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wangyl.pickup_master.entity.User;
import org.wangyl.pickup_master.mapper.UserMapper;
import org.wangyl.pickup_master.service.IUserService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByEmail(username);
        if (user == null) throw new UsernameNotFoundException("用户名 " + username + " 不存在");
        return new CustomUserDetails(user);
    }

    static final class CustomUserDetails extends User implements UserDetails {
        private static final List<GrantedAuthority> ROLE_USER = Collections.unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

        CustomUserDetails(User user) {
            super(user.getId(), user.getUsername(), user.getGender(), user.getEmail(), user.getPassword(), user.getAvatar(), user.getBirthday(), user.getCreateTime(), user.getUpdateTime(), user.getStatus());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return ROLE_USER;
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
