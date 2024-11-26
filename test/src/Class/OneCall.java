package Class;

import java.util.Random;

public class OneCall {
    private Random random;
    public OneCall() {
        this.random = new Random();
    }
    public Student randomStudent(Student[] students) {
        int studentIndex = random.nextInt(students.length);
        return students[studentIndex];
    }
}
