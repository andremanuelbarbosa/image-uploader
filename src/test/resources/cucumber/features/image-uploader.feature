Feature: Image Uploader

  @Ignore
  Scenario: User goes to the Image Uploader home page and sees all the components for the first Image Panel
    When the User navigates to "/"
    Then the User should see all the components for the Image Panel with index "0"
    And the User should see the component with ID "buttonUpload"
    And the User should see the component with ID "buttonAddAnotherImage"

  @Ignore
  Scenario: User goes to the Image Uploader home page, clicks on Add Another Image and sees all the components for both the first and second Image Panels
    Given the User navigates to "/"
    When the User clicks on the component with ID "buttonAddAnotherImage"
    Then the User should see all the components for the Image Panel with index "0"
    Then the User should see all the components for the Image Panel with index "1"

  Scenario: User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel and should see the Image uploaded on the same Panel
    Given the User navigates to "/"
    When the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    Then the User should see the component with ID "image0"
