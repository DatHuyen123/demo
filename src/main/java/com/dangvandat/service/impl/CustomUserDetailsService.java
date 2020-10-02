package com.dangvandat.service.impl;

import com.dangvandat.repository.UserRepository;
import com.dangvandat.contant.SystemContant;
import com.dangvandat.dto.UserProfile;
import com.dangvandat.entity.RoleEntity;
import com.dangvandat.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userCustomService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemContant.ACTIVE_STAUTS);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity item: userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+item.getCode()));
        }
        UserProfile myUserDetail = new UserProfile(userEntity.getId(),userEntity.getFullName(),userEntity.getUserName(), userEntity.getPassWord(), true , true , true , true,authorities);
        BeanUtils.copyProperties(userEntity, myUserDetail);
        return myUserDetail;
    }
}
