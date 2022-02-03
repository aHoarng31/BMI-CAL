import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class BonusMethods {

    public static String Recommendations(Person p) {
        // BMI --> below 18.5 = underweight
        // BMI --> 18.5-24.9 = healthy
        // BMI --> 25-29.9 = overweight
        // BMI -->

        System.out.println(p.calcBMI());
        int idealWeight = 21 * p.height / 703 * p.height;
        System.out.println(idealWeight);
        if (p.BMI < 18.5) {
            int weightGain = idealWeight - p.endWeight;
            System.out.println(weightGain);

            return "Your BMI indicates that you are underweight, so you need to gain " + weightGain + " pounds.";
        } else if (p.BMI >= 18.5 && p.BMI <= 24.5) {
            return "Your BMI is great and healthy, you should just maintain your weight. Good Job";
        } else if (p.BMI > 24.5) {
            int weightloss = p.endWeight - idealWeight;
            return "Your BMI is high. I recommend losing weight. You need to lose " + weightloss + " pounds as soon as possible" +
                    "\n Having a high BMI will increase your risk of cardiac disease";
        } else
            return "How Are You alive";
    }


    public static Person readFromFile() throws FileNotFoundException {
        File file = new File("storage.txt");

        Scanner s = new Scanner(file);

        String name = s.nextLine();
        int age = s.nextInt();
        String gender = s.next();
        int height = s.nextInt();
        int startWeight = s.nextInt();
        int endWeight = startWeight;

        while (s.hasNext()) {
            endWeight = s.nextInt();
        }

        int idealWeight = 21 * height / 703 * height;
        Person p = new Person();
        p.age = age;
        p.endWeight = endWeight;
        p.gender = gender;
        p.height = height;
        p.name = name;
        p.startWeight = startWeight;

        return p;


    }

    public static ArrayList<Integer> allWeights() throws FileNotFoundException {
        File f = new File("storage.txt");
        Scanner scan = new Scanner(f);
        ArrayList<Integer> a = new ArrayList<>();
        String x;
        for(int i = 0; i<4; i++){
             x= scan.next();
        }
        while(scan.hasNextInt()){
            a.add(scan.nextInt());
        }
        return a;
    }

    public static void writeToFile(String name, String gender, int age, int weight, int height) throws IOException {


          FileWriter fw = new FileWriter("storage.txt");

          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter f = new PrintWriter(bw);
          f.println(name );

          f.println(""+age) ;

          f.println(gender);
          f.println(""+height);
          f.println(""+weight);
          f.close();



    }

    public static void writeToFile(int weight) throws IOException {

        FileWriter fw = new FileWriter("storage.txt", true);

        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter f = new PrintWriter(bw);

        f.println(""+weight);
        f.close();



    }

    public static void simulateYear(int x) throws IOException {


        for(int i = 0; i< x; i++){
            int random = (int)(Math.random()*50+150);
            writeToFile(random);

        }

    }
}
