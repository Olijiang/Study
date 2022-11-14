package blog.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/11/6 15:26
 */
@Api("验证码")
@RestController
public class KaptchaController {
	@Autowired
	private DefaultKaptcha captchaProducer;

	@ApiOperation("获取验证码")
	@GetMapping("/getCode")
	public void defaultKaptcha(HttpSession session, HttpServletResponse httpServletResponse) throws Exception {
		byte[] captchaOutputStream;
		ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
		try {
			//生产验证码字符串并保存到session中
			String verifyCode = captchaProducer.createText();
			session.setAttribute("verifyCode", verifyCode);
			java.awt.image.BufferedImage challenge = captchaProducer.createImage(verifyCode);
			ImageIO.write(challenge, "jpg", imgOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		captchaOutputStream = imgOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaOutputStream);
		responseOutputStream.flush();
		responseOutputStream.close();
	}
}
