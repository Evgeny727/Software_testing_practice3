package steps;

import com.practice.testing.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OpponentPieceStepdefs {
    char opponentSymbol;
    @Given("^User gained X$")
    public void user_gained_x() throws Throwable {
        System.out.println("You play with 'X'");
    }
    @When("^Gains X as input$")
    public void gains_x_as_input() throws Throwable {
        opponentSymbol = TicTacToe.opponent('X');
    }
    @Then("^Return O$")
    public void return_o() throws Throwable {
        Assertions.assertEquals('O', opponentSymbol);
    }
}
