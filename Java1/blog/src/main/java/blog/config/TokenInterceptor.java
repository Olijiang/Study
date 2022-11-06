package com.demo.yeb.config;

import com.alibaba.fastjson.JSON;
import com.demo.yeb.entity.ComResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description: 请求拦截器
 * @date: 2022/10/21 11:21
 */

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

	private final JwtUtil jwtUtil = new JwtUtil();
	// 忽略拦截的url
	private final String[] urls = {
			"/login",
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

		if (token!=null && jwtUtil.getUserFromToken(token)!=null) {
			// 可以解析出user
			return true;
		}else {
			try{
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				ComResult res = ComResult.error(401,"登录信息已失效, 请重新登录");
				PrintWriter out = response.getWriter();
				// 返回json信息给前端
				out.append(JSON.toJSONString(res)).flush();
				return false;
			} catch (Exception e){
				e.printStackTrace();
				response.sendError(500);
				return false;
			}
		}
	}

}
