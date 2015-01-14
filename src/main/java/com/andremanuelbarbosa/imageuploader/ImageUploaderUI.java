package com.andremanuelbarbosa.imageuploader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.andremanuelbarbosa.imageuploader.dao.ImageUploaderImageDao;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

public class ImageUploaderUI extends UI {

  private static final long serialVersionUID = -1051460108516449006L;

  @Autowired
  private ImageUploaderImageDao imageUploaderImageDao;

  @Override
  protected void init(VaadinRequest request) {

    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    // Show uploaded file in this placeholder
    final Embedded image = new Embedded("Uploaded Image");
    image.setVisible(false);
    image.setWidth("100px");
    image.setHeight("100px");

    class ImageUploader implements Receiver, SucceededListener {

      private static final long serialVersionUID = 474313711555634049L;

      File file;

      ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream();

      @Override
      public OutputStream receiveUpload(String fileName, String mimeType) {

        imageOutputStream.reset();

        return imageOutputStream;

        /*
         * // Create upload stream FileOutputStream fos = null; // Stream to
         * write to try { // Open the file for writing. file = new File("/tmp/"
         * + fileName); fos = new FileOutputStream(file); } catch (final
         * java.io.FileNotFoundException e) { new
         * Notification("Could not open file<br/>", e.getMessage(),
         * Notification.Type.ERROR_MESSAGE).show(Page .getCurrent()); return
         * null; } return fos; // Return the output stream to write to
         */
      }

      @Override
      public void uploadSucceeded(SucceededEvent event) {

        StreamResource.StreamSource imageStreamSource = new StreamResource.StreamSource() {

          private static final long serialVersionUID = 3973938503356892200L;

          @Override
          public InputStream getStream() {
            // TODO Auto-generated method stub
            return new ByteArrayInputStream(imageOutputStream.toByteArray());
          }
        };

        // Show the uploaded file in the image viewer
        image.setVisible(true);
        image.setSource(new StreamResource(imageStreamSource, "aaa"));
        // image.setSource(new FileResource(file));
      }
    }

    ImageUploader uploadReceiver = new ImageUploader();

    Upload upload = new Upload("Image File", uploadReceiver);
    upload.setButtonCaption("Start Upload");
    upload.addSucceededListener(uploadReceiver);
    upload.setImmediate(true);
    upload.setId("ImageFile");

    // Put the components in a panel
    // Panel panel = new Panel("Cool Image Storage");
    // layout.addComponents(upload, image);
    // panel.setContent(layout);

    HorizontalLayout horizontalLayoutUpload = new HorizontalLayout(upload, image);
    horizontalLayoutUpload.setSizeFull();
    layout.addComponent(horizontalLayoutUpload);

    Button buttonUpload = new Button("Upload");

    buttonUpload.addClickListener(new Button.ClickListener() {

      private static final long serialVersionUID = -6537578271672333832L;

      @Override
      public void buttonClick(ClickEvent event) {

        // TODO
        imageUploaderImageDao.addImage(null);
      }
    });

    layout.addComponent(buttonUpload);
  }
}
