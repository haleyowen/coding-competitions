import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.File;

public class Loot {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(new File("loot.txt"));
    int times = input.nextInt();
    for(int x = 0; x < times; x++) {
      int numPeople = input.nextInt();
      double loot = input.nextDouble();
      ArrayList<String> people = new ArrayList<String>();
      TreeMap<String, Integer> jobs = new TreeMap<String, Integer>();
      TreeMap<String, ArrayList<String>> peopleJobs = new TreeMap<String, ArrayList<String>>();

      for(int y = 0; y < numPeople; y++) {
        String name = input.next();
        int numJobs = input.nextInt();
        ArrayList<String> nameJobs = new ArrayList<String>();
        people.add(name);
        input.nextLine();
        for(int z = 0; z < numJobs; z++) {
          String job = input.nextLine();
          nameJobs.add(job);
          if(jobs.containsKey(job)) {
            jobs.put(job, jobs.get(job) + 1);
          } 
          else {
            jobs.put(job, 1);
          }
        }

        peopleJobs.put(name, nameJobs);
      }

      double taskMoney = loot / jobs.size();
      TreeMap<String, Double> money = new TreeMap<String, Double>();
      for(String i : jobs.keySet()) {
        money.put(i, taskMoney / jobs.get(i));
      }
      System.out.println("Case #" + (x+1) + ":");
      
      for(int i = 0; i < people.size(); i++) {
        double total = 0;
        ArrayList<String> tasks = peopleJobs.get(people.get(i));

        for(int j = 0; j < tasks.size(); j++) {
          total += money.get(tasks.get(j));
        }

        System.out.printf("%s: %.2f\n", people.get(i), total);
      }
    }
  }
}
