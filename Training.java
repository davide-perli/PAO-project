import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Training {
    Static_exercise static_exercise = new Static_exercise();
    Dynamic_exercise dynamic_exercise = new Dynamic_exercise();
    Sets_and_reps sets_and_reps = new Sets_and_reps();
    Training_program training_program = new Training_program();
    Athlete athlete;

    HashMap<String, ExercisePlan> weeklyPlan = new HashMap<>();

    Scanner myObj = new Scanner(System.in);

    private String[] days = {"MON", "TUE", "WEN", "TUE", "FRY", "SAT", "SUN"};
    private String[] level = {"beginner", "intermidiate", "advanced", "expert"};
    protected int option;
    protected int contor;
    protected String stat_exercise_option;
    protected String dyn_exercise_option;
    protected String sets_exercise_option;

    public Training(Athlete athlete) {
        this.athlete = athlete;
        String stat_lev_val = level[athlete.getStatic_level() - 1];
        String dyn_lev_val = level[athlete.getDynamic_level() - 1];
        System.out.println("For each day of the week you'll choose exercises for " + stat_lev_val + " static level and " + dyn_lev_val + " dynamic level");
        for (String i : days) {
            System.out.println("For " + i + " choose your exercises\nChoose a static exercise:");

            training_program.addDay(i);
            
            contor = 0;
            List<String> filteredExercises = new ArrayList<>();
            for (Map.Entry<String, String> entry : static_exercise.getExerciseRanked().entrySet()) {       
                if (entry.getValue().equals(stat_lev_val)) {
                    contor ++;
                    filteredExercises.add(entry.getKey());
                    System.out.println(contor + ". " + entry.getKey());
                }
            }

            while (true) {
                System.out.print("\nOption: ");
                option = myObj.nextInt();
                
                if (option>= 1 && option <= contor) {
                    break;
                } else {
                    System.out.println("Invalid option! Please enter a valid option.");
                }
            }
            stat_exercise_option = filteredExercises.get(option - 1);
            System.out.println("You selected: " + stat_exercise_option + "\n\nChoose a dynamic exercise:");

            filteredExercises.clear();
            contor = 0;
            for (Map.Entry<String, String> entry : dynamic_exercise.getExerciseRanked().entrySet()) {       
                if (entry.getValue().equals(dyn_lev_val)) {
                    contor ++;
                    filteredExercises.add(entry.getKey());
                    System.out.println(contor + ". " + entry.getKey());
                }
            }

            while (true) {
                System.out.print("\nOption: ");
                option = myObj.nextInt();
                
                if (option>= 1 && option <= contor) {
                    break;
                } else {
                    System.out.println("Invalid option! Please enter a valid option.");
                }
            }
            dyn_exercise_option = filteredExercises.get(option - 1);
            System.out.println("You selected: " + dyn_exercise_option + "\n\nChoose sets and reps exercise:");

            filteredExercises.clear();
            contor = 0;
            for (Map.Entry<String, String> entry : sets_and_reps.getExerciseRanked().entrySet()) {       
                contor ++;
                filteredExercises.add(entry.getKey());
                System.out.println(contor + ". " + entry.getKey());
            }

            while (true) {
                System.out.print("\nOption: ");
                option = myObj.nextInt();
                
                if (option>= 1 && option <= contor) {
                    break;
                } else {
                    System.out.println("Invalid option! Please enter a valid option.");
                }
            }
            sets_exercise_option = filteredExercises.get(option - 1);
            System.out.println("You selected: " + sets_exercise_option + "\n");

            weeklyPlan.put(i, new ExercisePlan(stat_exercise_option, dyn_exercise_option, sets_exercise_option));
            for (Map.Entry<String, ExercisePlan> entry : weeklyPlan.entrySet()) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }            

        }
    }
}
