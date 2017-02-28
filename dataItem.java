/**
 * Created by silveye on 2/27/17.
 */
public class dataItem implements Comparable<dataItem>{
    private String name;
    private boolean male;
    private int count;
    private dataItem parent = null;
    private dataItem lChild = null;
    private dataItem rChild = null;


    public dataItem(String gender, String name, int count){
        this.name = name;
        if(gender.equals("M")){
            this.male = true;
        } else {
            this.male = false;
        }
        this.count = count;

    }
    public int compareTo(dataItem anotherItem){
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

    public dataItem getlChild() {
        return lChild;
    }

    public void setlChild(dataItem lChild) {
        this.lChild = lChild;
    }

    public void setrChild(dataItem rChild) {
        this.rChild = rChild;
    }

    public dataItem getrChild() {
        return rChild;

    }

    public void setParent(dataItem parent) {
        this.parent = parent;
    }
}
