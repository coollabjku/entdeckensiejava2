package Loesungen.Kapitel14;

// Aufgabe 43
public class Student {
    private String name;
    private boolean awake;
    private int knowledge;
    private int saturation;
    private String lastGrade;

    public Student(String name) {
        this.name = name;
        this.awake = false;
        this.saturation = 5;
        this.knowledge = 0;
        this.lastGrade = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void wakeUp() {
        this.awake = true;
    }

    public void eat() {
        saturation += 5;
    }

    public void study(int hoursToLearn) {
        if (hoursToLearn > saturation) {
            hoursToLearn = saturation;
        }
        saturation -= hoursToLearn;
        knowledge += 3 * hoursToLearn;
    }

    public void study2(int hoursToLearn) {
        while (hoursToLearn > 0 && saturation > 0) {
            knowledge += 3;
            saturation--;
            hoursToLearn--;
        }
    }

    public void goOut(int hoursOnTour) {
        knowledge -= 3 * hoursOnTour;
        if (knowledge < 0) {
            knowledge = 0;
        }
    }

    public void writeExam() {
        switch (knowledge) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                lastGrade = "Nicht Genügend";
                break;
            case 5:
                lastGrade = "Genügend";
                break;
            case 6:
                lastGrade = "Befriedigend";
                break;
            case 7:
                lastGrade = "Gut";
                break;
            default:
                lastGrade = "Sehr Gut";
                break;
        }
    }

    public int getKnowledge() {
        return knowledge;
    }

    public String getLastGrade() {
        return lastGrade;
    }
}
