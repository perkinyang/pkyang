/**
 * Created with IntelliJ IDEA.
 * User: walker
 * Date: 15/8/5
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 */

package com.jbb.enterprise.app.response.common;

import com.jbb.enterprise.app.response.Response;

public class CommonObjectResponse<T> extends Response {

	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}



}
