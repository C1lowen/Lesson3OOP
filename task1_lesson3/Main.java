package task1_lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student st1 = new Student("Максим", "Милевский", Gender.MAN, 0, "СП-135");
        Student st2 = new Student("Соня", "Шестопал", Gender.WOMAN, 0, "СП-137");
        Student st3 = new Student("Иван", "Разум", Gender.MAN, 1, "СП-135");

        Group group135 = new Group("СП-135");

        checkAddStudent(group135, st1);
        checkAddStudent(group135, st3);

        System.out.println("Группа СП-135: " + group135);

        Group group137 = new Group("СП-137");
        checkAddStudent(group137, st2);

        System.out.println("Группа СП-137: " + group137);

        checkSearchStudent(group135, st1.getLastName());
        checkSearchStudent(group135, st3.getLastName());
        checkSearchStudent(group137, st2.getLastName());

        System.out.println("Какого студента вы хотите удалить с 135 группы?(id)");
        int id = sc.nextInt();
        delStudent(group135, id);

        System.out.println();

        System.out.println("Какого студента вы хотите удалить с 137 группы?(id)");
        id = sc.nextInt();
        delStudent(group137, id);

        System.out.println();

        System.out.println("Группа СП-135: " + group135);
        System.out.println("Группа СП-137: " + group137);

    }

    private static void checkAddStudent(Group group, Student st){
        try {
            group.addStudent(st);
        }catch (GroupOverflowException e){
            e.printStackTrace();
        }
    }

    private static void checkSearchStudent(Group group, String lastname){
        try{
            group.searchStudentByLastName(lastname);
        } catch (StudentNotFoundException e){
            System.out.println("Студента с такой фамилией не найдено");
        }
    }

    private static void delStudent(Group group, int id){
        if(group.removeStudentByID(id)){
            System.out.println("Студент успешно удален из группы!");
        }else{
            System.out.println("Такого студента нету в этой группе!");
        }
    }
}
