package study04;

public class UserInfo {
	
	//default 자신패키지
	//public 전체접근
	//private class안에서사용
	
	 private String userId;
	 String userPassword;
	 String userName;
	 String userEmail;
	 String userPhone;
	 
//	 public UserInfo(String string, String string2) {
//		 userId = string;
//		 userName = string2;
//	 }
	 
	 public UserInfo(String userId, String userName) {
		 this.userId = userId;
		 this.userName = userName;
	 }

	 public UserInfo() {}

	 public UserInfo(String userId, String userName, String userEmail) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	 }
	 
	 
	 public String getUserId() {
		return userId;
	}
	 

//	 public void setUserId(String userId) {
//		this.userId = userId;
//	}

	 public String showInfo() {
		 return "고객 id"+ userId + "이고 , 등록된 이름은 " + userName + "입니다.";
	 }

	 public String getUserPassword() {
		 return userPassword;
	 }

	 public void setUserPassword(String userPassword) {
		 this.userPassword = userPassword;
	 }

	 public String getUserName() {
		 return userName;
	 }

	 public void setUserName(String userName) {
		 this.userName = userName;
	 }

	 public String getUserEmail() {
		 return userEmail;
	 }

	 public void setUserEmail(String userEmail) {
		 this.userEmail = userEmail;
	 }

	 public String getUserPhone() {
		 return userPhone;
	 }

	 public void setUserPhone(String userPhone) {
		 this.userPhone = userPhone;
	 }

	 public void setUserId(String userId) {
		 this.userId = userId;
	 }

	 @Override
	 public String toString() {
		return "UserInfo [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
	 }
	 
	 
	 
	 
	
}
