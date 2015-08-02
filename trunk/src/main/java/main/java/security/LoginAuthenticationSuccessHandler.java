package main.java.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {
	private static Logger log = LoggerFactory
			.getLogger(LoginAuthenticationSuccessHandler.class);

	// ��¼��֤�ɹ�����Ҫ��ת��url
	private String url;

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("��¼��֤�ɹ���" + request.getContextPath() + url);
		// response.sendRedirect(request.getContextPath()+url);
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
