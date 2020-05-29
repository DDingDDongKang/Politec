package DBtest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MainForDBTest {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		start(); 
	}
 
	public static void start() throws SQLException {
		while (true) {
				System.out.println("###메뉴###");
				System.out.println("1. 물품 비교하기");
				System.out.println("2. 물품 수정하기");
				System.out.println("3. 물품 입력하기");
				System.out.println("4. 물품 삭제하기");
				System.out.println("원하시는 메뉴를 선택하세요(0은 초기 메뉴)");
 
				String a = sc.next();
				if (a.equals("1")) {
					compare.chooseForCompare();
					break;
				} else if (a.equals("2")) {
					updateAndAdd.updateColumn();
					break; 
				} else if (a.equals("3")) {	
					updateAndAdd.add();
					break;
				} else if (a.equals("4")) {
					delete.deleteColumn();
				} else {
					System.out.println("ERROR! Select Again!");
					System.out.println();
					start();
				}
		}
	}
}
