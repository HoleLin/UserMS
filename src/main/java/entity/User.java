package entity;

import java.io.Serializable;

/**
 * ClassName: User
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/4/9
 */

public class User implements Serializable {
	private String userName;
	private String passWord;
	private String nickName;
	private String email;
	public User() {
	}
	public User(String userName, String passWord, String nickName, String email) {
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", nickName='" + nickName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
