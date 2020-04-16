package common;

public class MessageVO {
	String id;
	String cmd;
	String msg;
	
	
	public String getCmd() {
		return cmd;
	}


	public void setCmd(String cmd) {
		this.cmd = cmd;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "MessageVO [id=" + id + ", cmd=" + cmd + ", msg=" + msg + "]";
	}


	
}
