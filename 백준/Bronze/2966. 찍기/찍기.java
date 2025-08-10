import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Map<String, Integer>> map = new HashMap<>();
		String name[] = { "Adrian", "Bruno", "Goran" };
		String pattern[] = { "ABC", "BABC", "CCAABB" };

		for (int i = 0; i < name.length; i++) {
			map.put(name[i], new HashMap<>());
			map.get(name[i]).put(pattern[i], 0);
		}

		int num = Integer.parseInt(br.readLine());
		String exam = br.readLine();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < name.length; j++) {
				if (exam.charAt(i % exam.length()) == pattern[j].charAt(i % pattern[j].length()))
					map.get(name[j]).put(pattern[j], (map.get(name[j]).get(pattern[j]) + 1));
			}
		}

		int sum = 0;
		String str = "";
		for (String key : map.keySet()) {
			int val2 = map.get(key).get((String) map.get(key).keySet().toArray()[0]);

			if (sum < val2) {
				sum = val2;
				str = key + "-";
			} else if (sum == val2)
				str += key + "-";
		}
		String[] strArr = str.split("-");
		Arrays.sort(strArr);

		System.out.println(sum);
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}
}