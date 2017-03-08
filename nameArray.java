// Class for using
// an ArrayList as the data structure
// for our baby names

import java.util.*;

public class nameArray {
    private List<nameNode> names = new ArrayList<>();

    public nameArray(){
    }
    public void add(nameNode baby){
        this.names.add(baby);
    }
    private void sortByName(){
        Collections.sort(names, Comparator.naturalOrder());
    }
    private void sortByFreq(){
        Comparator<nameNode> c = (a,b) -> a.compareNum(b);
        names.sort(c);
    }
    public void displayAlphaSorted(){
        this.sortByName();
        String head = String.format("%1$-10s %2$1s %3$7s %4$5s", "NAME", "GENDER", "OCCURRENCES", "%");
        System.out.println(head);
        for(nameNode baby : names){
            String gen = "F";
            if (baby.isMale()){
                gen = "M";
            }
            String printPretty = String.format("%1$-15s %2$1s %3$-11d %4$.4f", baby.getName(), gen, baby.getCount(), baby.getFreq());
            System.out.println(printPretty);
        }
    }
    public void displayFreqSorted(){
        this.sortByFreq();
        System.out.printf("%-14s%s\n", "NAME", "OCCURRENCES");
        for(nameNode baby : names){
            System.out.printf("%-20s%d\n",baby.getName(),baby.getCount());
        }
    }
}
