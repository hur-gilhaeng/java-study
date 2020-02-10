package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	public Person(){
		this.age = 12;
		this.name = "";
		numberOfPerson++;
	}
	
	public Person( String name ){
		this.age = 12;
		this.name = name;
		numberOfPerson++;
	}
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void selfIntroduce(){
		// "내 이름은 ...이며, 나이는 ...살입니다." 출력함
		// 예) 내이름은 김철수이며, 나이는 19살 입니다.
		String s = String.format("내 이름은 %s 이며, 나이는 %d살 입니다.", name, age);
		System.out.println(s);
	}

	static int getPopulation(){
		// 전체 인구수를 return 함
		return numberOfPerson;
	}
}

