package com.sifox.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


@Component("ajaxAuthenticationFailureHandler")
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler
{
	
	private AuthenticationFailureHandler defaultHandler;
	
	public AjaxAuthenticationFailureHandler()
	{
		
	}
	
	public AjaxAuthenticationFailureHandler(AuthenticationFailureHandler authFailureHandler)
	{
		this.defaultHandler = authFailureHandler;
	}
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,	HttpServletResponse response, AuthenticationException auth)	throws IOException, ServletException
	{
		if ("true".equals(request.getHeader("Login-Ajax-call"))) 
		{
            response.getWriter().print("LoginNotOk");
            response.getWriter().flush();
        } 
		else 
		{
            defaultHandler.onAuthenticationFailure(request, response, auth);
        }
	}

}
