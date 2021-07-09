package com.api.steps.definition;

import com.api.config.DefaultConfig;
import com.api.steps.CommonSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import io.cucumber.datatable.DataTable;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmployeeStepDefiniation {
    @Steps
    private CommonSteps commonSteps;

    private DefaultConfig defaultConfig = new DefaultConfig();

    @When("I request employee service to get all employee detail")
    public void getAllEmployee() {
        commonSteps.getAllEmployeeDetails();
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        assertThat(res, containsString("success"));
        assertThat(res, containsString("Successfully! All records has been fetched."));
    }


    @When("I request employee service to get employee detail")
    public void getEmployeeById(DataTable prefs) {
        commonSteps.getEmployeeById(prefs.asMap(String.class, String.class));
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        assertThat(res, containsString("success"));
        assertThat(res, containsString("Successfully! Record has been fetched."));
        result.then().assertThat().body("data.employee_name", hasToString("Tiger Nixon"));
        result.then().assertThat().body("data.employee_salary", hasToString("320800"));
        result.then().assertThat().body("data.employee_age", hasToString("61"));
        result.then().assertThat().body("data.id", hasToString("1"));
    }

    @When("I request employee service to create employee detail")
    public void create(DataTable prefs) {
        commonSteps.createEmployee(prefs.asMap(String.class, String.class));
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        assertThat(res, containsString("success"));
        assertThat(res, containsString("Successfully! Record has been added"));
        result.then().assertThat().body("data.map", hasKey("name"));
        result.then().assertThat().body("data.map", hasKey("salary"));
        result.then().assertThat().body("data.map", hasKey("age"));
        result.then().assertThat().body("data", hasKey("id"));
        result.then().assertThat().body("$", hasKey("status"));
        result.then().assertThat().body("$", hasKey("message"));
    }

    @When("I request employee service to remove employee detail")
    public void remove(DataTable prefs) {
        commonSteps.removeEmployee(prefs.asMap(String.class, String.class));
        Response result = Serenity.sessionVariableCalled("response");
        String res = result.asString();
        assertThat(res, containsString("success"));
        assertThat(res, containsString("Successfully! Record has been deleted"));
    }


    @Then("the service returns the status code {int}")
    public void responseCode(Integer code) {
        commonSteps.verifyResponseCode();
    }

}
