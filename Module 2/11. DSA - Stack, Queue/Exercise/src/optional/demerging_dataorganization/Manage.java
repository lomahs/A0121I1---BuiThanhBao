package optional.demerging_dataorganization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Manage {
    private List<Student> output = new ArrayList<>();

    public boolean isFemale(Student student){
        return student.getSex().equals("Female");
    }

    public List<Student> demerging(List<Student> list){
        Queue<Student> female = new LinkedList<>();
        Queue<Student> male = new LinkedList<>();

        list.forEach(sv ->{
            if (isFemale(sv)){
                female.add(sv);
            }else {
                male.add(sv);
            }
        });

        while (!female.isEmpty()){
            output.add(female.poll());
        }

        while (!male.isEmpty()){
            output.add(male.poll());
        }

        return output;
    }

    public void display(){
        output.forEach(Student::show);
    }
}
