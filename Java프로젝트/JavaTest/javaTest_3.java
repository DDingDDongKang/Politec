package JavaTest;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class javaTest_3 {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// 3번
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy", Locale.ENGLISH); // 파일에 들어있는 last_login_date가 이런 형식으로
																					// 돼있기 때문에 비교를 위해 포맷을 이와같이 정함.

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("C:\\Users\\401-ST05\\Desktop\\last_login.csv")); // 저장할 위치와 이름 설정//
																										// 저장할 파일의 경로와
			List<List<String>> chosenData = readCSV.ReadCSV(); // 이름 정하기
			Comparator<List<String>> com = new Comparator<List<String>>() { // 날짜를 비교하는 comparator class 생성
				@Override
				public int compare(List<String> a, List<String> b) { // 리스트 두개를 비교하는 것
					String[] A = a.get(5).split("/"); // last_login_date를 받아서 "/"기준으로 잘라서 배열로 넣는다.
					String[] B = b.get(5).split("/"); // last_login_date를 받아서 "/"기준으로 잘라서 배열로 넣는다.
					if(!(a.get(5).equals("last_login_date")) && !(b.get(5).equals("last_login_date"))) {
					if (Integer.parseInt(A[2]) > Integer.parseInt(B[2])) { // 모두 String값이기 때문에 int로 형변환후 서로 비교하는 조건을 만듬.
						return 1;
					} else if (Integer.parseInt(A[2]) == Integer.parseInt(B[2])) {
						if (Integer.parseInt(A[0]) > Integer.parseInt(B[0])) {
							return 1;
						} else if (Integer.parseInt(A[0]) == Integer.parseInt(B[0])) {
							if (Integer.parseInt(A[1]) > Integer.parseInt(B[1])) {
								return 1;
							} else if (Integer.parseInt(A[1]) == Integer.parseInt(B[1])) {
								return 0;
							} else {
								return -1;
							}
						} else {
							return -1;
						}
					} else {
						return -1;
					}
				} return 0;
				}
			};
			Collections.sort(chosenData, com); // 만든 조건으로 sort한다. last_login_date를 기준으로 정렬됨.

			for (List<String> newLine : chosenData) { // newLine 이라는 가상의 리스트를 만들어서 chosenData의 size만큼 돌리겠다.
				List<String> list = newLine; // 리스트를 만들어서 newLine을 받는다.

				if (list.get(5).contains("last_login_date")) {

					for (int i = 0; i < list.size(); i++) { // list의 크기만큼 돌겠다.
						String data = list.get(i); // 0~8까지 나오는 값을 스트링 data에 선언한다.

						if (i != 7) { // (i + 1) % 9 의 값이 0이 아니면~ 칼럼 길이가 9이기 때문

							bw.write("\uFEFF");
							bw.write(data); // data를 입력하고,
							bw.write(","); // ","로 나눠준다.
						} else {
							bw.write("\uFEFF");
							bw.write(data); // data룰 압룍허고,
							bw.write("\n"); // 엔터로 필드를 구분한다.
						}
					}
				} else {
					String treeMonth = "3/1/2020"; // 세달전 기준을 스트링으로 선언한다
					Date threeMonthAgo = sdf.parse(treeMonth); // 먼저 정해둔 포맷에 '세달전 기준의 스트링값'을 형변환해서 넣는다.
					String lastLoginDate = list.get(5); // 5번째 칼럼인 last_login_date의 값들을 String변수로 선언해주고
					Date lastLogin = sdf.parse(lastLoginDate); // date 타입으로 형변환 해준다.
					int compareNum = lastLogin.compareTo(threeMonthAgo); // date 타입으로 형변환 한 두개를 비교하여 나온 숫자를 인트 변수에 담는다.
																			// lastLogin이 threeMonthAgo보다 크면 1 같으면 0 작으면
																			// -1

					if (compareNum >= 0) { // compare이 0보다 크거나 같은 친구들만

						for (int i = 0; i < list.size(); i++) { // list의 크기만큼 돌겠다.
							String data = list.get(i); // 0~8까지 나오는 값을 스트링 data에 선언한다.
							if (i != 7) { // (i + 1) % 9 의 값이 0이 아니면~ 칼럼 길이가 8이기 때문(먼저 firstName과 lastName을 합쳤기때문)
								bw.write("\uFEFF");
								bw.write(data); // data를 입력하고,
								bw.write(","); // ","로 나눠준다.
							} else {
								bw.write("\uFEFF");
								bw.write(data); // data룰 압룍허고,
								bw.write("\n"); // 엔터로 필드를 구분한다.
							}
						}

					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}
}
