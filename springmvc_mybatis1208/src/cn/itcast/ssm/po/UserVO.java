package cn.itcast.ssm.po;

public class UserVO {
	//此类是为了系统可扩展性，对原始生成的po进行扩展
	private User user;
	private UserVO userVO;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

}
