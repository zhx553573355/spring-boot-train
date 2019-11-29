package com.zx.hls.dao;

import com.zx.hls.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 用户
 */
public interface SysUserRepo extends JpaRepository<SysUser, Integer> {
    public SysUser findByUserNameAndEncryptedUserPassword(String userName,String encryptedUserPassword);
}
