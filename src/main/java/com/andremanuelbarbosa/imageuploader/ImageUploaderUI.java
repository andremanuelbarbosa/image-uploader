package com.andremanuelbarbosa.imageuploader;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.andremanuelbarbosa.imageuploader.dao.ImageUploaderImageDao;
import com.andremanuelbarbosa.imageuploader.domain.ImageUploaderImage;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

public class ImageUploaderUI extends UI {

  private static final long serialVersionUID = -1051460108516449006L;

  private final List<ImageUploaderImagePanel> imageUploaderImagePanels = new LinkedList<ImageUploaderImagePanel>();

  @Autowired
  private ImageUploaderImageDao imageUploaderImageDao;

  @Override
  protected void init(VaadinRequest request) {

    final VerticalLayout containerMain = new VerticalLayout();
    containerMain.setSizeFull();
    setContent(containerMain);

    final VerticalLayout containerImages = new VerticalLayout();
    containerImages.setSizeFull();
    containerMain.addComponent(containerImages);

    final VerticalLayout containerButtons = new VerticalLayout();
    containerButtons.setSizeFull();
    containerMain.addComponent(containerButtons);

    addImage(containerImages);

    Button buttonAddAnotherImage = new Button("Add Another Image", new ClickListener() {

      private static final long serialVersionUID = 1750643219510830323L;

      @Override
      public void buttonClick(ClickEvent event) {

        addImage(containerImages);
      }
    });

    buttonAddAnotherImage.setId("buttonAddAnotherImage");
    containerButtons.addComponent(buttonAddAnotherImage);

    Button buttonUpload = new Button("Upload", new ClickListener() {

      private static final long serialVersionUID = -1335967865398243949L;

      @Override
      public void buttonClick(ClickEvent event) {

        for (ImageUploaderImagePanel imageUploaderImagePanel : imageUploaderImagePanels) {

          if (imageUploaderImagePanel.getImageUploaderImage().getContent() == null
              || imageUploaderImagePanel.getImageUploaderImage().getContent().length == 0) {

            new Notification("No Image File", "No file has been selected for the Image.",
                Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());

          } else {

            try {

              imageUploaderImagePanel.getBeanFieldGroupImageUploader().commit();

              if (imageUploaderImagePanel.getImageUploaderImage().isFileNameAsAltTagAndCaption()) {

                imageUploaderImagePanel.getImageUploaderImage().setFileName(
                    imageUploaderImagePanel.getImageUploaderImage().getAltTag() + "/"
                        + imageUploaderImagePanel.getImageUploaderImage().getCaption());
              }

              imageUploaderImagePanel.getImage().setCaption(
                  imageUploaderImagePanel.getImageUploaderImage().getCaption());
              imageUploaderImagePanel.getImage().setAlternateText(
                  imageUploaderImagePanel.getImageUploaderImage().getAltTag());

              // TODO
              // imageUploaderImageDao.addImage(null);

            } catch (CommitException e) {

              e.printStackTrace();
            }
          }
        }
      }
    });

    buttonUpload.setId("buttonUpload");
    containerButtons.addComponent(buttonUpload);
  }

  private void addImage(VerticalLayout container) {

    int index = imageUploaderImagePanels.size();

    final Image image = new Image();
    final ImageUploaderImage imageUploaderImage = new ImageUploaderImage();
    final BeanFieldGroup<ImageUploaderImage> beanFieldGroupImageUploader = new BeanFieldGroup<ImageUploaderImage>(
        ImageUploaderImage.class);

    final ImageUploaderImagePanel imageUploaderImagePanel = new ImageUploaderImagePanel(image, imageUploaderImage,
        beanFieldGroupImageUploader);

    imageUploaderImagePanel.setSizeUndefined();
    imageUploaderImagePanel.setId("imageUploaderImagePanel" + index);
    container.addComponent(imageUploaderImagePanel);

    GridLayout gridLayoutImage = new GridLayout(2, 3);
    gridLayoutImage.setMargin(true);
    gridLayoutImage.setSpacing(true);
    imageUploaderImagePanel.setContent(gridLayoutImage);

    // FormLayout formLayoutImage = new FormLayout();
    // formLayoutImage.setSizeUndefined();
    // formLayoutImage.setMargin(true);
    // imageUploaderImagePanel.setContent(formLayoutImage);

    ImageUploaderUpload imageUploaderUpload = new ImageUploaderUpload(image, imageUploaderImage);
    Upload upload = new Upload("Image File", imageUploaderUpload);
    upload.setButtonCaption(null);
    upload.addSucceededListener(imageUploaderUpload);
    upload.setImmediate(true);
    upload.setId("imageFile" + index);
    gridLayoutImage.addComponent(upload);

    image.setId("image" + index);
    image.setVisible(false);
    image.setWidth("100px");
    image.setHeight("100px");
    gridLayoutImage.addComponent(image);

    // HorizontalLayout horizontalLayoutUpload = new HorizontalLayout(upload,
    // image);
    // horizontalLayoutUpload.setSizeFull();
    // formLayoutImage.addComponent(horizontalLayoutUpload);

    beanFieldGroupImageUploader.setItemDataSource(imageUploaderImage);

    AbstractTextField abstractTextFieldCaption = (AbstractTextField) beanFieldGroupImageUploader.buildAndBind(
        "caption", "caption");
    abstractTextFieldCaption.setNullRepresentation("");
    abstractTextFieldCaption.setId("imageCaption" + index);

    AbstractTextField abstractTextFieldAltTag = (AbstractTextField) beanFieldGroupImageUploader.buildAndBind("alt tag",
        "altTag");
    abstractTextFieldAltTag.setNullRepresentation("");
    abstractTextFieldAltTag.setId("imageAltTag" + index);

    gridLayoutImage.addComponent(beanFieldGroupImageUploader.buildAndBind("Default filename as alt_tag/caption",
        "fileNameAsAltTagAndCaption"));
    gridLayoutImage.addComponent(abstractTextFieldCaption);
    gridLayoutImage.addComponent(abstractTextFieldAltTag);

    // formLayoutImage.addComponent(abstractTextFieldCaption);
    // formLayoutImage.addComponent(abstractTextFieldAltTag);
    // formLayoutImage.addComponent(beanFieldGroupImageUploader.buildAndBind("Default filename as alt_tag/caption",
    // "fileNameAsAltTagAndCaption"));

    imageUploaderImagePanels.add(imageUploaderImagePanel);
  }
}
