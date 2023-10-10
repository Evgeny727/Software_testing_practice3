package steps;

import com.practice.testing.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WhoFirstStepdefs {

    boolean isFirstOrSecond;

    @Given("^Question was asked$")
    public void question_was_asked() throws Throwable {
        System.out.println("Would you like to play first? (y/n): ");
    }

    @When("^User enter 'y'$")
    public void user_enter_y() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        isFirstOrSecond = TicTacToe.askYesNoTest('y');
    }

    @Then("^User play first$")
    public void user_play_first() throws Throwable {
        Assertions.assertFalse(isFirstOrSecond);
    }
}
