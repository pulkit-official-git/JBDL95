package lambdas;

public class Student implements Comparable<Student> {

    Integer id;
    String name;
    Double score;
    Gender gender;

    public Student(Integer id, String name, Double score, Gender gender) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public Student() {
    }

    @Override
    public int compareTo(Student s) {
        return s.id.compareTo(this.id);
    }
}
