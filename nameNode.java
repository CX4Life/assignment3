// Contains all info needed for each baby name

public class nameNode implements Comparable<nameNode>{
    private String name;
    private boolean male = false;
    private int count;
    private nameNode parent = null;
    private nameNode lChild = null;
    private nameNode rChild = null;
    private double freq;


    public nameNode(String gender, String name, int count){
        this.name = name;
        if(gender.equals("M")){
            this.male = true;
        }
        this.count = count;

    }
    public void setFreq(int total){
        this.freq = ((double)this.count / (double)total) * 100.0;
    }
    public double getFreq(){
        return this.freq;
    }
    public int compareNum(nameNode anotherItem) {return anotherItem.getCount() - this.count;}

    public int compareTo(nameNode anotherItem){
        return this.name.compareToIgnoreCase(anotherItem.getName());
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return male;
    }

    public int getCount() {
        return count;
    }

    public nameNode getlChild() {
        return lChild;
    }

    public void setlChild(nameNode lChild) {
        this.lChild = lChild;
    }

    public void setrChild(nameNode rChild) {
        this.rChild = rChild;
    }

    public nameNode getrChild() {
        return rChild;
    }
    public String showInfo(){
        String gen = "F";
        if (this.isMale()){
            gen = "M";
        }
        return  String.format("%1$-15s %2$1s %3$-11d %4$.4f",
                name, gen, count, freq);
    }

    public void setParent(nameNode parent) {
        this.parent = parent;
    }
}
