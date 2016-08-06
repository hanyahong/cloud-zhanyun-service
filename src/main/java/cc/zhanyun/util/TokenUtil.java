package cc.zhanyun.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.user.User;
import cc.zhanyun.repository.impl.UserRepoImpl;

@Repository
public class TokenUtil {

	@Autowired
	private UserRepoImpl userRepo;

	@Autowired
	private HttpServletRequest request;

	public String tokenToOid() {

		// String token = request.getHeader("sessionToken");
		String token = "111222";
		User u = userRepo.selUserByToken(token);
		return u.getOid();
	}

}
