// Contains all info needed for each baby name

public class nameNode implements Comparable<nameNode>{
    private String name;
    private boolean male;
    private int count;
    private nameNode parent = null;
    private nameNode lChild = null;
    private nameNode rChild = null;


    public nameNode(String gender, String name, int count){
        this.name = name;
        if(gender.equals("M")){
            this.male = true;
        } else {
            this.male = false;
        }
        this.count = count;

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

    public void setParent(nameNode parent) {
        this.parent = parent;
    }
}
