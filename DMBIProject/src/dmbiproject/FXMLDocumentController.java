/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbiproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kevin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
  private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent category_page;
        category_page = FXMLLoader.load(getClass().getResource("Manhattan.fxml"));
        Scene category_scene =new Scene(category_page); 
        Stage category_stage;
        category_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        category_stage.setScene(category_scene);
        category_stage.show();
               
          
    }
    

    
     @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {
    System.out.println("You clicked me!");
        Parent category_page = FXMLLoader.load(getClass().getResource("reg.fxml"));
        System.out.println("g");
        Scene category_scene =new Scene(category_page); 
        Stage category_stage;
        category_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        category_stage.setScene(category_scene);
        category_stage.show();
               
    }
    
      @FXML
    private void handleButtonAction3(ActionEvent event) throws IOException {
    System.out.println("You clicked me!");
        Parent category_page = FXMLLoader.load(getClass().getResource("binning.fxml"));
        System.out.println("g");
        Scene category_scene =new Scene(category_page); 
        Stage category_stage;
        category_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        category_stage.setScene(category_scene);
        category_stage.show();
               
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
