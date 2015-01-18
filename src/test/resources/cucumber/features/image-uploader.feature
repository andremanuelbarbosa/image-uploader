Feature: Image Uploader

  Scenario: User goes to the Image Uploader home page and sees all the components for the first Image Panel
    When the User navigates to "/"
    Then the User should see all the components for the Image Panel with index "0"
    And the User should see the component with ID "buttonUpload"
    And the User should see the component with ID "buttonAddAnotherImage"

  Scenario: User goes to the Image Uploader home page, clicks on Add Another Image
    and sees all the components for both the first and second Image Panels

    Given the User navigates to "/"
    When the User clicks on the component with ID "buttonAddAnotherImage"
    Then the User should see all the components for the Image Panel with index "0"
    Then the User should see all the components for the Image Panel with index "1"

  Scenario: User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel
    and should see the Image uploaded on the same Panel

    Given the User navigates to "/"
    When the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    Then the User should see the component with ID "image0"

  Scenario: User goes to the Image Uploader home page, selects an invalid Image File (non Image) on the first Image Panel
    and should see an Error Notification about the Invalid Image File

    Given the User navigates to "/"
    When the User selects the Image File "invalid.txt" on the Image Panel with index "0"
    Then the User should see the Error Notification with Title "Invalid Image File" and Message "The selected file is not a valid Image."
    Then the User should not see the component with ID "image0"

  Scenario: User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,
    tries to Upload the Image without caption should see an Error Notification about the Missing Required Fields

    Given the User navigates to "/"
    And the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    And the User should see the component with ID "image0"
    And the User enters the value "alt tag" in component with ID "imageAltTag0"
    When the User clicks on the component with ID "buttonUpload"
    Then the User should see the Error Notification with Title "Missing Required Fields" and Message "Please fill in the fields marked in red above."

  Scenario: User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,
    tries to Upload the Image without alt tag should see an Error Notification about the Missing Required Fields

    Given the User navigates to "/"
    And the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    And the User should see the component with ID "image0"
    And the User enters the value "caption" in component with ID "imageCaption0"
    When the User clicks on the component with ID "buttonUpload"
    Then the User should see the Error Notification with Title "Missing Required Fields" and Message "Please fill in the fields marked in red above."

  Scenario: User goes to the Image Uploader home page, enters both caption and alt tag,
    tries to Upload the Image without an Image File and should see an Error Notification about the Missing Image File

    Given the User navigates to "/"
    And the User enters the value "caption" in component with ID "imageCaption0"
    And the User enters the value "alt_tag" in component with ID "imageAltTag0"
    When the User clicks on the component with ID "buttonUpload"
    Then the User should see the Error Notification with Title "No Image File" and Message "No file has been selected for the Image."

  Scenario: User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,
    enters both caption and alt tag, tries to Upload the Image and should see a Success Notification with the Image File Name as is

    Given the User navigates to "/"
    And the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    And the User should see the component with ID "image0"
    And the User enters the value "caption" in component with ID "imageCaption0"
    And the User enters the value "alt_tag" in component with ID "imageAltTag0"
    When the User clicks on the component with ID "buttonUpload"
    Then the User should see the Success Notification with Title "Upload Complete" and Message "The Image with file name valid.jpg has been uploaded."

  Scenario: User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,
    enters both caption and alt tag, selectes the default file name as alt_tag/caption,
    tries to Upload the Image and should see a Success Notification with the Image File Name as alt_tag/caption

    Given the User navigates to "/"
    And the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    And the User should see the component with ID "image0"
    And the User enters the value "caption" in component with ID "imageCaption0"
    And the User enters the value "alt_tag" in component with ID "imageAltTag0"
    And the User clicks on the component with ID "fileNameAsAltTagAndCaption0"
    When the User clicks on the component with ID "buttonUpload"
    Then the User should see the Success Notification with Title "Upload Complete" and Message "The Image with file name alt_tag/caption has been uploaded."

  @Ignore
  Scenario: User goes to the Image Uploader home page, clicks on Add Another Image,
    selects a valid Image File for both the first and second Image Panels, enters both caption and alt tag for both Image Panels,
    tries to Upload the Images and should see two Success Notifications with the Image File Names as as alt_tag/caption

    Given the User navigates to "/"
    And the User clicks on the component with ID "buttonAddAnotherImage"
    And the User selects the Image File "valid.jpg" on the Image Panel with index "0"
    And the User should see the component with ID "image0"
    And the User enters the value "caption0" in component with ID "imageCaption0"
    And the User enters the value "alt_tag0" in component with ID "imageAltTag0"
    And the User clicks on the component with ID "fileNameAsAltTagAndCaption0"
    And the User selects the Image File "valid.jpg" on the Image Panel with index "1"
    And the User should see the component with ID "image1"
    And the User enters the value "caption1" in component with ID "imageCaption1"
    And the User enters the value "alt_tag1" in component with ID "imageAltTag1"
    And the User clicks on the component with ID "fileNameAsAltTagAndCaption1"
    When the User clicks on the component with ID "buttonUpload"
    Then the User should see the Success Notification with Title "Upload Complete" and Message "The Image with file name alt_tag0/caption0 has been uploaded."
    And the User should see the Success Notification with Title "Upload Complete" and Message "The Image with file name alt_tag1/caption1 has been uploaded."
