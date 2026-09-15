package se.iths.rami.dicegame;

public class Person {
    private String firstName;
    private String lastName;
    private int score;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // GET
    public int getScore() {
        return score;
    }

    // SET
    public void setScore(int score) {
        this.score = score;
    }

}
