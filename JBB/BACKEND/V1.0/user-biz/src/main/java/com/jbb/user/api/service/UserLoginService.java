package com.jbb.user.api.service;

import com.jbb.user.api.dto.UserLoginDTO;
import com.jbb.user.biz.entity.ExpertLogin;

public interface UserLoginService {
	
	public UserLoginDTO findByUserId(Long userId);

    public UserLoginDTO findByLoginName(String loginName);

    public void updateToken(Long userId,String token);

    public void update(UserLoginDTO userLogin);

    public String getRegistAuthCode(String telephone);
    
    public UserLoginDTO register(String telephone,String authCode);

    public void setPwd(String telephone,String userName,String password);

    public UserLoginDTO findByTelephone(String telephone);

    public UserLoginDTO login(String telephone,String password);

    public void updatePwd(String telephone,String password);

	public ExpertLogin login(String telephone, String passwd, boolean b);
    
    
}
