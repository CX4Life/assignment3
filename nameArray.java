// Class for using
// an ArrayList as the data structure
// for our baby names

import java.util.*;

public class nameArray {
    private List<nameNode> names = new ArrayList<>();

    public nameArray(List<nameNode> existing){
        names = existing;
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

    public nameNode[] search(String name){ // uses binary search to find given name
        nameNode[] ret = new nameNode[2];
        this.sortByName();
        int max, min;
        min = 0;
        max = names.size();
        nameNode badBaby = new nameNode("M", "NOTFOUND", 666);
        ret[0] = badBaby;
        ret[1] = badBaby;
        while(min < max){
            int piv = ((max - min) / 2) + min;
            nameNode baby = names.get(piv);
            if (baby.getName().equals(name)) {
                ret[0] = baby;
                if (names.get(piv + 1).getName().equals(name)){ // check if there's a duplicate
                    ret[1] = names.get(piv + 1);                // of the given name (different
                }                                               // gender)
                if (names.get(piv - 1).getName().equals(name)){
                    ret[1] = names.get(piv - 1);
                }
                return ret;
            } else if (baby.getName().compareToIgnoreCase(name) < 0){
                min = piv + 1;
            } else {
                max = piv;
            }
        }
        return ret;
    }

    public void displaySearchResults(String findName){
        nameNode[] searchedFor = this.search(findName);
        if (searchedFor[0].getName().equals("NOTFOUND")){
            System.out.println(findName + " not found");
        } else {
            String head = String.format("%1$-10s %2$1s %3$7s %4$5s", "NAME", "GENDER", "OCCURRENCES", "%");
            System.out.println(head);
            System.out.println(searchedFor[0].showInfo());
            if (!searchedFor[1].getName().equals("NOTFOUND")){
                System.out.println(searchedFor[1].showInfo());
            }
        }
    }
    private void generalDisplay(){
        String head = String.format("%1$-10s %2$1s %3$7s %4$5s", "NAME", "GENDER", "OCCURRENCES", "%");
        System.out.println(head);
        for(nameNode baby : names){
            System.out.println(baby.showInfo());
        }
    }

    public void displayAlphaSorted(){
        this.sortByName();
        this.generalDisplay();
    }
    public void displayFreqSorted(){
        this.sortByFreq();
        this.generalDisplay();
    }
}
