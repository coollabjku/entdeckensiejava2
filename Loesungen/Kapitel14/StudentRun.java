package Loesungen.Kapitel14;

// Aufgabe 18
public class StudentRun {
    public static void main(String[] args) {
        Student lazyStudent = new Student("Franz");
        lazyStudent.eat();
        lazyStudent.study2(2);
        lazyStudent.goOut(1000);
        lazyStudent.writeExam();
        System.out.println(lazyStudent.getLastGrade());
        System.out.println("Knowledge=" + lazyStudent.getKnowledge());
    }
}