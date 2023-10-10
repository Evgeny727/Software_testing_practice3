package steps;

import com.practice.testing.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HumanPieceStepdefs {
    char humanSymbol;
    @Given("^User entered y in other function$")
    public void user_entered_y_in_other_function() throws Throwable {
        System.out.println("You entered 'y' and you play first");
    }
    @When("^Gains y as input$")
    public void gains_y_as_input() throws Throwable {
        humanSymbol = TicTacToe.humanPiece('y');
    }
    @Then("^Return X$")
    public void return_x() throws Throwable {
        Assertions.assertEquals('X', humanSymbol);
    }
}
