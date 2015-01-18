$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("image-uploader.feature");
formatter.feature({
  "id": "image-uploader",
  "description": "",
  "name": "Image Uploader",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 641297574,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page-and-sees-all-the-components-for-the-first-image-panel",
  "description": "",
  "name": "User goes to the Image Uploader home page and sees all the components for the first Image Panel",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "When ",
  "line": 4
});
formatter.step({
  "name": "the User should see all the components for the Image Panel with index \"0\"",
  "keyword": "Then ",
  "line": 5
});
formatter.step({
  "name": "the User should see the component with ID \"buttonUpload\"",
  "keyword": "And ",
  "line": 6
});
formatter.step({
  "name": "the User should see the component with ID \"buttonAddAnotherImage\"",
  "keyword": "And ",
  "line": 7
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 10468714895,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 71
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_all_the_components_for_the_Image_Panel_with_index(String)"
});
formatter.result({
  "duration": 75239159,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonUpload",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 17299108,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonAddAnotherImage",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 19110369,
  "status": "passed"
});
formatter.before({
  "duration": 25730,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-clicks-on-add-another-image",
  "description": "and sees all the components for both the first and second Image Panels",
  "name": "User goes to the Image Uploader home page, clicks on Add Another Image",
  "keyword": "Scenario",
  "line": 9,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 12
});
formatter.step({
  "name": "the User clicks on the component with ID \"buttonAddAnotherImage\"",
  "keyword": "When ",
  "line": 13
});
formatter.step({
  "name": "the User should see all the components for the Image Panel with index \"0\"",
  "keyword": "Then ",
  "line": 14
});
formatter.step({
  "name": "the User should see all the components for the Image Panel with index \"1\"",
  "keyword": "Then ",
  "line": 15
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded1.png");
formatter.result({
  "duration": 10146072126,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonAddAnotherImage",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded2.png");
formatter.result({
  "duration": 152695862,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 71
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_all_the_components_for_the_Image_Panel_with_index(String)"
});
formatter.result({
  "duration": 65021663,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 71
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_all_the_components_for_the_Image_Panel_with_index(String)"
});
formatter.result({
  "duration": 67194424,
  "status": "passed"
});
formatter.before({
  "duration": 15643,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-selects-a-valid-image-file-on-the-first-image-panel",
  "description": "and should see the Image uploaded on the same Panel",
  "name": "User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel",
  "keyword": "Scenario",
  "line": 17,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 20
});
formatter.step({
  "name": "the User selects the Image File \"valid.jpg\" on the Image Panel with index \"0\"",
  "keyword": "When ",
  "line": 21
});
formatter.step({
  "name": "the User should see the component with ID \"image0\"",
  "keyword": "Then ",
  "line": 22
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded3.png");
formatter.result({
  "duration": 10189901803,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "valid.jpg",
      "offset": 33
    },
    {
      "val": "0",
      "offset": 75
    }
  ],
  "location": "ImageUploaderSteps.the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String,String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded4.png");
formatter.result({
  "duration": 10164216652,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "image0",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 16946546,
  "status": "passed"
});
formatter.before({
  "duration": 17342,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-selects-an-invalid-image-file-(non-image)-on-the-first-image-panel",
  "description": "and should see an Error Notification about the Invalid Image File",
  "name": "User goes to the Image Uploader home page, selects an invalid Image File (non Image) on the first Image Panel",
  "keyword": "Scenario",
  "line": 24,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 27
});
formatter.step({
  "name": "the User selects the Image File \"invalid.txt\" on the Image Panel with index \"0\"",
  "keyword": "When ",
  "line": 28
});
formatter.step({
  "name": "the User should see the Error Notification with Title \"Invalid Image File\" and Message \"The selected file is not a valid Image.\"",
  "keyword": "Then ",
  "line": 29
});
formatter.step({
  "name": "the User should not see the component with ID \"image0\"",
  "keyword": "Then ",
  "line": 30
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded5.png");
formatter.result({
  "duration": 10200635141,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "invalid.txt",
      "offset": 33
    },
    {
      "val": "0",
      "offset": 77
    }
  ],
  "location": "ImageUploaderSteps.the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String,String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded6.png");
formatter.result({
  "duration": 10181089524,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Invalid Image File",
      "offset": 55
    },
    {
      "val": "The selected file is not a valid Image.",
      "offset": 88
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_Error_Notification_with_Title_and_Description(String,String)"
});
formatter.result({
  "duration": 47262612,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "image0",
      "offset": 47
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_not_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 9582428,
  "status": "passed"
});
formatter.before({
  "duration": 15176,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-selects-a-valid-image-file-on-the-first-image-panel,",
  "description": "tries to Upload the Image without caption should see an Error Notification about the Missing Required Fields",
  "name": "User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,",
  "keyword": "Scenario",
  "line": 32,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 35
});
formatter.step({
  "name": "the User selects the Image File \"valid.jpg\" on the Image Panel with index \"0\"",
  "keyword": "And ",
  "line": 36
});
formatter.step({
  "name": "the User should see the component with ID \"image0\"",
  "keyword": "And ",
  "line": 37
});
formatter.step({
  "name": "the User enters the value \"alt tag\" in component with ID \"imageAltTag0\"",
  "keyword": "And ",
  "line": 38
});
formatter.step({
  "name": "the User clicks on the component with ID \"buttonUpload\"",
  "keyword": "When ",
  "line": 39
});
formatter.step({
  "name": "the User should see the Error Notification with Title \"Missing Required Fields\" and Message \"Please fill in the fields marked in red above.\"",
  "keyword": "Then ",
  "line": 40
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded7.png");
formatter.result({
  "duration": 10153626826,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "valid.jpg",
      "offset": 33
    },
    {
      "val": "0",
      "offset": 75
    }
  ],
  "location": "ImageUploaderSteps.the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String,String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded8.png");
formatter.result({
  "duration": 10153781483,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "image0",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 16818523,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alt tag",
      "offset": 27
    },
    {
      "val": "imageAltTag0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 46744205,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonUpload",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded9.png");
formatter.result({
  "duration": 166908365,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Missing Required Fields",
      "offset": 55
    },
    {
      "val": "Please fill in the fields marked in red above.",
      "offset": 93
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_Error_Notification_with_Title_and_Description(String,String)"
});
formatter.result({
  "duration": 56172966,
  "status": "passed"
});
formatter.before({
  "duration": 17577,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-selects-a-valid-image-file-on-the-first-image-panel,",
  "description": "tries to Upload the Image without alt tag should see an Error Notification about the Missing Required Fields",
  "name": "User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,",
  "keyword": "Scenario",
  "line": 42,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 45
});
formatter.step({
  "name": "the User selects the Image File \"valid.jpg\" on the Image Panel with index \"0\"",
  "keyword": "And ",
  "line": 46
});
formatter.step({
  "name": "the User should see the component with ID \"image0\"",
  "keyword": "And ",
  "line": 47
});
formatter.step({
  "name": "the User enters the value \"caption\" in component with ID \"imageCaption0\"",
  "keyword": "And ",
  "line": 48
});
formatter.step({
  "name": "the User clicks on the component with ID \"buttonUpload\"",
  "keyword": "When ",
  "line": 49
});
formatter.step({
  "name": "the User should see the Error Notification with Title \"Missing Required Fields\" and Message \"Please fill in the fields marked in red above.\"",
  "keyword": "Then ",
  "line": 50
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded10.png");
formatter.result({
  "duration": 10188466624,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "valid.jpg",
      "offset": 33
    },
    {
      "val": "0",
      "offset": 75
    }
  ],
  "location": "ImageUploaderSteps.the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String,String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded11.png");
formatter.result({
  "duration": 10183080827,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "image0",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 18644310,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "caption",
      "offset": 27
    },
    {
      "val": "imageCaption0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 67802791,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonUpload",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded12.png");
formatter.result({
  "duration": 169627349,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Missing Required Fields",
      "offset": 55
    },
    {
      "val": "Please fill in the fields marked in red above.",
      "offset": 93
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_Error_Notification_with_Title_and_Description(String,String)"
});
formatter.result({
  "duration": 54324210,
  "status": "passed"
});
formatter.before({
  "duration": 16550,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-enters-both-caption-and-alt-tag,",
  "description": "tries to Upload the Image without an Image File and should see an Error Notification about the Missing Image File",
  "name": "User goes to the Image Uploader home page, enters both caption and alt tag,",
  "keyword": "Scenario",
  "line": 52,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 55
});
formatter.step({
  "name": "the User enters the value \"caption\" in component with ID \"imageCaption0\"",
  "keyword": "And ",
  "line": 56
});
formatter.step({
  "name": "the User enters the value \"alt_tag\" in component with ID \"imageAltTag0\"",
  "keyword": "And ",
  "line": 57
});
formatter.step({
  "name": "the User clicks on the component with ID \"buttonUpload\"",
  "keyword": "When ",
  "line": 58
});
formatter.step({
  "name": "the User should see the Error Notification with Title \"No Image File\" and Message \"No file has been selected for the Image.\"",
  "keyword": "Then ",
  "line": 59
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded13.png");
formatter.result({
  "duration": 10195627035,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "caption",
      "offset": 27
    },
    {
      "val": "imageCaption0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 44592115,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alt_tag",
      "offset": 27
    },
    {
      "val": "imageAltTag0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 97714363,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonUpload",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded14.png");
formatter.result({
  "duration": 161427282,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "No Image File",
      "offset": 55
    },
    {
      "val": "No file has been selected for the Image.",
      "offset": 83
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_Error_Notification_with_Title_and_Description(String,String)"
});
formatter.result({
  "duration": 53890345,
  "status": "passed"
});
formatter.before({
  "duration": 27207,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-selects-a-valid-image-file-on-the-first-image-panel,",
  "description": "enters both caption and alt tag, tries to Upload the Image and should see a Success Notification with the Image File Name as is",
  "name": "User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,",
  "keyword": "Scenario",
  "line": 61,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 64
});
formatter.step({
  "name": "the User selects the Image File \"valid.jpg\" on the Image Panel with index \"0\"",
  "keyword": "And ",
  "line": 65
});
formatter.step({
  "name": "the User should see the component with ID \"image0\"",
  "keyword": "And ",
  "line": 66
});
formatter.step({
  "name": "the User enters the value \"caption\" in component with ID \"imageCaption0\"",
  "keyword": "And ",
  "line": 67
});
formatter.step({
  "name": "the User enters the value \"alt_tag\" in component with ID \"imageAltTag0\"",
  "keyword": "And ",
  "line": 68
});
formatter.step({
  "name": "the User clicks on the component with ID \"buttonUpload\"",
  "keyword": "When ",
  "line": 69
});
formatter.step({
  "name": "the User should see the Success Notification with Title \"Upload Complete\" and Message \"The Image with file name valid.jpg has been uploaded.\"",
  "keyword": "Then ",
  "line": 70
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded15.png");
formatter.result({
  "duration": 10179021318,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "valid.jpg",
      "offset": 33
    },
    {
      "val": "0",
      "offset": 75
    }
  ],
  "location": "ImageUploaderSteps.the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String,String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded16.png");
formatter.result({
  "duration": 10158083052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "image0",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 16478344,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "caption",
      "offset": 27
    },
    {
      "val": "imageCaption0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 41546743,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alt_tag",
      "offset": 27
    },
    {
      "val": "imageAltTag0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 64757892,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonUpload",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded17.png");
formatter.result({
  "duration": 169835175,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Upload Complete",
      "offset": 57
    },
    {
      "val": "The Image with file name valid.jpg has been uploaded.",
      "offset": 87
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_Success_Notification_with_Title_and_Message(String,String)"
});
formatter.result({
  "duration": 54728204,
  "status": "passed"
});
formatter.before({
  "duration": 20832,
  "status": "passed"
});
formatter.scenario({
  "id": "image-uploader;user-goes-to-the-image-uploader-home-page,-selects-a-valid-image-file-on-the-first-image-panel,",
  "description": "enters both caption and alt tag, selectes the default file name as alt_tag/caption,\ntries to Upload the Image and should see a Success Notification with the Image File Name as alt_tag/caption",
  "name": "User goes to the Image Uploader home page, selects a valid Image File on the first Image Panel,",
  "keyword": "Scenario",
  "line": 72,
  "type": "scenario"
});
formatter.step({
  "name": "the User navigates to \"/\"",
  "keyword": "Given ",
  "line": 76
});
formatter.step({
  "name": "the User selects the Image File \"valid.jpg\" on the Image Panel with index \"0\"",
  "keyword": "And ",
  "line": 77
});
formatter.step({
  "name": "the User should see the component with ID \"image0\"",
  "keyword": "And ",
  "line": 78
});
formatter.step({
  "name": "the User enters the value \"caption\" in component with ID \"imageCaption0\"",
  "keyword": "And ",
  "line": 79
});
formatter.step({
  "name": "the User enters the value \"alt_tag\" in component with ID \"imageAltTag0\"",
  "keyword": "And ",
  "line": 80
});
formatter.step({
  "name": "the User clicks on the component with ID \"fileNameAsAltTagAndCaption0\"",
  "keyword": "And ",
  "line": 81
});
formatter.step({
  "name": "the User clicks on the component with ID \"buttonUpload\"",
  "keyword": "When ",
  "line": 82
});
formatter.step({
  "name": "the User should see the Success Notification with Title \"Upload Complete\" and Message \"The Image with file name alt_tag/caption has been uploaded.\"",
  "keyword": "Then ",
  "line": 83
});
formatter.match({
  "arguments": [
    {
      "val": "/",
      "offset": 23
    }
  ],
  "location": "ImageUploaderSteps.the_User_navigates_to(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded18.png");
formatter.result({
  "duration": 10173757834,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "valid.jpg",
      "offset": 33
    },
    {
      "val": "0",
      "offset": 75
    }
  ],
  "location": "ImageUploaderSteps.the_User_selects_the_Image_File_on_the_Image_Panel_with_index(String,String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded19.png");
formatter.result({
  "duration": 10178169594,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "image0",
      "offset": 43
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_component_with_ID(String)"
});
formatter.result({
  "duration": 16711778,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "caption",
      "offset": 27
    },
    {
      "val": "imageCaption0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 47645037,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "alt_tag",
      "offset": 27
    },
    {
      "val": "imageAltTag0",
      "offset": 58
    }
  ],
  "location": "ImageUploaderSteps.the_User_enters_the_value_in_component_with_ID(String,String)"
});
formatter.result({
  "duration": 67227618,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "fileNameAsAltTagAndCaption0",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded20.png");
formatter.result({
  "duration": 167921482,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "buttonUpload",
      "offset": 42
    }
  ],
  "location": "ImageUploaderSteps.the_User_clicks_on_the_component_with_ID(String)"
});
formatter.write("http://localhost:8080/image-uploader/");
formatter.embedding("image/png", "embedded21.png");
formatter.result({
  "duration": 152411705,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Upload Complete",
      "offset": 57
    },
    {
      "val": "The Image with file name alt_tag/caption has been uploaded.",
      "offset": 87
    }
  ],
  "location": "ImageUploaderSteps.the_User_should_see_the_Success_Notification_with_Title_and_Message(String,String)"
});
formatter.result({
  "duration": 54320203,
  "status": "passed"
});
});