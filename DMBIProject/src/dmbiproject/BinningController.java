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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kevin
 */
public class BinningController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public   int i=0,y=0,n=0,ft=0,mt=0,gt=0,ff=0,mf=0,gf=0,pt=0,it1=0,ft1=0,pf=0,if1=0,ff1=0,st1=0,gt1=0,et=0,sf1=0,gf1=0,ef=0;

public float a=0.0f,b=0.0f,c=0.0f,d=0.0f,present=0.0f,absent=0.0f;
 
public String class1[]=new String[25];
public String var1,var2;
public  String category[]=new String[25];

public String WB[]=new String[25];
        @FXML 
        public TextField txt1,txt2,txt3,txt4,txt5;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
}
public void mainpage1(ActionEvent event)
{
    try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection Con = null;
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/price","root","");
            } catch (SQLException ex) {
                Logger.getLogger(BinningController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Opened database successfully");
            Statement st=Con.createStatement();
            
            ResultSet rs=st.executeQuery("Select * from abc");
            
            while(rs.next() && i<25)
                
            {
                
                
                class1[i]=rs.getString(6);
                
                category[i]=rs.getString(7);
                
                WB[i]=rs.getString(8);
                
                i++;
                
            }
            
            for(i=0;i<24;i++)
                
            {
                
                if(WB[i].equals("Y"))
                    
                    y++;
                
                else
                    
                    n++;
                
            }
            
            System.out.println(y+ " "+n);
            
            
            
            for(i=0;i<24;i++)
                
            {
                
                if(class1[i].equals("L") && WB[i].equals("Y"))
                    
                {
                    
                    ft++;
                    
                }
                
                if(class1[i].equals("M") && WB[i].equals("Y"))
                    
                {
                    
                    mt++;
                    
                }
                
                if(class1[i].equals("H") && WB[i].equals("Y"))
                    
                {
                    
                    gt++;
                    
                }
                
//price --- no

if(class1[i].equals("L") && WB[i].equals("N"))

{
    
    ff++;
    
}

if(class1[i].equals("M") && WB[i].equals("N"))
    
{
    
    mf++;
    
}

if(class1[i].equals("H") && WB[i].equals("N"))
    
{
    
    gf++;
    
}

//ostype --- yes

if(category[i].equals("E") && WB[i].equals("Y"))

{
    
    pt++;
    
}

if(category[i].equals("HA") && WB[i].equals("Y"))
{
    
    ft1++;
    
}

if(category[i].equals("E") && WB[i].equals("N"))
{it1++;}

if(category[i].equals("HA") && WB[i].equals("N"))
{
    
    pf++;
    
}


System.out.println("\t\t"+class1[i]+"\t"+category[i]+"\t"+WB[i]);

            }
            
            System.out.println("----------------------------------");
            
            System.out.println("Enter class and category");
            
            System.out.println("----------------------------------");
             String var1=txt1.getText();
                         System.out.println(var1);
                       
            
            
            
             var2 = txt2.getText();
              System.out.println(var2);
                        
            
//yes
switch (var1) {
    case "H":
        a = (float)gt/y;
        b=(float)gf/n;
        break;
    case "M":
        a = (float)mt/y;
        b=(float)mf/n;
        break;
    default:
        a = (float)ft/y;
        b=(float)ff/n;
        break;
}

if(var2.equals("E"))

{
    
    c = (float)pt/y;
    
    d=(float)pf/n;
    
}

else
    
{
    
    c = (float)ft1/y;
    
    d=(float)pf/n;
    
}





present = a * c ;

present = present * (float)(y/10.0f);

absent = b * d ;

absent = absent * (float)(n/10.0f);

System.out.println("----------------------");

System.out.println("yes = "+present);
txt3.setText(""+present);

System.out.println("NO = "+absent);
txt4.setText(""+absent);
System.out.println("----------------------");

if(present > absent)

{
    
    System.out.println("The product is worth buying");
    txt5.setText("The product is worth buying");
    
}

else

{
    
    System.out.println("The product isnt woth buying");
     txt5.setText("The product is not worth buying");
    
}       } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BinningController.class.getName()).log(Level.SEVERE, null, ex);
        }

}
		
        // TODO
        
    public void mainpage(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent category_page;
        category_page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene category_scene =new Scene(category_page); 
        Stage category_stage;
        category_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        category_stage.setScene(category_scene);
        category_stage.show();
               
          
    }
}
