Feature: Free CRM Login Page Feature

Scenario: Free CRM Login Page Title
Given User is on Free CRM Application Login Page
Then title of the page should be "Free CRM - CRM software for customer relationship management, sales, and support."

Scenario: Free CRM Login Page Header Verification
Given User is on Free CRM Application Login Page
Then Following Page Headers should be displayed on Login Page
| Home | Sign Up | Pricing | Features | Customers | Contact |

Scenario: Free CRM Login Test
Given User is on Free CRM Application Login Page
When User enters the username as "groupautomation"
And User enters the password as "test@12345"
And User clicks on the Login Button
Then User is navigated to the Home Page successfully
