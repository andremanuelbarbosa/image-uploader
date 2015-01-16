package com.andremanuelbarbosa.imageuploader;

import com.andremanuelbarbosa.imageuploader.domain.ImageUploaderImage;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

public class ImageUploaderImagePanel extends Panel {

  private static final long serialVersionUID = -7741975776662019578L;

  private final Image image;
  private final ImageUploaderImage imageUploaderImage;
  private final BeanFieldGroup<ImageUploaderImage> beanFieldGroupImageUploader;

  public ImageUploaderImagePanel(Image image, ImageUploaderImage imageUploaderImage,
      BeanFieldGroup<ImageUploaderImage> beanFieldGroupImageUploader) {

    super();

    this.image = image;
    this.imageUploaderImage = imageUploaderImage;
    this.beanFieldGroupImageUploader = beanFieldGroupImageUploader;
  }

  public Image getImage() {

    return image;
  }

  public ImageUploaderImage getImageUploaderImage() {

    return imageUploaderImage;
  }

  public BeanFieldGroup<ImageUploaderImage> getBeanFieldGroupImageUploader() {

    return beanFieldGroupImageUploader;
  }
}
