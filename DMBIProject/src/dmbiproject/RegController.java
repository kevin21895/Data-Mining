/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbiproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kevin
 */

public class RegController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public double ab;
    @FXML 
    private Button back;
    @FXML
    public Button click;
 

 
    
   @FXML 
    TextField snapdealprice;
    @FXML 
    TextField flipkartprice;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{

            
                         System.out.println("enter the price of flipkart");
                         
                        
                      
        }
        catch(Exception e){

            System.out.println(e);

        }
    
        // TODO
    } 
    
         
        public void handleButtonAction3(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent category_page;
        category_page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene category_scene =new Scene(category_page); 
        Stage category_stage;
        category_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        category_stage.setScene(category_scene);
        category_stage.show();
               
          
    }
         
        public void handleButtonAction4(ActionEvent f) throws ClassNotFoundException, SQLException {
        String value=flipkartprice.getText();
                         System.out.println(value);
                          ab=Double.parseDouble(value);
                        
               Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/price","root","");
            Statement str=con.createStatement();
            ResultSet r = str.executeQuery( "SELECT * from xyz" );
			int i=0;
                        int x[]=new int[121];
			double y[]=new double[121];
			int meanx=0,meany=0;
			while(r.next())
			{
				meanx+=r.getInt(3);
				meany+=r.getInt(4);

			}
			meanx=meanx/x.length;
			meany=meany/y.length;
			double w1num=0;
			double w1deno=0;
			for(i=0;i<x.length;i++){

				w1num=(x[i]-meanx)*(y[i]-meany);
				w1deno=Math.pow(x[i]-meanx,2);
			}
			double w1=w1num/w1deno;
			double w0=meany-(w1*meanx);
                        
			double yn;
			 yn=w0+(w1*meanx);
                         
                          yn=w0+(w1*ab);
			System.out.println("w0 : "+w0+"\nw1 :"+w1);
			System.out.println("MARKET VALUE="+yn);
                        snapdealprice.setText(""+yn);
                         
          
    }  
}
