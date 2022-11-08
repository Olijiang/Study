package blog.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description: 请求拦截器,需要验证token的请求
 * @date: 2022/10/21 11:21
 */

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

	private final JwtUtil jwtUtil = new JwtUtil();
	// 忽略拦截的url
	private final String[] urls = {
			"/login",
			"/getCode",
			"/init",
			"/user/get",
			"/Article/getList"
	};

	// 进入controller层之前拦截请求
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		String url = request.getRequestURI();
		String token = request.getHeader("token");
		// 遍历需要忽略拦截的路径
		System.out.println(url);
		for (String item : this.urls) {
			if (item.equalsIgnoreCase(url)) {
				return true;
			}
		}
		if (url.equals("/error")){
			try{
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				ComResult res = ComResult.error("非法请求");
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
