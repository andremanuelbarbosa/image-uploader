package com.andremanuelbarbosa.imageuploader;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.andremanuelbarbosa.imageuploader.dao.ImageUploaderImageDao;
import com.andremanuelbarbosa.imageuploader.domain.ImageUploaderImage;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@Title("Image Uploader")
public class ImageUploaderUI extends UI {

  private static final long serialVersionUID = -1051460108516449006L;

  private final List<ImageUploaderImagePanel> imageUploaderImagePanels = new LinkedList<ImageUploaderImagePanel>();

  @Autowired
  private ImageUploaderImageDao imageUploaderImageDao;

  @Override
  protected void init(VaadinRequest request) {

    final VerticalLayout containerMain = new VerticalLayout();
    setContent(containerMain);

    final VerticalLayout containerImages = new VerticalLayout();
    containerImages.setWidth("800px");
    containerMain.addComponent(containerImages);
    containerMain.setComponentAlignment(containerImages, Alignment.TOP_CENTER);

    HorizontalLayout horizontalLayoutMargin = new HorizontalLayout();
    horizontalLayoutMargin.setHeight("20px");
    containerMain.addComponent(horizontalLayoutMargin);

    HorizontalLayout horizontalLayoutAddAnotherImage = new HorizontalLayout();
    horizontalLayoutAddAnotherImage.setWidth("800px");
    horizontalLayoutAddAnotherImage.setMargin(new MarginInfo(false, false, false, true));
    containerMain.addComponent(horizontalLayoutAddAnotherImage);
    containerMain.setComponentAlignment(horizontalLayoutAddAnotherImage, Alignment.MIDDLE_CENTER);

    Button buttonAddAnotherImage = new Button("Add Another Image", new ClickListener() {

      private static final long serialVersionUID = 1750643219510830323L;

      @Override
      public void buttonClick(ClickEvent event) {

        addImage(containerImages);
      }
    });
    buttonAddAnotherImage.setId("buttonAddAnotherImage");
    horizontalLayoutAddAnotherImage.addComponent(buttonAddAnotherImage);

    addImage(containerImages);

    HorizontalLayout horizontalLayoutUpload = new HorizontalLayout();
    horizontalLayoutUpload.setMargin(true);
    horizontalLayoutUpload.setWidth("1024px");
    containerMain.addComponent(horizontalLayoutUpload);
    containerMain.setComponentAlignment(horizontalLayoutUpload, Alignment.MIDDLE_CENTER);

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

              // imageUploaderImagePanel.getImage().setCaption(
              // imageUploaderImagePanel.getImageUploaderImage().getCaption());
              // imageUploaderImagePanel.getImage().setAlternateText(
              // imageUploaderImagePanel.getImageUploaderImage().getAltTag());

              // TODO
              // imageUploaderImageDao.addImage(null);

              new Notification("Upload Complete", "The Image with file name "
                  + imageUploaderImagePanel.getImageUploaderImage().getFileName() + " has been uploaded.",
                  Notification.Type.TRAY_NOTIFICATION).show(Page.getCurrent());

            } catch (CommitException e) {

              new Notification("Missing Required Fields", "Please fill in the fields marked in red above.",
                  Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
            }
          }
        }
      }
    });

    buttonUpload.setId("buttonUpload");
    horizontalLayoutUpload.addComponent(buttonUpload);
    horizontalLayoutUpload.setComponentAlignment(buttonUpload, Alignment.MIDDLE_RIGHT);
  }

  private void addImage(VerticalLayout container) {

    HorizontalLayout horizontalLayoutMargin = new HorizontalLayout();
    horizontalLayoutMargin.setHeight("20px");
    container.addComponent(horizontalLayoutMargin);

    int index = imageUploaderImagePanels.size();

    final Image image = new Image();
    final ImageUploaderImage imageUploaderImage = new ImageUploaderImage();

    final BeanFieldGroup<ImageUploaderImage> beanFieldGroupImageUploader = new BeanFieldGroup<ImageUploaderImage>(
        ImageUploaderImage.class);
    beanFieldGroupImageUploader.setItemDataSource(imageUploaderImage);

    final ImageUploaderImagePanel imageUploaderImagePanel = new ImageUploaderImagePanel(image, imageUploaderImage,
        beanFieldGroupImageUploader);
    imageUploaderImagePanel.setSizeFull();
    imageUploaderImagePanel.setId("imageUploaderImagePanel" + index);
    container.addComponent(imageUploaderImagePanel);

    GridLayout gridLayoutImage = new GridLayout(2, 3);
    gridLayoutImage.setColumnExpandRatio(0, 0.0f);
    gridLayoutImage.setColumnExpandRatio(1, 0.0f);
    imageUploaderImagePanel.setContent(gridLayoutImage);

    HorizontalLayout horizontalLayoutUpload = new HorizontalLayout();
    horizontalLayoutUpload.setWidth("499px");
    horizontalLayoutUpload.setHeight("150px");
    gridLayoutImage.addComponent(horizontalLayoutUpload);

    ImageUploaderUpload imageUploaderUpload = new ImageUploaderUpload(image, imageUploaderImage);
    Upload upload = new Upload("Image File", imageUploaderUpload);
    upload.setButtonCaption("Browse");
    upload.addSucceededListener(imageUploaderUpload);
    upload.setImmediate(true);
    upload.setId("imageFile" + index);
    horizontalLayoutUpload.addComponent(upload);
    horizontalLayoutUpload.setComponentAlignment(upload, Alignment.MIDDLE_LEFT);
    horizontalLayoutUpload.setMargin(new MarginInfo(false, false, false, true));

    HorizontalLayout horizontalLayoutImage = new HorizontalLayout();
    horizontalLayoutImage.setWidth("299px");
    horizontalLayoutImage.setHeight("150px");
    gridLayoutImage.addComponent(horizontalLayoutImage);

    image.setId("image" + index);
    image.setVisible(false);
    image.setWidth("120px");
    image.setHeight("120px");
    horizontalLayoutImage.addComponent(image);
    horizontalLayoutImage.setComponentAlignment(image, Alignment.MIDDLE_CENTER);

    HorizontalLayout horizontalLayoutFileNameAsAltTagAndCaption = new HorizontalLayout();
    horizontalLayoutFileNameAsAltTagAndCaption.setWidth("499px");
    horizontalLayoutFileNameAsAltTagAndCaption.setHeight("80px");
    horizontalLayoutFileNameAsAltTagAndCaption.setMargin(new MarginInfo(false, false, false, true));
    gridLayoutImage.addComponent(horizontalLayoutFileNameAsAltTagAndCaption);

    Field<?> fieldFileNameAsAltTagAndCaption = beanFieldGroupImageUploader.buildAndBind(
        "Default filename as alt_tag/caption", "fileNameAsAltTagAndCaption");
    fieldFileNameAsAltTagAndCaption.setId("fileNameAsAltTagAndCaption" + index);
    horizontalLayoutFileNameAsAltTagAndCaption.addComponent(fieldFileNameAsAltTagAndCaption);
    horizontalLayoutFileNameAsAltTagAndCaption.setComponentAlignment(fieldFileNameAsAltTagAndCaption,
        Alignment.MIDDLE_LEFT);

    HorizontalLayout horizontalLayoutCaption = new HorizontalLayout();
    horizontalLayoutCaption.setWidth("299px");
    horizontalLayoutCaption.setHeight("80px");
    gridLayoutImage.addComponent(horizontalLayoutCaption);

    AbstractTextField abstractTextFieldCaption = (AbstractTextField) beanFieldGroupImageUploader.buildAndBind(
        "caption", "caption");
    abstractTextFieldCaption.setNullRepresentation("");
    abstractTextFieldCaption.setId("imageCaption" + index);
    abstractTextFieldCaption.setWidth("200px");
    horizontalLayoutCaption.addComponent(abstractTextFieldCaption);
    horizontalLayoutCaption.setComponentAlignment(abstractTextFieldCaption, Alignment.MIDDLE_CENTER);

    HorizontalLayout horizontalLayoutAltTag = new HorizontalLayout();
    horizontalLayoutAltTag.setWidth("299px");
    horizontalLayoutAltTag.setHeight("100px");
    gridLayoutImage.addComponent(horizontalLayoutAltTag, 1, 2);

    AbstractTextField abstractTextFieldAltTag = (AbstractTextField) beanFieldGroupImageUploader.buildAndBind("alt tag",
        "altTag");
    abstractTextFieldAltTag.setNullRepresentation("");
    abstractTextFieldAltTag.setId("imageAltTag" + index);
    abstractTextFieldAltTag.setWidth("200px");
    horizontalLayoutAltTag.addComponent(abstractTextFieldAltTag);
    horizontalLayoutAltTag.setComponentAlignment(abstractTextFieldAltTag, Alignment.TOP_CENTER);

    imageUploaderImagePanels.add(imageUploaderImagePanel);
  }
}
