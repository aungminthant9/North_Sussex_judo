import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Athlete {
    private String athleteName; //Stores the name of the athlete.
    private String trainingPlan; //Stores the training plan chosen by the athlete.

    private double trainingPlanPrice; //Stores the price of the training plan.
    private double currentWeight;//Stores the current weight of the athlete.
    private String weightCategory; // Stores the weight category of the athlete.
    private int noOfCompetition; //Stores the number of competitions participated in by the athlete.
    private int noOfHour; // Stores the number of private coaching hours.
    private String chooseWeightCategory; //Stores the chosen weight category


    public Athlete(String athleteName, String trainingPlan,double trainingPlanPrice, double currentWeight,
                   String weightCategory, int noOfCompetition, int noOfHour,String chooseWeightCategory) {
        this.athleteName = athleteName;
        this.trainingPlan = trainingPlan;
        this.currentWeight = currentWeight;
        this.weightCategory = weightCategory;
        this.noOfCompetition = noOfCompetition;
        this.noOfHour = noOfHour;
        this.trainingPlanPrice = trainingPlanPrice;
        this.chooseWeightCategory = chooseWeightCategory;
    }

    public String getAthleteName() {  //Returns the athlete's name
        return athleteName;
    }

    public void setAthleteName(Scanner sc) {  //Sets the athlete's name after validating user input.
        System.out.println("Enter Athlete Name");
        String athleteName = sc.nextLine();
        if(athleteName.length()<=0 || !athleteName.matches("[a-zA-Z ]+")){
            System.out.println("Invalid name please re-enter");
            setAthleteName(sc);
        }else {
            this.athleteName = athleteName;
        }
    }

    public String getTrainingPlan() {  //Returns the athlete's training plan.
        return trainingPlan;
    }

    public void setTrainingPlan(Scanner sc) {  //Sets the athlete's training plan and assign the training plan price based on the chosen plan.
        boolean validInput = false;
        System.out.println("Choose Your training plan:(Beginner,Intermediate,Elite)");
        String trainingPlan = sc.nextLine().toLowerCase();
        this.trainingPlan = trainingPlan;
        while (!validInput){
            if(trainingPlan.equals("beginner")){
                this.trainingPlanPrice = 25.00;
                validInput = true;
            } else if (trainingPlan.equals("intermediate")) {
                this.trainingPlanPrice = 30.00;
                validInput = true;
            } else if (trainingPlan.equals("elite")){
                this.trainingPlanPrice = 35.00;
                validInput = true;
            } else {
                System.out.println("Your Input is invalid");
                System.out.println("Choose Your training plan:(Beginner,Intermediate,Elite)");
                trainingPlan = sc.nextLine().toLowerCase();
                this.trainingPlan = trainingPlan;
            }
        }
    }

    public double getTrainingPlanPrice(){ //Returns the price of the athlete's training plan.
        return trainingPlanPrice;
    }

    public double getCurrentWeight() { //Returns the athlete's current weight.
        return currentWeight;
    }

    public void setCurrentWeight(Scanner sc) {  //Sets the athlete's current weight after input validation.
        System.out.println("Enter your current weight in Kilogram(Kg)");
        double currentWeight= sc.nextDouble();
        sc.nextLine();
        if(currentWeight<=10){
            System.out.println("Invalid Weight");
            setCurrentWeight(sc);
        }else {
            this.currentWeight = currentWeight;
        }
    }

    public String getWeightCategory() {  //Returns the athlete's weight category.
        return weightCategory;
    }

     private Map<String,String> weightCategories;

    public void setWeightCategory(Scanner sc) {  //Sets the athlete's weight category based on user input and validation.
        if(!this.trainingPlan.equalsIgnoreCase("Beginner")){
            weightCategories = new HashMap<>();
            weightCategories.put("1", "Heavyweight(over 100kg)");
            weightCategories.put("2", "Light-Heavyweight(100kg)");
            weightCategories.put("3", "Middleweight(90kg)");
            weightCategories.put("4", "Light-Middleweight(81kg)");
            weightCategories.put("5", "Lightweight(73kg)");
            weightCategories.put("6", "Flyweight(66kg)");

            System.out.println("Enter your weight category");
            weightCategories.forEach((key, value) -> System.out.println(key + ". " + value));

            boolean validInput = false;

            while (!validInput) {
                String chooseWeightCategory = sc.nextLine().trim();
                this.chooseWeightCategory = chooseWeightCategory;
                try {
                    if (weightCategories.containsKey(chooseWeightCategory)) {
                        this.weightCategory = weightCategories.get(chooseWeightCategory);
                        validInput = true;
                    } else {
                        System.out.println("Invalid weight category!!! Please enter again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format! Please enter a number.");
                }
            }
        }
    }



    public int getNoOfCompetition() { //Returns the number of competitions participated in by the athlete.
        return noOfCompetition;
    }

    public void setNoOfCompetition(Scanner sc) { //Sets the number of competitions after input validation.
        if (!this.trainingPlan.equalsIgnoreCase("Beginner")) {
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Enter the number of competitions you have participated: ");

                if (sc.hasNextInt()) {
                    int competitions = sc.nextInt();
                    sc.nextLine();

                    if (competitions >= 0) {
                        this.noOfCompetition = competitions;
                        validInput = true;
                    } else {
                        System.out.println("Invalid number!");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                }
            }
        }
    }

    public int getNoOfHour() {  //Returns the number of private coaching hours.
        return noOfHour;
    }

    public void setNoOfHour(Scanner sc) { //Sets the number of private coaching hours after input validation.
        boolean validInput = false;
        while (!validInput){
            System.out.println("Enter the number of private coaching hours you want to train: ");
            if(sc.hasNextInt()){
                int noOfHour = sc.nextInt();
                sc.nextLine();

                if(noOfHour<=5 && noOfHour>=0){
                    this.noOfHour = noOfHour;
                    validInput = true;
                }else {
                    System.out.println("Maximum hours for private coaching in a week is 5.");
                }
            }else {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }

        }
    }
    public String getChooseWeightCategory() { //Returns the chosen weight category.
        return chooseWeightCategory;
    }
}
