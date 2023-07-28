import java.util.Arrays;

public class Group {
    private String groupName;
    private Student[] students;

    public Group(String groupName) {
        students = new Student[10];
        this.groupName = groupName;
    }

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException{
        if(student.getGroupName() != this.groupName){
            System.out.println("Студент "+ student.getName() +" не может быть в этой группе!");
            return;
        }
       for(int i = 0; i < students.length; i++){
           if(students[i] == null){
               students[i] = student;
               return;
           }
       }
       throw new GroupOverflowException("В группу нельзя добавить больше 10 студентов");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getLastName().equals(lastName)){
                return students[i];
            }
        }
        throw new StudentNotFoundException("Такого студента не найдено!");
    }

    public boolean removeStudentByID(int id) {
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getId() == id){
                students[i] = null;
                return true;
            }
        }
        return false;
    }
    public Student[] sortStudents(){
        int size = students.length;
        String[] indexStudent = new String [size];
        Student[] newSortStudent = new Student [size];

        int count = 0;
        for(int i = 0; i < size; i++){
            if(students[i] != null) {
                indexStudent[count] = students[i].getLastName();
                count++;
            }
        }

        Arrays.sort(indexStudent, 0, count);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                if (indexStudent[i] != null && students[j] != null && indexStudent[i].equals(students[j].getLastName())) {
                    newSortStudent[i] = students[j];
                }
            }
        }
        return newSortStudent;
    }

    @Override
    public String toString() {
         String result = "Group" + System.lineSeparator();
         Student[] sortedStudentsForLastName = sortStudents();

         for(int i = 0; i < sortedStudentsForLastName.length; i++){
             if(sortedStudentsForLastName[i] != null){
                 result +=  sortedStudentsForLastName[i].toString() + System.lineSeparator();
             }
         }
        return result;
    }
}
