/**
 * 
 */
package cc.zhanyun.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cc.zhanyun.model.user.User;
import cc.zhanyun.repository.impl.UserRepoImpl;

/**
 *  * Access Token拦截器  *
 * <p/>
 *  *  
 */
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

	/*
	 * @Autowired ValidationService validationService;
	 */
	@Autowired
	private UserRepoImpl userRepoImpl;

	private final static Logger LOG = LoggerFactory
			.getLogger(AccessTokenVerifyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOG.info("AccessToken executing ...");
		boolean flag = false;
		// 获取头部token
		String accessToken = request.getHeader("token");
		// String host = request.getHeader("Host");
		// String access = request.getHeader("Access-Control-Request-Headers");
		// Enumeration<String> name = request.getHeaderNames();
		// while (name.hasMoreElements()) {
		// String key = name.nextElement();
		// System.out.println(key + "------" + request.getHeader(key));
		// }

		System.out.println(accessToken + "----------------------------");
		if (StringUtils.isNotBlank(accessToken)) {
			// 验证
			User u = userRepoImpl.selUserByToken(accessToken);
			if (u != null) {
				// String ip = request.getRemoteAddr().toString();
				flag = true;
			}
		}
		if (!flag) {
			response.setStatus(HttpStatus.SC_FORBIDDEN);
			response.getWriter().print("AccessToken ERROR");
			System.out.println("AccessToken ERROR");
		}
		return flag;
	}
}
