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
import java.util.Scanner;
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

public class ManhattanController implements Initializable {

    /**
     * Initializes the controller class.
     */
 public static int count1,count2,count3,count4;
public static int d[];
public static int k[][];
public static int tempk[][];
 public static double m[];
public static double diff[];
public static int n,p;
 @FXML 
 TextArea txt3,txt4;
 @FXML 
 TextField txt1,txt2;

 public static int cal_diff(int a)
{
int temp1=0;
for(int i=0;i<p;i++)
{
if(a>m[i])
diff[i]=a-m[i];
else
diff[i]=m[i]-a;
}
int val=0;
double temp=diff[0];
for(int i=0;i<p;++i)
{
if(diff[i]<temp)
{
temp=diff[i];
val=i;
}
}
return val;
}

 public static void cal_mean() 
{
for(int i=0;i<p;++i)
m[i]=0; 
int cnt=0;
for(int i=0;i<p;++i)
{
cnt=0;
for(int j=0;j<n-1;++j)
{
if(k[i][j]!=-1)
{
m[i]+=k[i][j];
++cnt;
}}
m[i]=m[i]/cnt;
}
}

 public static int check1() 
{
for(int i=0;i<p;++i)
for(int j=0;j<n;++j)
if(tempk[i][j]!=k[i][j])
{
return 0;
}
return 1;
}

    public void initialize(URL url, ResourceBundle rb) {
      
        
    } 
    
     public void clusterr(ActionEvent event)
     {
         n=50;
int ii=0;
d=new int[50];
try
		{
			Class.forName("com.mysql.jdbc.Driver");  

Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/price","root","");  
int z=0;	
Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from xyz");
		
			while(rs.next() && z<50)
			{
				
				d[ii] = rs.getInt(3);
				
				ii++;	
				z=0;
			}
		}
           
		catch(Exception e)
		{
			System.out.println();
		}

//System.out.println("Enter the number of clusters: ");
p=2;
int x;
k=new int[p][n];
tempk=new int[p][n];
m=new double[p];
diff=new double[p];

for(x=0;x<=1;x++)
{if(x==0)

{
    System.out.println("enter the initial centroids");
String value=txt1.getText();
                         System.out.println(value);
                          m[x]=Double.parseDouble(value);
}
                         
                          if(x==1)
                          {
String value1=txt2.getText();
                         System.out.println(value1);
                          m[x++]=Double.parseDouble(value1);
                          }
}


/*for(int i=0;i<p;++i)
{
m[i]=d[i];
System.out.println("The initial values are:");
System.out.println(m[i]);
}*/

int temp=0;
int flag=0;
do
{
for(int i=0;i<p;++i)
for(int j=0;j<n;++j)
{
k[i][j]=-1;
}
for(int i=0;i<n;++i) 
{
temp=cal_diff(d[i]);
if(temp==0)
k[temp][count1++]=d[i];
else
if(temp==1)
k[temp][count2++]=d[i];
else
if(temp==2)
k[temp][count3++]=d[i];
else
if(temp==3)
k[temp][count4++]=d[i];
}
cal_mean(); 
flag=check1(); 
if(flag!=1)

for(int i=0;i<p;++i)
for(int j=0;j<n;++j)
tempk[i][j]=k[i][j];

System.out.println("\n\nAt this step");
System.out.println("\nValue of clusters");
for(int i=0;i<p;++i)
{
System.out.print("K"+(i+1)+"{ ");
for(int j=0;k[i][j]!=-1 && j<n-1;++j)
System.out.print(k[i][j]+" ");
System.out.println("}");
}
System.out.println("\nValue of m ");
for(int i=0;i<p;++i)
System.out.print("m"+(i+1)+"="+m[i]+"  ");

count1=0;count2=0;count3=0;
}
while(flag==0);

System.out.println("\n\n\nThe Final Clusters By Kmeans are as follows: ");
for(int i=0;i<p;++i)
{
System.out.print("K"+(i+1)+"{ ");
for(int j=0;k[i][j]!=-1 && j<n-1;++j)
{ 
    if(i==0)
    {
System.out.print(k[i][j]+" ");
txt3.setText(txt3.getText()+"\n"+k[i][j]);
    }
    if(i==1)
    {
        System.out.print(k[i][j]+" ");
txt4.setText(txt4.getText()+"\n"+k[i][j]);
    }   
}
System.out.println("}");
System.out.println(m[i]);
}
     }
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
