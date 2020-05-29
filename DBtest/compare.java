package DBtest;

import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.InputMismatchException;

public class compare {
	public static void chooseForCompare() throws SQLException {
		while (true) {
			try {
				inputSQL.compare("select * from notebook");
				System.out.println("(상위 메뉴로 가시려면 -1을 입력하시오)");
				System.out.print("비교할 item A의 번호를 선택하시오 --> ");
				int COUNT = Integer.parseInt(inputSQL.compare("select count(no) from notebook"));

				String a = MainForDBTest.sc.next();
				int num = Integer.parseInt(a);
				if ((num < 1 && num != -1) || num > COUNT) {
					System.out.println("없는 제품번호입니다. 다시 선택해주세요.");
				} else if (num == -1) {
					MainForDBTest.start();
				} else {
					System.out.print("비교할 item B의 번호를 선택하시오 --> ");
					String b = MainForDBTest.sc.next();
					int num2 = Integer.parseInt(b);
					if ((num2 < 1 && num2 != -1) || num2 > COUNT) {
						System.out.println("없는 제품번호입니다. 다시 선택해주세요");
						chooseForCompare();
					} else if (num2 == -1) {
						MainForDBTest.start();
						System.out.print("비교할 item B의 번호를 선택하시오 --> ");
					} else {
						System.out.println();
						System.out.println(); 

						System.out.println("###물품 비교결과###");
						inputSQL.getsql("select * from notebook where no = " + num + ";");
						inputSQL.getsql("select * from notebook where no = " + num2 + ";");
						int gram = Integer
								.parseInt(inputSQL.compare("select gram from notebook where no = " + num + ";"));
						int gram2 = Integer 
								.parseInt(inputSQL.compare("select gram from notebook where no = " + num2 + ";"));
						int display = Integer
								.parseInt(inputSQL.compare("select display from notebook where no = " + num + ";"));
						int display2 = Integer
								.parseInt(inputSQL.compare("select display from notebook where no = " + num2 + ";"));
						int size = Integer
								.parseInt(inputSQL.compare("select disksize from notebook where no = " + num + ";"));
						int size2 = Integer
								.parseInt(inputSQL.compare("select disksize from notebook where no = " + num2 + ";"));
						int price = Integer
								.parseInt(inputSQL.compare("select price from notebook where no = " + num + ";"));
						int price2 = Integer
								.parseInt(inputSQL.compare("select price from notebook where no = " + num2 + ";"));

						compareGram(gram, gram2);
						compareDisplay(display, display2);
						compareSize(size, size2);
						comparePrice(price, price2);

						System.out.println("추천 : 조건1(20점), 조건2(20점), 조건3(20점), 가격(40점)");
						String com = inputSQL.compare("select name from notebook where no = " + num + ";");
						String com2 = inputSQL.compare("select name from notebook where no = " + num2 + ";");
						String recommend = null;
						String compareFirst = compare1(gram, gram2, display, display2, size, size2, price, price2);
						String compareSecond = compare2(gram, gram2, display, display2, size, size2, price, price2);

						if (compareFirst.length() > compareSecond.length()) {
							recommend = com;
						} else if(compareFirst.length() < compareSecond.length()){
							recommend = com2;
						} else {
							recommend = "Same"; 
						}

						System.out.print(com + " : ");
						System.out.println(compareFirst);

						System.out.print(com2 + " : ");
						System.out.println(compareSecond);

						System.out.println("최종 추천 : " + recommend);
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				chooseForCompare();
			} moreCompare();
		} 
	}

	public static void moreCompare() throws SQLException {
		while (true) {
			System.out.println("더 비교하시겠습니까?(1:예, 2:아니오-상위메뉴로 이동)");
			try {
				String S = MainForDBTest.sc.next();
				int more = Integer.parseInt(S);
				if (more == 1) {
					chooseForCompare();
				} else if (more == 2) {
					MainForDBTest.start();
				} else {
					System.out.println("잘못 선택 하셨습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
	}

	public static void compareGram(int a, int b) {
		System.out.print("*무게 : ");
		if (a > b) {
			System.out.println("A < B");
		} else if (a < b) {
			System.out.println("A > B");
		} else {
			System.out.println("A = B");
		}
	}

	public static void compareDisplay(int a, int b) {
		System.out.print("*화면 : ");
		if (a > b) {
			System.out.println("A > B");
		} else if (a < b) {
			System.out.println("A < B");
		} else {
			System.out.println("A = B");
		}
	}

	public static void compareSize(int a, int b) {
		System.out.print("*디스크용량 : ");
		if (a > b) {
			System.out.println("A > B");
		} else if (a < b) {
			System.out.println("A < B");
		} else {
			System.out.println("A = B");
		}
	}

	public static void comparePrice(int a, int b) {
		System.out.print("*가격 : ");
		if (a > b) {
			System.out.println("A < B");
		} else if (a < b) {
			System.out.println("A > B");
		} else {
			System.out.println("A = B");
		}
	}

	public static String compare1(int gram, int gram2, int display, int display2, int size, int size2, int price,
			int price2) {
		int if1 = 20;
		int if2 = 20;
		int if3 = 20;
		int if4 = 40;
		if (gram < gram2 && display > display2 && size > size2 && price < price2) {
			return "조건1(" + if1 + ") + 조건2(" + if2 + ") + 조건3(" + if3 + ") + 가격(" + if4 + ") = "
					+ (if1 + if2 + if3 + if4) + "점";

		} else if (gram < gram2 && display > display2 && size > size2) {
			return "조건1(" + if1 + ") + 조건2(" + if2 + ") + 조건3(" + if3 + ") = " + (if1 + if2 + if3) + "점";

		} else if (gram < gram2 && size > size2 && price < price2) {
			return "조건1(" + if1 + ") + 조건3(" + if3 + ") + 가격(" + if4 + ") = " + (if1 + if3 + if4) + "점";

		} else if (gram < gram2 && display > display2 && price < price2) {
			return "조건1(" + if1 + ") + 조건3(" + if3 + ") + 가격(" + if4 + ") = " + (if1 + if3 + if4) + "점";

		} else if (gram < gram2 && display > display2) {
			return "조건1(" + if1 + ") + 조건2(" + if2 + ") = " + (if1 + if2) + "점";

		} else if (gram < gram2 && size > size2) {
			return "조건1(" + if1 + ") + 조건3(" + if3 + ") = " + (if1 + if3) + "점";

		} else if (gram < gram2 && price < price2) {
			return "조건1(" + if1 + ") + 가격(" + if4 + ") = " + (if1 + if4) + "점";

		} else if (gram < gram2) {
			return "조건1(" + if1 + ") = " + if1 + "점";

		} else if (display > display2 && size > size2 && price < price2) {
			return "조건2(" + if2 + ") + 조건3(" + if3 + ") + 가격(" + if4 + ") = " + (if2 + if3 + if4) + "점";

		} else if (display > display2 && size > size2) {
			return "조건2(" + if2 + ") + 조건3(" + if3 + ") = " + (if2 + if3) + "점";

		} else if (display > display2 && price < price2) {
			return "조건2(" + if2 + ") + 가격(" + if4 + ") = " + (if2 + if4) + "점";

		} else if (display > display2) {
			return "조건2(" + if3 + ") = " + if3 + "점";

		} else if (size > size2 && price < price2) {
			return "조건3(" + if3 + ") + 가격(" + if4 + ") = " + (if3 + if4) + "점";

		} else if (size > size2) {
			return "조건3(" + if3 + ") = " + if3 + "점";

		} else if (price < price2) {
			return "가격(" + if4 + ") = " + if4 + "점";

		} else {
			return "X";
		}
	}

	public static String compare2(int gram, int gram2, int display, int display2, int size, int size2, int price,
			int price2) {
		int if1 = 20;
		int if2 = 20;
		int if3 = 20;
		int if4 = 40;
		if (gram2 < gram && display2 > display && size2 > size && price2 < price) {
			return "조건1(" + if1 + ") + 조건2(" + if2 + ") + 조건3(" + if3 + ") + 가격(" + if1 + ") = "
					+ (if1 + if2 + if3 + if4) + "점";

		} else if (gram2 < gram && display2 > display && size2 > size) {
			return "조건1(" + if1 + ") + 조건2(" + if2 + ") + 조건3(" + if3 + ") = " + (if1 + if2 + if3) + "점";

		} else if (gram2 < gram && size2 > size && price2 < price) {
			return "조건1(" + if1 + ") + 조건3(" + if3 + ") + 가격(" + if1 + ") = " + (if1 + if3 + if4) + "점";

		} else if (gram2 < gram && display2 > display && price2 < price) {
			return "조건1(" + if1 + ") + 조건3(" + if3 + ") + 가격(" + if1 + ") = " + (if1 + if3 + if4) + "점";

		} else if (gram2 < gram && display2 > display) {
			return "조건1(" + if1 + ") + 조건2(" + if2 + ") = " + (if1 + if2) + "점";

		} else if (gram2 < gram && size2 > size) {
			return "조건1(" + if1 + ") + 조건3(" + if3 + ") = " + (if1 + if3) + "점";

		} else if (gram2 < gram && price2 < price) {
			return "조건1(" + if1 + ") + 가격(" + if4 + ") = " + (if1 + if4) + "점";

		} else if (gram2 < gram) {
			return "조건1(" + if1 + ") = " + if1 + "점";

		} else if (display2 > display && size2 > size && price2 < price) {
			return "조건2(" + if2 + ") + 조건3(" + if3 + ") + 가격(" + if1 + ") = " + (if2 + if3 + if4) + "점";

		} else if (display2 > display && size2 > size) {
			return "조건2(" + if2 + ") + 조건3(" + if3 + ") = " + (if2 + if3) + "점";

		} else if (display2 > display && price2 < price) {
			return "조건2(" + if2 + ") + 가격(" + if4 + ") = " + (if2 + if4) + "점";

		} else if (display2 > display) {
			return "조건2(" + if3 + ") = " + if3 + "점";

		} else if (size2 > size && price2 < price) {
			return "조건3(" + if3 + ") + 가격(" + if4 + ") = " + (if3 + if4) + "점";

		} else if (size2 > size) {
			return "조건3(" + if3 + ") = " + if3 + "점";

		} else if (price2 < price) {
			return "가격(" + if4 + ") = " + if4 + "점";

		} else {
			return "X";
		}
	}

}