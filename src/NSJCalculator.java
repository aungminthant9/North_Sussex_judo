import java.util.Scanner;

public class NSJCalculator {

    public static void main(String []args){
        /*
         Initializes a Scanner object for user input.
         Creates an Athlete object and a Calculat object.
         Sets athlete information using user input.
         Prints the athlete's name, calculates and prints cost details, and calculates and prints the weight difference.
         */
        Scanner scanner = new Scanner(System.in);
        Athlete athlete = new Athlete("","",0,0,"",0,0,"");
        Calculate calculate = new Calculate(athlete);

        athlete.setAthleteName(scanner);
        athlete.setTrainingPlan(scanner);
        athlete.setCurrentWeight(scanner);
        athlete.setWeightCategory(scanner);
        athlete.setNoOfCompetition(scanner);
        athlete.setNoOfHour(scanner);

        String athleteName = athlete.getAthleteName().toUpperCase();
        double weightDifference = calculate.weightCompare();

        System.out.println();
        System.out.println("Athlete's Name: "+athleteName);
        calculate.calculatePrice();
        System.out.println();
        System.out.println("The weight difference is "+weightDifference+"Kg.");
        System.out.println("****Thank You!****");
    }
}
