import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;

public class Tests implements CollectionTest {
    private int size;
    private LinkedList<Person> linkedList;
    private ArrayList<Person> arrayList;
    private HashMap<Integer, Person> hashMap;

    public Tests() {
        linkedList = new LinkedList<Person>();
        arrayList = new ArrayList<Person>();
        hashMap = new HashMap<Integer, Person>();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void populate(CollectionTest.CollectionType type) {
        switch (type) {
            case LINKED_LIST:
                linkedList = new LinkedList<Person>();
                for (int i = 0; i < size; i++) {
                    String name = "Person" + i;
                    Person p = new Person(name, 0);
                    linkedList.add(p);
                }
                break;
            case ARRAY_LIST:
                arrayList = new ArrayList<Person>();
                for (int i = 0; i < size; i++) {
                    String name = "Person" + i;
                    Person p = new Person(name, 0);
                    arrayList.add(p);
                }
                break;
            case HASH_MAP:
                hashMap = new HashMap<Integer, Person>();
                for (int i = 0; i < size; i++) {
                    String name = "Person" + i;
                    Person p = new Person(name, 0);
                    hashMap.put(p.hashCode(), p);
                }
                break;

            default:
                System.err.println("Incorrect Usage of TEST collection.");
                break;
        }
    }

    public void runTest(CollectionTest.CollectionType type, CollectionTest.TestType test, int iterations) {
        switch (type) {
            case LINKED_LIST:
                switch (test) {
                    case ADD:
                        populate(type);
                        break;
                    case INDEX:
                        for (int i = 0; i < iterations; i++) {
                            linkedList.get(size / 2);
                        }
                        break;
                    case SEARCH:
                        for (int i = 0; i < iterations; i++) {
                            Person pSearch = new Person("Person" + size / 2, 0);
                            linkedList.get(linkedList.indexOf(pSearch));
                        }
                        break;
                }
                break;
            case ARRAY_LIST:
                switch (test) {
                    case ADD:
                        populate(type);
                        break;
                    case INDEX:
                        for (int i = 0; i < iterations; i++) {
                            arrayList.get(size / 2);
                        }
                        break;
                    case SEARCH:
                        for (int i = 0; i < iterations; i++) {
                            Person pSearch = new Person("Person" + size / 2, 0);
                            arrayList.get(arrayList.indexOf(pSearch));
                        }
                        break;
                }
                break;
            case HASH_MAP:
                switch (test) {
                    case ADD:
                        populate(type);
                        break;
                    case INDEX:
                        for (int i = 0; i < iterations; i++) {
                            int index = size / 2;
                            String name = "Person" + index;
                            hashMap.get(name.hashCode());
                        }
                        break;
                    case SEARCH:
                        for (int i = 0; i < iterations; i++) {
                            String name = "Person" + size / 2;
                            hashMap.get(name.hashCode());
                        }
                        break;
                }
                break;
        }
    }
}