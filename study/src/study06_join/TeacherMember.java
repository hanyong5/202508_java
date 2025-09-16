package study06_join;

public class TeacherMember extends Member {
	String subject;
	
	public TeacherMember(String name, int age,String subject) {
		super(name, age);
		this.subject = subject;
	}

	@Override
	public void join() {
		System.out.println("[교사회원]" +name + "님, 과목( "+subject+" )정보와 함께 가입되었습니다.");
	}
	
	public void teach() {
		System.out.println(name+"님이 " + subject+ " 수업을 시작합니다.");
	}
	
	

	
	
	
	
	

}
