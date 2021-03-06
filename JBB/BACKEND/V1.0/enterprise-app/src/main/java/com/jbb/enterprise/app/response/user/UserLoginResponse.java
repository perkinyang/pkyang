/**
 * Created with IntelliJ IDEA.
 * User: walker
 * Date: 15/8/5
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 */
package com.jbb.enterprise.app.response.user;

import com.jbb.enterprise.app.response.Response;
import com.jbb.user.api.dto.UserDTO;
import com.jbb.user.api.dto.UserLoginDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;


public class UserLoginResponse extends Response{

	private UserLoginDTO userLogin;
	
	private UserDTO userDTO;

	@ApiModelProperty(value = "用戶登錄相关信息")
	public UserLoginDTO getUserLogin() {
		return userLogin;
	}
	@ApiModelProperty(value = "用戶登錄相关信息")
	public void setUserLogin(UserLoginDTO userLogin) {
		this.userLogin = userLogin;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
}
