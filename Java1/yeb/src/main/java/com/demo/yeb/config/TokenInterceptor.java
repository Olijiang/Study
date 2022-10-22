package com.snion.common;

import com.alibaba.fastjson.JSON;
import com.snion.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// 忽略拦截的url
	private final String[] urls = {
			"/login",
			"/register",
			"/"
	};
	// 进入controller层之前拦截请求
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		String url = request.getRequestURI();
		String token = request.getHeader("token");

		// 遍历需要忽略拦截的路径
		for (String item : this.urls) {
			if (item.equals(url)) {
				return true;
			}
		}

		if (token!=null && jwtTokenUtil.getUserFromToken(token)!=null) {
			// 可以解析出user
			return true;
		}else {
			try{
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = null ;
				Result res = new Result().error(401,"登录信息已失效, 请重新登录");
				String json = JSON.toJSONString(res);
				response.setContentType("application/json");
				out = response.getWriter();
				// 返回json信息给前端
				out.append(json);
				out.flush();
				return false;
			} catch (Exception e){
				e.printStackTrace();
				response.sendError(500);
				return false;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
		// System.out.println("处理请求完成后视图渲染之前的处理操作");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
		// System.out.println("视图渲染之后的操作");
	}

}
