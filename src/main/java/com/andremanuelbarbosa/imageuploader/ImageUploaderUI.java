package com.andremanuelbarbosa.imageuploader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

public class ImageUploaderUI extends UI {

  private static final long serialVersionUID = -1051460108516449006L;

  @Override
  protected void init(VaadinRequest request) {

    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Button button = new Button("Click Me");
    button.addClickListener(new Button.ClickListener() {

      private static final long serialVersionUID = -6537578271672333832L;

      @Override
      public void buttonClick(ClickEvent event) {
        layout.addComponent(new Label("Thank you for clicking"));
      }
    });
    layout.addComponent(button);

    // Show uploaded file in this placeholder
    final Embedded image = new Embedded("Uploaded Image");
    image.setVisible(false);
    image.setWidth("100px");
    image.setHeight("100px");

    class ImageUploader implements Receiver, SucceededListener {

      private static final long serialVersionUID = 474313711555634049L;

      File file;

      @Override
      public OutputStream receiveUpload(String filename, String mimeType) {
        // Create upload stream
        FileOutputStream fos = null; // Stream to write to
        try {
          // Open the file for writing.
          file = new File("/tmp/" + filename);
          fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
          new Notification("Could not open file<br/>", e.getMessage(), Notification.Type.ERROR_MESSAGE).show(Page
              .getCurrent());
          return null;
        }
        return fos; // Return the output stream to write to
      }

      @Override
      public void uploadSucceeded(SucceededEvent event) {

        // Show the uploaded file in the image viewer
        image.setVisible(true);
        image.setSource(new FileResource(file));
      }
    }

    ImageUploader receiver = new ImageUploader();

    Upload upload = new Upload("Image File", receiver);
    upload.setButtonCaption("Start Upload");
    upload.addSucceededListener(receiver);
    upload.setImmediate(true);

    // Put the components in a panel
    // Panel panel = new Panel("Cool Image Storage");
    // layout.addComponents(upload, image);
    // panel.setContent(layout);

    HorizontalLayout horizontalLayoutUpload = new HorizontalLayout(upload, image);
    horizontalLayoutUpload.setSizeFull();
    layout.addComponent(horizontalLayoutUpload);
  }
}
