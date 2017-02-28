/**
 * Created by silveye on 2/27/17.
 */
import java.util.List;
public class bTree {
    private dataItem mroot;
    private dataItem froot;


    public bTree(List<dataItem> personList){
        for(dataItem temp : personList){

            if (temp.isMale()){
                if (mroot == null){
                    mroot = temp;
                }
            } else {
                if (froot == null){
                    froot = temp;
                }
            }
            dataItem parent = new dataItem("NO", "BAD", 666);
            if (temp.isMale()){
                parent = this.mroot;
            } else {
                parent = this.froot;
            }
            addToTree(temp, parent);

        }
    }

    private void addToTree(dataItem toAdd, dataItem parent){
        if(toAdd.compareTo(parent) < 0){
            if(parent.getlChild() == null){
                parent.setlChild(toAdd);
                toAdd.setParent(parent);
                //System.out.println("set left");
            } else {
                parent = parent.getlChild();
                addToTree(toAdd, parent);
            }

        } else if (toAdd.compareTo(parent) > 0){
            if(parent.getrChild() == null){
                parent.setrChild(toAdd);
                toAdd.setParent(parent);
                //System.out.println("set right");

            } else {
                parent = parent.getrChild();
                addToTree(toAdd, parent);
            }
        } else {
            System.out.println("Is root");
        }
    }

    public void inOrder(dataItem obj){
        if(obj.getlChild() != null){
            inOrder(obj.getlChild());
        }
        System.out.println(obj.getName());

        if(obj.getrChild() != null){
            inOrder(obj.getrChild());
        }
    }

    public dataItem getMroot() {
        return mroot;
    }

    public dataItem getFroot() {
        return froot;
    }
}
