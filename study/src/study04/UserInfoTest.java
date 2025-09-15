package study04;

public class UserInfoTest {
	public static void main(String[] args) {
		UserInfo userLee = new UserInfo();
//		userLee.userId = "000011";
		userLee.userName = "홍길동";
		System.out.println(userLee.userEmail);
		System.out.println(userLee);
		
		UserInfo userHan = new UserInfo("00011","한석봉");
		UserInfo userHan1 = new UserInfo("00012","한철수","test@test.com");
		
		System.out.println(userHan.showInfo());
		System.out.println(userHan1.showInfo());
		
		System.out.println(userHan.getUserId());
		
		System.out.println(userHan1);
		
	}
}
