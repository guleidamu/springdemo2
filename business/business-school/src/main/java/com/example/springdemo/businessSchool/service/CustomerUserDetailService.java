//package com.example.springdemo.businessSchool.service;
//
//import com.example.springdemo.businessSchool.data.vo.UserPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerUserDetailService implements UserDetailsService{
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        UserPrincipal userPrincipal = new UserPrincipal();
//        userPrincipal.setUsername("c0818test");
////        BeanUtil.copyProperties(userInfo,userPrincipal);
////        userPrincipal.setRoles(roleDao.findRoleListByUserId(userInfo.getId()));
//        return userPrincipal;
//    }
//}
