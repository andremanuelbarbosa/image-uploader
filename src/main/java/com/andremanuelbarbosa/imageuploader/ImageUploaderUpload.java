package com.andremanuelbarbosa.imageuploader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.andremanuelbarbosa.imageuploader.domain.ImageUploaderImage;
import com.vaadin.server.Page;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class ImageUploaderUpload implements Receiver, SucceededListener {

  private static final long serialVersionUID = 474313711555634049L;

  private final Image image;
  private final ImageUploaderImage imageUploaderImage;
  private final ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream();

  public ImageUploaderUpload(Image image, ImageUploaderImage imageUploaderImage) {

    this.image = image;
    this.imageUploaderImage = imageUploaderImage;
  }

  @Override
  public OutputStream receiveUpload(String fileName, String mimeType) {

    imageOutputStream.reset();

    if (mimeType.startsWith("image/")) {

      imageUploaderImage.setFileName(fileName);

      return imageOutputStream;

    } else {

      try {

        return null;

      } finally {

        new Notification("Invalid Image File", "The selected file is not a valid Image.",
            Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
      }
    }
  }

  @Override
  public void uploadSucceeded(SucceededEvent succeededEvent) {

    imageUploaderImage.setContent(imageOutputStream.toByteArray());

    image.setSource(new StreamResource(new StreamResource.StreamSource() {

      private static final long serialVersionUID = 3973938503356892200L;

      @Override
      public InputStream getStream() {

        return new ByteArrayInputStream(imageUploaderImage.getContent());
      }
    }, imageUploaderImage.getFileName()));

    image.setVisible(true);
  }
}
