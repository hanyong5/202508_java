package study06_join;

public class MemberTest {

	public static void main(String[] args) {
		Member m1 = new StudentMember("홍길동", 15, "서울중학교");
		Member m2 = new TeacherMember("이순신", 28, "과학"); 
		
		
		m1.join();
		m1.showInfo();
		m2.join();
		m2.showInfo();
		
		System.out.println("================");
		
		StudentMember s2 = (StudentMember)m1;
		s2.study();
		
		TeacherMember t1 = (TeacherMember)m2;
		t1.teach();

	}

}
