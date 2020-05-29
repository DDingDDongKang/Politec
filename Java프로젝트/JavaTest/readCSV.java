package JavaTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class readCSV {
	public static List<List<String>> ReadCSV() throws FileNotFoundException {
		BufferedReader br = null;
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\401-ST05\\Desktop\\log.csv"));

			String line = null;
			while ((line = br.readLine()) != null) { // readLine으로 한줄씩 받아오겠다.
				List<String> inputList = new ArrayList<String>(); // inputList라는 ArrayList<String값이 들어가는>를 만든다.
				String array[] = line.split(","); // array배열을 만드는데, readLine한 한 줄을 '콤마'를 기준으로 나누어 배열에 담는다
				array[1] = array[1] + " " + array[2]; // 이름과 성을 합친다.
				if (array[4].equals("Female")) { // 배열 4번째 값이 Female이라면(Female을 '여'로 바꾸기위해)
					array[4] = "여"; // 5번째 칼럼이 gender이기 때문에 배열 4번째에 값을 여자로 바꿔준다.
					inputList.addAll(Arrays.asList(array)); // inputList는 array배열을 list배열로 변경한 것을 담는다.
					inputList.remove(2); // input에 들어간 lastName list를 지운다
					System.out.println(inputList); // 잘 담겼는지 확인을 위해 출력하기
					list.add(inputList); // <String>을 담는 리스르틑 담는 리스트인 List에 inputList를 담는다.

				} else if (array[4].equals("Male")) { // 배열 4번째 값이 male이라면
					array[4] = "남"; // 5번째 칼럼이 gender이기 때문에 배열 4번째에 값을 남자로 바꿔준다.(male을 '남'로 바꾸기위해)
					inputList.addAll(Arrays.asList(array));// inputList는 array배열을 list배열로 변경한 것을 담는다.
					inputList.remove(2); // input에 들어간 lastName list를 지운다 (
					System.out.println(inputList); // 잘 담겼는지 확인을 위해 출력하기
					list.add(inputList); // <String>을 담는 리스르틑 담는 리스트인 List에 inputList를 담는다.

				} else {
					inputList.addAll(Arrays.asList(array)); // inputList는 array배열을 list배열로 변경한 것을 담는다.
					inputList.remove(2); // input에 들어간 lastName list를 지운다
					System.out.println(inputList); // 잘 담겼는지 확인을 위해 출력하기
					list.add(inputList); // <String>을 담는 리스르틑 담는 리스트인 List에 inputList를 담는다.

				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return list;
	}
}
