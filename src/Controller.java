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
            //Files.list(Paths.get(".\\model")).forEach(System.out::println);
            BufferedWriter out = new BufferedWriter(new FileWriter("input.txt"));
            out.append(urlArea.getText() );
            out.append(titleArea.getText() );
            out.append(bodyArea.getText());
            out.close();

            String command = "python passiveAggressive.py .\\model\\passiveAggressive.py";
            Runtime.getRuntime().exec(command);

            //Thread.sleep(5000);

            BufferedReader in = new BufferedReader(new FileReader("output.txt"));
            String output = in.readLine();
            //System.out.println(output);
            if(output.equals("1.0")){
                outputArea.appendText("This news is most likely fake!");
            }else{
                outputArea.appendText("This news appears to be reliable!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
