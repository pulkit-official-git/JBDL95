package lambdas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {
    public static void main(String[] args) {


//        functional interfaces ;- interface with single method
        /*
        * callable
        * runnable
        * comparator
        * comparable
        *
        * */
//        lambas is way of writing functional interfaces without creating different(individual) implementations

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ram",84.23,Gender.MALE));
        students.add(new Student(2,"Sham",97.30,Gender.MALE));
        students.add(new Student(3,"Calm",94.30,Gender.MALE));
//
        Collections.sort(students);
        for(Student s:students){
            System.out.println(s.name);
        }

//        (parameters to give inside abstract methods)->{how to solve the abstract method}

//        ()->{}
//        Collections.sort(students,new StudentScoreComparator());
//        for(Student s:students){
//            System.out.println( s.id + " "+ s.name + " " + s.score + " " + s.gender);
//        }

//        way2

//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.score.compareTo(o1.score);
//            }
//        });
//
//        for(Student s:students){
//            System.out.println( s.id + " "+ s.name + " " + s.score + " " + s.gender);
//        }


//        way 3

        Collections.sort(students,(Student o1, Student o2)->{
            return o1.score.compareTo(o2.score)
                    ;});

//        way4
        Collections.sort(students,(Student o1, Student o2)->
             o1.score.compareTo(o2.score));

//        way 5
        Collections.sort(students,(o1,  o2)->
                o1.score.compareTo(o2.score));

//        way 6
//        method referencing
        Collections.sort(students,Student::compareTo);


        Calculator c = (a,b)->{return a+b;};
        int addition = c.operate(10,16);

        Calculator c2 = (a,b) -> a*b;
        int mul = c2.operate(5,6);

        Calculator c3 = (a,b)->{

            if(a<b)return b-a;
            else return a-b;

        };
        int sub = c3.operate(3,87);
        System.out.println(addition + " " + mul + " "+ sub);


        Runnable runnable = ()-> System.out.println("thread 1 ");
        Thread t1 = new Thread(runnable);
        t1.start();

        Thread t2 = new Thread(
                ()-> System.out.println("thread 2")

        );
        t2.start();

    }
}
