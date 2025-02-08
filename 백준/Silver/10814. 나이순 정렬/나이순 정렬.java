import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        list.sort((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.num - o2.num;
            }
            return o1.age - o2.age;
        });

        StringBuilder sb = new StringBuilder();

        for (Person person : list) {
            sb.append(person.age).append(" ").append(person.name).append("\n");
        }

        System.out.println(sb);

    }

    static class Person{
        private int age;
        private String name;
        private int num;

        public Person(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }
    }
}
