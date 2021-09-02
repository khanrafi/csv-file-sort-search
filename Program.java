package program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        //String name=sc1.next();
        String line;
        String splitBy = ",";
        List<List<String>> records = new ArrayList<>();
        List<String> data;

        try {
            BufferedReader br = new BufferedReader(new FileReader("heart.csv"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy); // array of string
                data = (Arrays.asList(values)); // list of the array of string
                //System.out.println(data);
                records.add(data);
            }
            System.out.println("Dataset is " + records);

            System.out.println("Enter option number by which you want to sort the data ");
            System.out.println("1.age 2.blood pressure 3.cholestrol 4.Heart rate 5. old peak" + " ");
            int in = sc1.nextInt();
            
            long startTime = System.currentTimeMillis();

            records.sort(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    if (in == 1) {
                        return o1.get(0).compareTo(o2.get(0));
                    }

                    if (in == 2) {
                        return o1.get(3).compareTo(o2.get(3));
                    }

                    if (in == 3) {
                        return o1.get(4).compareTo(o2.get(4));
                    }

                    if (in == 4) {
                        return o1.get(7).compareTo(o2.get(7));
                    }

                    if (in == 5) {
                        return o1.get(9).compareTo(o2.get(9));
                    }

                    return 0;
                }
            });
            System.out.println("After sort " + records);
            long endTime = System.currentTimeMillis();
 
            long timeElapsed = endTime - startTime;
 
            System.out.println("Sorting Execution time in milliseconds: " + timeElapsed);
            
            BufferedReader br1 = new BufferedReader(new FileReader("heart.csv"));
            while ((line = br1.readLine()) != null) {
                String[] values = line.split(splitBy); // array of string
                data = (Arrays.asList(values)); // list of the array of string
                //System.out.println(data);
                records.add(data);
            }
            System.out.println("Dataset is " + records);

            System.out.println("Select searching option: Searching according to ");
            System.out.println("1. age 2. gender 3. blood pressure 4. cholestrol 5. heart rate 6. exercise induced angina 7. previous peak " + " ");
            int in1 = sc1.nextInt();
            long startTime2 = 0;

            if (in1 == 1) {
                System.out.println("Enter age ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                //System.out.println("starttime " +startTime2);
                for (List<String> list : records) {
                    if (list.get(0).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }

            if (in1 == 2) {
                System.out.println("Enter gender, 1 for male and 0 for female ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                for (List<String> list : records) {
                    if (list.get(1).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }

            if (in1 == 3) {
                System.out.println("Enter resting blood pressure (in mm Hg) ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                for (List<String> list : records) {
                    if (list.get(3).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }

            if (in1 == 4) {
                System.out.println("Enter cholestoral in mg/dl ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                for (List<String> list : records) {
                    if (list.get(4).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }

            if (in1 == 5) {
                System.out.println("Enter maximum heart rate ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                for (List<String> list : records) {
                    if (list.get(7).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }

            if (in1 == 6) {
                System.out.println("Enter exercise induced angina (1 = yes; 0 = no) ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                for (List<String> list : records) {
                    if (list.get(8).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }

            if (in1 == 7) {
                System.out.println("Enter Previous peak ");
                String in2 = sc2.next();
                startTime2 = System.currentTimeMillis();
                for (List<String> list : records) {
                    if (list.get(9).contains(in2)) {
                        System.out.println("searching result " + list);
                    }
                }
            }
            long endTime2 = System.currentTimeMillis();
            //System.out.println("end time " + endTime2);
 
            long timeElapsed2 = endTime2 - startTime2;
 
            System.out.println("Searching Execution time in milliseconds: " + timeElapsed2);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
