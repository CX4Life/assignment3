/* Implementation of a tree for search and display
 * relies upon the nameNode having left and right
 * child nodes as a property
 */

import java.util.HashSet;
import java.util.List;
public class nameTree {
    private nameNode root;

    public nameTree(HashSet<nameNode> personList, int b){
        for (nameNode temp : personList) {
            if (root == null) {
                root = temp;
            } else {
                if(b==1 || b==3) {
                    buildAlphaTree(temp, root);
                } else {
                    buildFreqTree(temp, root);
                }
            }
        }

    }

    public nameNode getRoot(){return root;}

    // Need to combine trees to have all names listed alphabetically regardless of gender
    // Need to write search method
    // Need to display things as required

    private void buildAlphaTree(nameNode toAdd, nameNode parent){
        if(toAdd.getName().compareToIgnoreCase(parent.getName()) > 0){
            if (parent.getrChild() == null){
                parent.setrChild(toAdd);
            } else {
                buildAlphaTree(toAdd, parent.getrChild());
            }
        } else {
            if (parent.getlChild() == null){
                parent.setlChild(toAdd);
            } else {
                buildAlphaTree(toAdd, parent.getlChild());
            }
        }
    }

    private nameNode[] search(String name){
        nameNode[] ret = new nameNode[2];
        nameNode checkNode = this.root;
        while(checkNode != null){
            if (checkNode.getName().equals(name)){
                ret[0] = checkNode;
                if(checkNode.getlChild() != null && checkNode.getlChild().getName().equals(name)) {
                    ret[1] = checkNode.getlChild();
                }
                return ret;
            } else if (checkNode.getName().compareToIgnoreCase(name) < 0){
                checkNode = checkNode.getrChild();
            } else {
                checkNode = checkNode.getlChild();
            }
        }
        return ret;
    }

    public void displaySearch(String name){
        nameNode[] results = search(name);
        if(results[0] == null){
            System.out.println(name + " not found");
        } else if (results[1] == null){
            System.out.println(results[0].showInfo());
        } else {
            System.out.println(results[0].showInfo());
            System.out.println(results[1].showInfo());
        }
    }

    public void buildFreqTree(nameNode toAdd, nameNode parent){
        if(toAdd.getCount() <= parent.getCount()){
            if (parent.getrChild() == null){
                parent.setrChild(toAdd);
            } else {
                buildFreqTree(toAdd, parent.getrChild());
            }
        } else {
            if (parent.getlChild() == null){
                parent.setlChild(toAdd);
            } else {
                buildFreqTree(toAdd, parent.getlChild());
            }
        }
    }

    public void inOrder(nameNode obj){
        if(obj.getlChild() != null){
            inOrder(obj.getlChild());
        }
        System.out.println(obj.showInfo());
        if(obj.getrChild() != null){
            inOrder(obj.getrChild());
        }
    }

}
