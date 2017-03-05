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
        for(nameNode baby : names){
            System.out.println(baby.getName());
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
