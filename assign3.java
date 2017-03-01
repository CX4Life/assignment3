import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by silveye on 2/27/17.
 */
public class assign3 {
    public static void main(String[] args) {
        String line;
        List<dataItem> personList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader ("yob2014.txt"));
            while((line = reader.readLine()) != null){

                String name = line.split(",")[0];
                String gender = line.split(",")[1];
                int count = Integer.parseInt(line.split(",")[2]);
                dataItem node = new dataItem(gender, name, count);
                personList.add(node);
            }
        } catch(IOException e) {
            System.out.println("File not found.");
        }
        bTree ourTree = new bTree(personList);
        ourTree.inOrder(ourTree.getMroot());

        //Testing git stuff
    }
}
