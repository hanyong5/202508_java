package study06_join;

public class Member {
	String name;
	int age;
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + name + ", 나이 : " +age);
	}
	
	public void join() {
		System.out.println(name + "님, 회원가입이 완료 되었습니다.");
	}
}
