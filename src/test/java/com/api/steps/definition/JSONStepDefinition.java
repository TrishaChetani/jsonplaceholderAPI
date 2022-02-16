package com.api.steps.definition;

import com.api.config.DefaultConfig;
import com.api.steps.CommonSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasToString;

public class JSONStepDefinition {
    @Steps
    private CommonSteps commonSteps;

    private DefaultConfig defaultConfig = new DefaultConfig();

    @When("I request the service to get all post detail")
    public void getAllEmployee() {
        commonSteps.getAllEmployeeDetails();
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        assertThat(res, containsString("userId"));
        assertThat(res, containsString("id"));
        assertThat(res, containsString("title"));
        assertThat(res, containsString("body"));
    }


    @When("I request the service to get post detail by Id")
    public void getEmployeeById(DataTable prefs) {
        commonSteps.getEmployeeById(prefs.asMap(String.class, String.class));
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        result.then().assertThat().body("$", hasKey("userId"));
        result.then().assertThat().body("$", hasKey("id"));
        result.then().assertThat().body("$", hasKey("title"));
        result.then().assertThat().body("$", hasKey("body"));
    }

    @When("I request the service to create post detail")
    public void create(DataTable prefs) {
        commonSteps.createEmployee(prefs.asMap(String.class, String.class));
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        result.then().assertThat().body("map", hasKey("title"));
        result.then().assertThat().body("map", hasKey("body"));
        result.then().assertThat().body("map", hasKey("userId"));
    }

    @When("I request the service to remove post detail by Id")
    public void remove(DataTable prefs) {
        commonSteps.removeEmployee(prefs.asMap(String.class, String.class));
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        assertThat(res, containsString(""));
    }


    @Then("the service returns the status code {int}")
    public void responseCode(Integer code) {
        commonSteps.verifyResponseCode(code);
    }

}


