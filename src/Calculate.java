
public class Calculate {
      Athlete athlete; //Reference to the Athlete object for which calculations are performed.
      double calculateTrainingPlan; //Stores the calculated cost of the training plan.
      double calculateNoOfHours;  //Stores the calculated cost of private coaching hours.
      double calculateNoOfCompetition; //Stores the calculated cost of competitions.
      double totalCost; //Stores the total cost for the month.

      public Calculate(Athlete athlete) { //Initializes the Calculate object with an Athlete object.
            this.athlete = athlete;
      }

      public void calculatePrice() { //Calculates and prints the cost details for the athlete's training plan, private coaching hours, competitions, and total cost.
            System.out.println("Training Plan: " + athlete.getTrainingPlan());
            System.out.println("Number Of Private Coaching Hours: " + athlete.getNoOfHour());
            System.out.println("Number Of Competitions: " + athlete.getNoOfCompetition());
            System.out.println("Current Weight: " + athlete.getCurrentWeight()+"Kg");

            calculateTrainingPlan = athlete.getTrainingPlanPrice() * 4;
            calculateNoOfCompetition = athlete.getNoOfCompetition() * 22.00;
            calculateNoOfHours = (athlete.getNoOfHour() * 9.00)*4;
            totalCost = calculateTrainingPlan + calculateNoOfHours + calculateNoOfCompetition;

            System.out.println();
            System.out.println("***An itemised list of all costs for the month***");
            System.out.println("Training Plan Cost: " +String.format("%.2f",calculateTrainingPlan) +"$");
            System.out.println("Private Coaching Hours Cost: " +String.format("%.2f",calculateNoOfHours)+"$");
            System.out.println("Competitions Cost: " +String.format("%.2f",calculateNoOfCompetition)+"$");
            System.out.println();
            System.out.println("***Total cost for the month***");
            System.out.println("Total Cost: " + String.format("%.2f",totalCost)+"$");
      }

      public double weightCompare() { //Compares the athlete's current weight with the chosen weight category and returns the weight difference.
            double weight = switch (athlete.getChooseWeightCategory()) {
                  case "1" -> 120;
                  case "2" -> 100;
                  case "3" -> 90;
                  case "4" -> 81;
                  case "5" -> 73;
                  case "6" -> 66;
                  default -> 0.0;
            };
            double currentWeight = athlete.getCurrentWeight();
            if (weight > currentWeight) {
                  return weight - currentWeight;
            } else {
                  return currentWeight - weight;
            }
      }
}
