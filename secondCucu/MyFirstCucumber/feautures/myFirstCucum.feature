Feature: My Fisrt Cucumber Test
 Scenario Outline: Login Test
   Given Launching Browser
   When Entering "<username>"Credentials "<passwrd>" 
   Then Log In

 Examples:
  |username | passwrd|
  |9092913756|Royal@123|
  |9834534943|4fdsfgsg6|
  
  