package JavaTest;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class javaTest_5 {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// 3번
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy", Locale.ENGLISH); // 파일에 들어있는 last_login_date가 이런 형식으로
																					// 돼있기 때문에 비교를 위해 포맷을 이와같이 정함.

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("C:\\Users\\401-ST05\\Desktop\\best.csv")); // 저장할 위치와 이름 설정//
																										// 저장할 파일의 경로와
			List<List<String>> chosenData = readCSV.ReadCSV(); // 이름 정하기
			Comparator<List<String>> com = new Comparator<List<String>>() { // 포인트를 비교하는 comparator class 생성
				@Override
				public int compare(List<String> a, List<String> b) { // 리스트 두개를 비교하는 것
					if(!(a.get(7).equals("point")) && !(b.get(7).equals("point"))) {
					double A = Double.parseDouble(a.get(7)); //String으로 받은 포인트를 double로 형변환
					double B = Double.parseDouble(b.get(7)); //String으로 받은 포인트를 double로 형변환
				
					if (A < B) { 
						return 1;
					} else if (A == B) {
						return 0;
					} else {
						return -1;
					}
				} return 0;
				}
			};
			Collections.sort(chosenData, com); // 만든 조건으로 sort한다. last_login_date를 기준으로 정렬됨.

			for (int i = 0; i < 101; i++) { // newLine 이라는 가상의 리스트를 만들어서 chosenData의 size만큼 돌리겠다.
				List<String> list = chosenData.get(i); // 리스트를 만들어서 newLine을 받는다.

				if (list.get(7).contains("point")) {

					for (int h = 0; h < list.size(); h++) { // list의 크기만큼 돌겠다.
						String data = list.get(h); // 0~8까지 나오는 값을 스트링 data에 선언한다.

						if (h != 7) { // (i + 1) % 9 의 값이 0이 아니면~ 칼럼 길이가 9이기 때문

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
					
						for (int g = 0; g < list.size(); g++) { // list의 크기만큼 돌겠다.
							String data = list.get(g); // 0~8까지 나오는 값을 스트링 data에 선언한다.
							if (g != 7) { // (i + 1) % 9 의 값이 0이 아니면~ 칼럼 길이가 8이기 때문(먼저 firstName과 lastName을 합쳤기때문)
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

