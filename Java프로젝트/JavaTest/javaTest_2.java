package JavaTest;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class javaTest_2 {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		//2번
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("C:\\Users\\401-ST05\\Desktop\\Female.csv"));// 저장할 위치와 이름 설정// 저장할 파일의
																								// 경로와 이름 정하기

			List<List<String>> chosenData = readCSV.ReadCSV(); // chosenData라는 <String>을 담는 리스트를 담는 리스트를 만들어서 readCSV메소트에서 만든
														// 리스트를 불러온다.
			for (List<String> newLine : chosenData) { // newLine 이라는 가상의 리스트를 만들어서 chosenData의 size만큼 돌리겠다.
				List<String> list = newLine; // 리스트를 만들어서 newLine을 받는다.

				if (list.get(3).equals("gender")) {

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
				} else if (list.get(3).equals("여")) { // list배열에 'Male'이 포함 되있다면

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