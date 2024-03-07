Feature: Automation of dummyapi
  I want to automate the Get, Post, Put, Patch, Del methods of dummyapi

  Scenario: Get employee
    When i queriying employees
    Then employees are displayed

  Scenario: Get employe by id
    When i queriyin a employ by id
    Then the employ is displayed

  Scenario: Create a employe
    When i create an user
      | name | salary | age |
      ##@externaldata@./src/test/resources/datadriven/data.xlsx@create
   |Ronald   |1000   |20|
    Then i should see success create

  Scenario: Update user with put method
    When i update an user with Put method
      | name | salary | age |
      ##@externaldata@./src/test/resources/datadriven/data.xlsx@update
   |testPut   |3000   |23|
    Then i should see success update

  Scenario: Delete an user
    When i delete an user
    Then i should see success deleted
