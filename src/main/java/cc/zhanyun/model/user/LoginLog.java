package cc.zhanyun.model.user;

public class LoginLog {
	private String oid;
	private String name;
	private String logintime;
	private String loginIP;

	protected String getOid() {
		return oid;
	}

	protected void setOid(String oid) {
		this.oid = oid;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getLogintime() {
		return logintime;
	}

	protected void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	protected String getLoginIP() {
		return loginIP;
	}

	protected void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

}
