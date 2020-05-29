package DBtest;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class delete {
	public static void deleteColumn() throws SQLException {
		System.out.println("삭제할 정보를 입력하시오.");
		while (true) {
			try {
				System.out.println("제품명");
				String item = MainForDBTest.sc.next();

				inputSQL.delete("delete from notebook where name = '" + item + "';");

				System.out.println("삭제 완료!");
				while (true) {
					System.out.println("삭제할 것이 더 있습니까? 1.예  2.아니오");
					String choice = MainForDBTest.sc.next();
					if (choice.equals("1")) {
						System.out.println("추가 삭제할 제품명을 입력하세요.");
						break;
					} else if (choice.equals("2")) {
						System.out.println("초기화면으로 돌아갑니다.");
						MainForDBTest.start();
						break;
					} else {
						System.out.println("숫자를 입력하세요");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("다시입력하시오");
			}
		}
	}
}