import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {

    @FXML
    Button submitButton;
    @FXML
    TextField urlArea;
    @FXML TextField titleArea;
    @FXML
    TextArea bodyArea;
    @FXML
    TextArea outputArea;
    public void submit(){
        try {
            //Files.list(Paths.get(".")).forEach(System.out::println);
            BufferedWriter out = new BufferedWriter(new FileWriter("input.txt"));
            out.append(urlArea.getText() + "\n");
            out.append(titleArea.getText() + "\n");
            out.append(bodyArea.getText());
            out.close();

            String command = "python /c start python ./model/data/passiveAggressive.py";
            Process p = Runtime.getRuntime().exec(command);

            //Thread.sleep(10000);

            BufferedReader in = new BufferedReader(new FileReader("output.txt"));
            String output = in.readLine();
            //System.out.println(output);
            outputArea.appendText(output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
