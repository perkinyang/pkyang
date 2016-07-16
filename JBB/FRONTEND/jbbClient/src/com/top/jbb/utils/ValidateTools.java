package com.top.jbb.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTools {

	/**
     * 正则表达式：验证密码
     */
	public static boolean isPasswd(String str){
	    if(str==null || str.length()==0){
	    	return false;
	    }
		
		String regex = "^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$";
		int len=str.length();
		return (len>=6 && len<=15 && match(regex, str));
	}
	
	// 验证手机号
	public static boolean isMobileNO(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		Pattern p = Pattern.compile("^((1[0-9][0-9]))\\d{8}$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	// 判断邮箱是否合法
	public static boolean isEmail(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(str);
		return m.matches();
	}

	// 是不是数字
	public static boolean IsNumber(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "^[0-9]*$";
		return match(regex, str);
	}
	
	/**
	* 验证输入身份证号
	* 
	* @param 待验证的字符串
	* @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	*/
	public static boolean IsIDcard(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "(^\\d{18}$)|(^\\d{15}$)";
	return match(regex, str);
	}
	
	//是否为正确短信验证码
	public static boolean isSmsCode(String str) {
		if(str==null || str.length()==0 || str.length()!=6){
	    	return false;
	    }
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, str);
	}
	
	//是否为正确邀请码
	public static boolean isInvitationCode(String str) {
		if(str==null || str.length()==0 || str.length()!=6){
		    return false;
		   }
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, str);
	}
	

	/**
	 * 验证非零的正整数
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsIntNumber(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, str);
	}

	/**
	 * 验证大写字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsUpChar(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "^[A-Z]+$";
		return match(regex, str);
	}

	/**
	 * 验证小写字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsLowChar(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "^[a-z]+$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsLetter(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "^[A-Za-z]+$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入汉字
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsChinese(String str) {
		if(str==null || str.length()==0){
	    	return false;
	    }
		String regex = "^[\u4e00-\u9fa5],{0,}$";
		return match(regex, str);
	}

	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
