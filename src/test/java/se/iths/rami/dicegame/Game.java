package se.iths.rami.dicegame;

public class Game {
    private final String regEx = "[a-zA-ZåäöÅÄÖ]+";
    private boolean finished = false;

    public Game() {
    }

    public void play() {

        IO.println("Välkommen till Dicegame\nVad heter spelare nummer ett?");
        String firstName1 = playerName("Förnamn: ");
        String lastName1 = playerName("Efternamn: ");

        IO.println("Vad heter spelare nummer två?");
        String firstName2 = playerName("Förnamn: ");
        String lastName2 = playerName("Efternamn: ");
        
        Person p1 = new Person(firstName1, lastName1);
        Person p2 = new Person(firstName2, lastName2);

        int gameNumber = 0;
        while (!finished) {
            gameNumber++;
            p1.setScore(0);
            p2.setScore(0);

            IO.println("\nMatch nummer " + gameNumber + "\n" + p1.getFullName() + " vs " + p2.getFullName());
            IO.println("Du kan avsluta spelet genom att skriva quit i konsolen.");
            IO.println("Skriv in 1 för kasta tärningen, ni har två kast var.\n");

            int dice;
            for (int i = 1; i <= 4; i++) {
                String hitDice = IO.readln("Kasta tärningen?: ");
                if (hitDice.equalsIgnoreCase("quit")) {
                    isFinished();
                    break;
                }
                if (hitDice.equals("1")) {
                    if (i <= 2) {
                        dice = (int) (Math.random() * 6) + 1;
                        p1.addToScore(dice);
                        IO.println("Tärningen blev " + dice + ".");
                    }
                    if (i == 2) {
                        IO.println("Spelare 1 fick " + p1.getScore() + " poäng totalt.");
                    }
                    if (i > 2) {
                        dice = (int) (Math.random() * 6) + 1;
                        p2.addToScore(dice);
                        IO.println("Tärningen blev " + dice + ".");
                    }
                    if (i == 4) {
                        IO.println("Spelare 2 fick " + p2.getScore() + " poäng totalt.");
                    }
                } else {
                    IO.println("Skriv in 1 för kasta tärningen.");
                    i--;
                }
            }

            if (finished) {
                break;
            }

            if (p1.getScore() == p2.getScore()) {
                IO.println("Det blev oavgjort med " + p1.getScore() + " poäng.");
            } else if (p1.getScore() > p2.getScore()) {
                IO.println("\nVinnaren är: " + p1.getFullName() + " med " + p1.getScore() + " poäng.");
            } else {
                IO.println("\nVinnaren är: " + p2.getFullName() + " med " + p2.getScore() + " poäng.");
            }

            String askAgain = "";
            while (true) {
                if (askAgain.equals("1")) {
                    break;
                } else if (askAgain.equals("2")) {
                    isFinished();
                    break;
                } else {
                    IO.println("Skriv in endast 1 eller 2");
                    askAgain = IO.readln("\n1. Spela igen\n2. Avsluta spelet ");
                }
            }
        }
    }

    public String playerName(String prompt) {
        while (true) {
            try {

                String name = IO.readln(prompt);
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Namnet får inte vara tomt.");
                }
                if (!name.matches(regEx)) {
                    IO.println("Skriv in bara bokstäver a-ö, inga mellanrum.");
                    continue;
                }

                return name;

            } catch (IllegalArgumentException e) {
                IO.println("Fel: " + e.getMessage());
            }
        }
    }

    public boolean isFinished() {
        return finished = true;
    }
}
