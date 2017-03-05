/* Implementation of a tree for search and display
 * relies upon the nameNode having left and right
 * child nodes as a property
 */

import java.util.List;
public class nameTree {
    private nameNode mroot;
    private nameNode froot;
    public static int femaleFreq;
    public static int maleFreq;

    public nameTree(List<nameNode> personList, int choice){
        maleFreq = 0;
        femaleFreq = 0;

        for(nameNode temp : personList){

            if (temp.isMale()){
                if (mroot == null){
                    mroot = temp;
                }
            } else {
                if (froot == null){
                    froot = temp;
                }
            }
            nameNode parent = new nameNode("NO", "BAD", 666);
            if (temp.isMale()){
                parent = this.mroot;
            } else {
                parent = this.froot;
            }

            addToTree(temp, parent, choice);
        }
    }

    // Need to combine trees to have all names listed alphabetically regardless of gender
    // Need to write search method
    // Need to display things as required

    private void addToTree(nameNode toAdd, nameNode parent, int choice){
        if (choice == 1 || choice == 3){
            if(toAdd.compareTo(parent) < 0){
                if(parent.getlChild() == null){
                    parent.setlChild(toAdd);
                    if(toAdd.isMale()){
                        maleFreq += toAdd.getCount();
                    } else {
                        femaleFreq += toAdd.getCount();
                    }
                    toAdd.setParent(parent);
                    //System.out.println("set left");
                } else {
                    parent = parent.getlChild();
                    addToTree(toAdd, parent, choice);
                }

            } else if (toAdd.compareTo(parent) > 0){
                if(parent.getrChild() == null){
                    parent.setrChild(toAdd);
                    toAdd.setParent(parent);
                    if(toAdd.isMale()){
                        maleFreq += toAdd.getCount();
                    } else {
                        femaleFreq += toAdd.getCount();
                    }
                    //System.out.println("set right");

                } else {
                    parent = parent.getrChild();
                    addToTree(toAdd, parent, choice);
                }
            } else {
                System.out.println("Is root");
            }
        } else {
            if(toAdd.compareNum(parent) < 0){
                if(parent.getlChild() == null){
                    parent.setlChild(toAdd);
                    toAdd.setParent(parent);
                    if(toAdd.isMale()){
                        maleFreq += toAdd.getCount();
                    } else {
                        femaleFreq += toAdd.getCount();
                    }
                    //System.out.println("set left");
                } else {
                    parent = parent.getlChild();
                    addToTree(toAdd, parent, choice);
                }

            } else if (toAdd.compareNum(parent) > 0){
                if(parent.getrChild() == null){
                    parent.setrChild(toAdd);
                    toAdd.setParent(parent);
                    if(toAdd.isMale()){
                        maleFreq += toAdd.getCount();
                    } else {
                        femaleFreq += toAdd.getCount();
                    }
                    //System.out.println("set right");

                } else {
                    parent = parent.getrChild();
                    addToTree(toAdd, parent, choice);
                }
        }

    }}

    public void inOrder(nameNode obj, int choice){
        if(obj.getlChild() != null){
            inOrder(obj.getlChild(), choice);
        }
        if(choice == 2){
            double per;
            if(obj.isMale()){
                per = ((double)obj.getCount() / (double)maleFreq) * 100.0;
            } else {
                per = ((double)obj.getCount() / (double)femaleFreq) * 100.0;
            }
            System.out.println(obj.getName() + " " + obj.getCount() + " " + per +"%");
        } else {
            System.out.println(obj.getName());
        }

        if(obj.getrChild() != null){
            inOrder(obj.getrChild(), choice);
        }
    }

    public nameNode getMroot() {
        return mroot;
    }

    public nameNode getFroot() {
        return froot;
    }
}
