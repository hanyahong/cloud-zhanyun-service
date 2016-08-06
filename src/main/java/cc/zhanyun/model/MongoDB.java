package cc.zhanyun.model;

public class MongoDB {
	private String ip = "";

	private String port = "";

	private String defaultDB = "admin";

	private String defaultCol = "";

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDefaultDB() {
		return defaultDB;
	}

	public void setDefaultDB(String defaultDB) {
		this.defaultDB = defaultDB;
	}

	public String getDefaultCol() {
		return defaultCol;
	}

	public void setDefaultCol(String defaultCol) {
		this.defaultCol = defaultCol;
	}

}
