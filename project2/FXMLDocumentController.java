/*
* 
* NAME: Austin T. Byrd
* DATE: October 2016
* PLATFORM: Windows 10 Pro
* SPECIAL STEPS TO COMPILE: Nope
* BUGS: None
* BRIEF SUMMARY: I used JavaFX Scene Builder to build the scene and based everything off
*                   the demos we did in class. They were very helpful and gave me a great
*                   start. I had to rtfm and google a lot of junk, but it helped me with
*                   the popup window, barchart, and piechart. I made the piechart first
*                   and got that working before I tried connecting the barchart. That
*                   proved a little difficult to link up. I had to use some weird hacky
*                   booleans but it all works perfectly. This wasn't hard. It was just
*                   time-consuming and annoying. Good intro project to JavaFX though.
*                   Was super elated to discover out I didn't have to use arrays/lists.
* 
*/
package project2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    private XYChart.Series mySeries;
    
    @FXML
    private TextField addField;
    
    @FXML
    private TextField deleteField;
    
    @FXML
    private Button resetButton;

    @FXML
    private Button quitButton;
    
    @FXML
    private PieChart myPieChart;

    @FXML
    private BarChart<?, ?> myBarChart;
    
    
    //Function to add the wedge and the bar to the scene
    private void addWedgeAndBar()
    {
        //make a new slice of pie
        PieChart.Data newSlice = new PieChart.Data(addField.getText(), 1);
        //add the slice to the pie
        myPieChart.getData().add(newSlice);
        
        //make a new bar
        final XYChart.Data newBar = new XYChart.Data<String, Integer>(addField.getText().trim(), 1);
        //add the bar to the barchart
        mySeries.getData().add(newBar);
        
        //nice try, labels. go away.
        myPieChart.setLabelsVisible(false);
        
        //if the pie slice is clicked on, add votes
        newSlice.getNode().addEventHandler( MouseEvent.MOUSE_CLICKED,
                
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent e)
                    {
                        //add a vote and use magic to force it into an int
                        int newPieValue = ((int)newSlice.getPieValue())+1;
                        newSlice.setPieValue(newPieValue);
                        
                        //add a vote and use magic to force it into an int
                        int newBarValue = ((int)newBar.getYValue())+1;
                        newBar.setYValue(newBarValue);
                    }
                }
        );
        
        //if the bar is clicked on, add votes
        newBar.getNode().addEventHandler( MouseEvent.MOUSE_CLICKED,
                
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent e)
                    {
                        //add vote and use magic to force it into an int
                        int newPieValue = ((int)newSlice.getPieValue())+1;
                        newSlice.setPieValue(newPieValue);
                        
                        //add vote and use magic to force it into an int
                        int newBarValue = ((int)newBar.getYValue())+1;
                        newBar.setYValue(newBarValue);
                    }
                }
        );
    }
    
    
    @FXML
    public void onEnter(ActionEvent e){
        
        boolean matchFound = false;
        
        //if the enter button is pressed from the addField
        if(addField.getText().length() > 0 && deleteField.getText().length() > 0) {
            addField.setText(""); //reset the addField
            deleteField.setText(""); //reset the deleteField
        
            //life? don't talk to me about life! 
            popupWindow( "ERROR!\n\n"
                    + "Hello User, \n\n"
                    + "     It looks like you tried entering text into both text fields.\n"
                    + "     I'll go ahead and delete it for you. Try again.\n\n"
                    + "XOXO,\n"
                    + "Austin");
                    
            return;
        }
        //if the enter button was pressed for the add field
        else if (e.getSource() == addField) {
            
            if(addField.getText().length() > 0)
            {
                    for ( PieChart.Data w : myPieChart.getData() )
                    {
                        if (w.getName().equals(addField.getText()) )
                        {
                            matchFound = true;
                            //here I am, brain the size of a planet, and they tell me to make popups for users.
                            //call that job satisfaction? cause I don't.
                            popupWindow( "ERROR!\n\n"
                                    + "Hello User, \n\n"
                                    + "     It looks like you tried entering text into both text fields.\n"
                                    + "     I'll go ahead and delete it for you. Try again.\n\n"
                                    + "XOXO,\n"
                                    + "Austin");
                        }
                    }
                    if(!matchFound)
                    {
                        addWedgeAndBar();
                    }
            }
            else 
                //here I am, brain the size of a planet, and they tell me to make popups for users.
                //call that job satisfaction? cause I don't.
                popupWindow( "ERROR!\n\n"
                                    + "Hello User, \n\n"
                                    + "     It looks like you failed to enter any text.\n"
                                    + "     I'll go ahead and delete it for you. Try again.\n\n"
                                    + "XOXO,\n"
                                    + "Austin");
            
        } else if (e.getSource() == deleteField) { //if the enter button was pressed for the delete field
            if(deleteField.getText().length() > 0)
            {
                //int because i'm lazy and it's late and i need to track loops for the bar chart
                int seqNum = 0;
                for ( PieChart.Data w : myPieChart.getData() )
                {
                    if (w.getName().equals(deleteField.getText()) )
                    {
                        myPieChart.getData().remove(w); 
                        
                        mySeries.getData().remove(seqNum);
                        
                        addField.setText("");
                        deleteField.setText("");
                        return;
                    }
                    else
                        seqNum++;
                }
            }
            else
                //i've calculated your chance of survival, but I don't think you'll like it. 
                popupWindow( "ERROR!\n\n"
                                    + "Hello User, \n\n"
                                    + "     It looks like you failed to enter any text.\n"
                                    + "     I'll go ahead and delete it for you. Try again.\n\n"
                                    + "XOXO,\n"
                                    + "Austin");
        }
            addField.setText(""); //reset text
            deleteField.setText(""); //reset text
            
}
    
    //resets all variables by reversing primary thrust on infinite improbability drive
    private void reset() {
        myPieChart.getData().clear();
        myBarChart.getData().clear(); 
        addField.setText("");
        deleteField.setText("");
    }
    
    //sorry, user
    private void popupWindow(String inputText) {
        Scene scene = new Scene(new Group(new Text(25, 25, inputText)));
            
        Stage myStage = new Stage();

        myStage.setTitle("Suck it!"); 
        myStage.setScene(scene); 
        myStage.sizeToScene(); 
        myStage.setMinWidth(400.00);
        myStage.setMinHeight(250.00);
        myStage.showAndWait(); //or .show()

        VBox box = new VBox();
        myStage.setScene(new Scene(box));
    }
    
    
    @FXML
    void updateChart(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        
        //if the user clicks the quit button
        if (clicked == quitButton)
            System.exit(0); //close
        if (clicked == resetButton) //if the user clicks the reset button
            reset(); //reset
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mySeries=new XYChart.Series(); //not sure how these got here but it's really late and i'm tired
        myBarChart.getData().add(mySeries);
    }    
    
}
