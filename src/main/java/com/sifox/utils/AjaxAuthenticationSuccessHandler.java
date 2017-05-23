package com.sifox.utils;

import com.sifox.entity.User;
import com.sifox.service.ShameDeskService;
import com.sifox.service.SecurityService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Component("ajaxAuthenticationSuccessHandler")
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler 
{
	@Autowired
	SecurityService securityService;
	
	@Autowired
	ShameDeskService deskService;
	
	private AuthenticationSuccessHandler defaultHandler;
	
	public AjaxAuthenticationSuccessHandler() {
	}
	
	public AjaxAuthenticationSuccessHandler(AuthenticationSuccessHandler authSuccessHandler) {
		this.defaultHandler = authSuccessHandler;
	}
	
	@Override
//    @Transactional
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException
	{
		if ("true".equals(request.getHeader("Login-Ajax-call"))) 
		{
            User user = securityService.getCurrentUser();
//            List<User> userList = deskService.nameList();
//            JSONArray jArray = new JSONArray();
//            for(WalletEntity wallet : wallets)
//            {
//            	JSONObject jObject = new JSONObject();
//            	jObject.put("object", "account");
//            	jObject.put("id", wallet.getId());
//            	jObject.put("name", wallet.getWalletName());
//            	jObject.put("currency", wallet.getCurrencyName());
//            	jObject.put("isDefault", wallet.isDefault());
//            	jArray.put(jObject);
//            }
                       
            response.setContentType("application/json");
//            response.getWriter().print(jArray);
            response.getWriter().flush();
        } 
		else 
		{
            defaultHandler.onAuthenticationSuccess(request, response, auth);
        }
	}

}
