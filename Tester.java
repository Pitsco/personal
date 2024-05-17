import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

// Abstract class Collectable
abstract class Collectable implements Comparable<Collectable> {
    @Override
    public abstract int compareTo(Collectable o);

    @Override
    public abstract String toString();
}

// Person class extending Collectable
class Person extends Collectable {
    private String name;
    private int age;
    private String sortKey;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.sortKey = "name"; // default sort key
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    @Override
    public int compareTo(Collectable o) {
        Person other = (Person) o;
        switch (this.sortKey) {
            case "name":
                return this.name.compareTo(other.name);
            case "age":
                return Integer.compare(this.age, other.age);
            default:
                throw new IllegalArgumentException("Invalid sort key: " + this.sortKey);
        }
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("age", this.age);
        return json.toString();
    }
}

// SelectionSort class with a generic method
class SelectionSort {
    public static <T extends Collectable> void selectionSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            T temp = list.get(minIdx);
            list.set(minIdx, list.get(i));
            list.set(i, temp);
        }
    }
}

// Tester class
public class Tester {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Default sort by name
        System.out.println("Before sorting by name: " + people);
        SelectionSort.selectionSort(people);
        System.out.println("After sorting by name: " + people);

        // Change sort key to age
        for (Person person : people) {
            person.setSortKey("age");
        }
        System.out.println("Before sorting by age: " + people);
        SelectionSort.selectionSort(people);
        System.out.println("After sorting by age: " + people);
    }
}