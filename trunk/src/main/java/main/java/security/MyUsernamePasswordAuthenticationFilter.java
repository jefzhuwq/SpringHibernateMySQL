package main.java.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.dao.IUserDAO;
import main.java.model.User;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	public static final String VALIDATE_CODE = "validateCode";  
    public static final String USERNAME = "username";  
    public static final String PASSWORD = "password";  
      
    private IUserDAO usersDao;  
    public IUserDAO getUserDao() {  
        return usersDao;  
    }  
    public void setUsersDao(IUserDAO usersDao) {  
        this.usersDao = usersDao;  
    }  
  
    @Override  
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {  
        if (!request.getMethod().equals("POST")) {  
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());  
        }  
        //�����֤��  
        checkValidateCode(request);  
          
        String username = obtainUsername(request);  
        String password = obtainPassword(request);  
          
        //��֤�û��˺��������Ƿ��Ӧ  
        username = username.trim();  
          
        User user = this.usersDao.findByName(username);  
          
        if(user == null || !user.getPassword().equals(password)) {  
    /* 
              ���������õ�simpleUrlAuthenticationFailureHandler�����¼ʧ�ܵĴ���������ôһ�� 
        �������ǿ����ڵ�¼ʧ�ܺ����û��ṩ��Ӧ����Ϣ�� 
        if (forwardToDestination) { 
            request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception); 
        } else { 
            HttpSession session = request.getSession(false); 
 
            if (session != null || allowSessionCreation) { 
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception); 
            } 
        } 
     */  
            throw new AuthenticationServiceException("�û��������������");   
        }  
          
        //UsernamePasswordAuthenticationTokenʵ�� Authentication  
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);  
        // Place the last username attempted into HttpSession for views  
          
        // ��������������ϸ����  
        setDetails(request, authRequest);  
          
        // ����UserDetailsService��loadUserByUsername �ٴη�װAuthentication  
        return this.getAuthenticationManager().authenticate(authRequest);  
    }  
      
    protected void checkValidateCode(HttpServletRequest request) {   
        HttpSession session = request.getSession();  
          
        String sessionValidateCode = obtainSessionValidateCode(session);   
        //����һ�ε���֤��ʧЧ  
        session.setAttribute(VALIDATE_CODE, null);  
        String validateCodeParameter = obtainValidateCodeParameter(request);    
        if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {    
            throw new AuthenticationServiceException("��֤�����");    
        }    
    }  
      
    private String obtainValidateCodeParameter(HttpServletRequest request) {  
        Object obj = request.getParameter(VALIDATE_CODE);  
        return null == obj ? "" : obj.toString();  
    }  
  
    protected String obtainSessionValidateCode(HttpSession session) {  
        Object obj = session.getAttribute(VALIDATE_CODE);  
        return null == obj ? "" : obj.toString();  
    }  
  
    @Override  
    protected String obtainUsername(HttpServletRequest request) {  
        Object obj = request.getParameter(USERNAME);  
        return null == obj ? "" : obj.toString();  
    }  
  
    @Override  
    protected String obtainPassword(HttpServletRequest request) {  
        Object obj = request.getParameter(PASSWORD);  
        return null == obj ? "" : obj.toString();  
    }  
}
