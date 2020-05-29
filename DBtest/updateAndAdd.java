package DBtest;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class updateAndAdd {
	public static void add() throws SQLException {
		while(true) {
			try {
				System.out.println("추가할 물품의 정보를 입력하시오.");
				
				System.out.print("제품명 : ");
				String name = MainForDBTest.sc.next();
				
				System.out.print("무게(g) : ");
				String gram = MainForDBTest.sc.next();
				int realGram = Integer.parseInt(gram);
				
				
				System.out.print("화면(인치) : ");
				String display = MainForDBTest.sc.next();
				int realDispaly = Integer.parseInt(display);
				
				System.out.print("디스크용량(기가바이트) : ");
				String diskSize = MainForDBTest.sc.next();
				int realDiskSize = Integer.parseInt(diskSize);
				
				System.out.print("비고(없을시 na입력) : ");
				String etc = MainForDBTest.sc.next();
				
				System.out.print("가격(만원) : ");
				String price = MainForDBTest.sc.next();
				int realPrice = Integer.parseInt(price);
				
				inputSQL.insert("notebook", "insert into notebook(name, gram, display, disksize, etc, price) values('"
						+ name + "', " + realGram + ", " + realDispaly + ", " + realDiskSize + ", '" + etc + "', " + realPrice + ");");
				System.out.println("추가 완료. 초기화면으로 돌아갑니다.");
				System.out.println();

				MainForDBTest.start();
			} catch (InputMismatchException e) {
				System.out.println("에러! 다시 입력해주세요.");
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	public static void updateColumn() throws SQLException {
		while (true) {
			try {
				System.out.println("물품의 이름과 수정할 정보를 입력하세요.");
				System.out.print("변경할 제품명 : ");
				String name = MainForDBTest.sc.next(); // 제품이름
				System.out.print("변경할 제품의 정보(name, gram, display, disksize, etc, parice) : ");
				String columnName = MainForDBTest.sc.next(); // 컬럼명
				System.out.print("변경상세정보 : ");
				String inform = MainForDBTest.sc.next(); // 변경 상세정보입력하는곳

				if (columnName.equals("gram") || columnName.equals("display") || columnName.equals("distsize")
						|| columnName.equals("price")) {
					int information = Integer.parseInt(inform);
					inputSQL.update("update notebook set " + columnName + " = " + information + " where name = '" + name
							+ "';");
					System.out.println("수정 완료. 처음 화면으로 돌아갑니다.");
					System.out.println();
					MainForDBTest.start();
				} else if (columnName.equals("name") || columnName.equals("etc")) {
					inputSQL.update(
							"update notebook set " + columnName + " = '" + inform + "' where name = '" + name + "';");
					System.out.println("수정 완료. 처음 화면으로 돌아갑니다.");
					System.out.println();
					MainForDBTest.start();
				} else {
					System.out.println("에러! 다시 입력해주세요.");
				}

			} catch (NumberFormatException e) {
				System.out.println("에러! 다시 입력해주세요.");
			}
		} 
	}
}
