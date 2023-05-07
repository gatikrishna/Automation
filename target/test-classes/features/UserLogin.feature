Feature: To verify User Login

  @UserLogin
  Scenario: User logs into application
    Given User login to the application using "indraku" and "Password@1"
    When User "get" details of "employee"
      | employeeId | 2c1b4124-36bd-4d91-a1d6-d55281a0e862 |
    Then Verify status code as "200"

