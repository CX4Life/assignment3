import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/* CS 241 - Winter 2017
 * Edgar Silveyra
 * Tim Woods
 * Assignment 3
 */
public class assign3 {
    public static void main(String[] args) {
        Display();
        int[] picks = takeInput();
        int a = picks[0];
        int b = picks[1];

        Scanner getInput = new Scanner(System.in);
        List<nameNode> personList = readFile("yob2014.txt");
        setFreqs(personList);
        while(inputValid(a, b)) {
            if (a == 1) {
                HashSet<nameNode> randomizer = new HashSet<>(); // leverage that order is
                for(nameNode n : personList){                   // unknown in hash set to ensure
                    n.setrChild(null);                    // our tree is randomly balanced
                    n.setlChild(null);                    // This helps prevent stack overflow
                    randomizer.add(n);
                }
                nameTree ourTree = new nameTree(randomizer, b);
                if(b == 1){
                    System.out.println("Please input a name to search:");
                    String findName = getInput.nextLine();
                    ourTree.displaySearch(findName);
                } else {
                    ourTree.inOrder(ourTree.getRoot());
                }
            } else if (a == 2) {
                System.out.println("BUILD ME A HASH MAP, SANTA");
            } else {// array selected
                nameArray array = new nameArray(personList);
                if (b == 1) {
                    System.out.println("Please input a name to search:");
                    String findName = getInput.nextLine();
                    array.displaySearchResults(findName);
                } else if (b == 2) {
                    array.displayFreqSorted();
                } else {
                    array.displayAlphaSorted();
                }
            }
            picks = takeInput();
            a = picks[0];
            b = picks[1];
        }
    }

    private static List<nameNode> readFile (String filename){
        List<nameNode> personList = new ArrayList<>();
        String line;
        try{
            BufferedReader reader = new BufferedReader(new FileReader (filename));
            while((line = reader.readLine()) != null){
                String name = line.split(",")[0];
                String gender = line.split(",")[1];
                int count = Integer.parseInt(line.split(",")[2]);
                nameNode node = new nameNode(gender, name, count);
                personList.add(node);
            }
        } catch(IOException e) {
            System.out.println("File not found.");
        }
        return personList;
    }

    private static void Display(){

        System.out.println("   ___ ___    ____  ____ ____           ____ ____  ___        ______ ____ ___ ___  _____");
        System.out.println("  /  _]   \\  /    |/    |    \\         /    |    \\|   \\      |      |    |   |   |/ ___/");
        System.out.println(" /  [_|    \\|   __|  o  |  D  )       |  o  |  _  |    \\     |      ||  || _   _ (   \\_ ");
        System.out.println("|    _]  D  |  |  |     |    /        |     |  |  |  D  |    |_|  |_||  ||  \\_/  |\\__  |");
        System.out.println("|   [_|     |  |_ |  _  |    \\        |  _  |  |  |     |      |  |  |  ||   |   |/  \\ |");
        System.out.println("|     |     |     |  |  |  .  \\       |  |  |  |  |     |      |  |  |  ||   |   |\\    |");
        System.out.println("|_____|_____|___,_|__|__|__|\\_|       |__|__|__|__|_____|      |__| |____|___|___| \\___|");
        System.out.println();
        System.out.println(" ____   ____ ____  __ __                                 ____   ____ ___ ___   ___ _____");
        System.out.println("|    \\ /    |    \\|  |  |                               |    \\ /    |   |   | /  _] ___/");
        System.out.println("|  o  )  o  |  o  )  |  |                               |  _  |  o  | _   _ |/  [(   \\_");
        System.out.println("|     |     |     |  ~  |                               |  |  |     |  \\_/  |    _]__  |");
        System.out.println("|  O  |  _  |  O  |___, |                               |  |  |  _  |   |   |   [_/  \\ |");
        System.out.println("|     |  |  |     |     |                               |  |  |  |  |   |   |     \\    |");
        System.out.println("|_____|__|__|_____|____/                                |__|__|__|__|___|___|_____|\\___|");
        System.out.println();
        System.out.println(" ____ ____  _____  ___        ____ ____  ___         _____  ___  ____ ____     __ __ __ ");
        System.out.println("|    |    \\|     |/   \\      /    |    \\|   \\       / ___/ /  _]/    |    \\   /  ]  |  |");
        System.out.println(" |  ||  _  |   __|     |    |  o  |  _  |    \\     (   \\_ /  [_|  o  |  D  ) /  /|  |  |");
        System.out.println(" |  ||  |  |  |_ |  O  |    |     |  |  |  D  |     \\__  |    _]     |    / /  / |  _  |");
        System.out.println(" |  ||  |  |   _]|     |    |  _  |  |  |     |     /  \\ |   [_|  _  |    \\/   \\_|  |  |");
        System.out.println(" |  ||  |  |  |  |     |    |  |  |  |  |     |     \\    |     |  |  |  .  \\     |  |  |");
        System.out.println("|____|__|__|__|   \\___/     |__|__|__|__|_____|      \\___|_____|__|__|__|\\_|\\____|__|__|");
        System.out.println();

    }

    private static void setFreqs(List<nameNode> babies){
        int total = 0;
        for(nameNode n : babies){
            total += n.getCount();
        }
        for(nameNode n : babies){
            n.setFreq(total);
        }
    }

    private static boolean inputValid(int pick1, int pick2){
        return !(pick1 > 3 || pick1 < 0 || pick2 > 3 || pick2 < 0);
    }

    private static int[] takeInput(){
        int[] ret = new int[2];
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("*** Enter a number greater than 3 to quit ***");
        System.out.println("*********************************************");
        System.out.println();
        System.out.println("Please enter an integer to select your preferred data structure:");
        System.out.println("\t1-\tTree");
        System.out.println("\t2-\tHash Map");
        System.out.println("\t3-\tArray");
        ret[0] = scan.nextInt();
        assert ret[0] < 4;
        System.out.println();
        System.out.println("Please enter an integer to select your desired information:");
        System.out.println("\t1-\tSearch for a name");
        System.out.println("\t2-\tShow names by popularity");
        System.out.println("\t3-\tShow names alphabetically");
        ret[1] = scan.nextInt();
        assert ret[1] < 4;
        if (ret[0] > 3 || ret[1] > 3 || ret[0] < 1 || ret[1] < 1){
            System.out.println("Invalid argument - please select options between 1 and 3");
            ret[0] = -1;
        }
        return ret;
    }
}
