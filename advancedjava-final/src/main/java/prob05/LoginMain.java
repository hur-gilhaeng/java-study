package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LoginMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add( new User( "john", "1234") );
		
		System.out.println("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.println("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();
		
		/* 로그인 처리 부분을 완성 합니다. */
		try {
			User initUser = new User( id, password );
			
			login(joinUsers, initUser);
			
		}catch(UserNotFoundException e1) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		}catch(PasswordDismatchException e2) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}finally {
			scanner.close();
		}
		System.out.println("로그인 성공");
		
	}
	
	public static void login(List<User> users, User user ) throws UserNotFoundException, PasswordDismatchException {
		if( !users.contains(user) ){
			throw new UserNotFoundException();
		}
		
		User savedUser = users.get( users.indexOf( user ) );
		
		if( !savedUser.getPassword().equals( user.getPassword()) ){
			throw new PasswordDismatchException();
		}
	}
}
