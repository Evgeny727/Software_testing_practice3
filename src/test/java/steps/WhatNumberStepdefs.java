package steps;

import com.practice.testing.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WhatNumberStepdefs {

    boolean isIncorrectNumber;
    @Given("^Place with size 9x9$")
    public void place_with_size_9x9() throws Throwable {
        System.out.println("Enter the number (0 - 8): ");
    }
    @When("^User enter (\\d+)$")
    public void user_enter(int number) throws Throwable {
        isIncorrectNumber = TicTacToe.askNumberTest(number, 8 , 0);
    }
    @Then("^Return false$")
    public void return_false() throws Throwable {
        Assertions.assertFalse(isIncorrectNumber);
    }
}
