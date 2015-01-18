package com.andremanuelbarbosa.imageuploader.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ImageUploaderImage implements Serializable {

  private static final long serialVersionUID = 3993220140483287735L;

  private byte[] content = new byte[0];

  @NotNull
  private String caption;

  @NotNull
  private String altTag;

  private String fileName;

  private boolean fileNameAsAltTagAndCaption = false;

  public byte[] getContent() {

    return content;
  }

  public void setContent(byte[] content) {

    this.content = content;
  }

  public String getCaption() {

    return caption;
  }

  public void setCaption(String caption) {

    this.caption = caption;
  }

  public String getAltTag() {

    return altTag;
  }

  public void setAltTag(String altTag) {

    this.altTag = altTag;
  }

  public String getFileName() {
    
    return fileName;
  }

  public void setFileName(String fileName) {
    
    this.fileName = fileName;
  }

  public boolean isFileNameAsAltTagAndCaption() {

    return fileNameAsAltTagAndCaption;
  }

  public void setFileNameAsAltTagAndCaption(boolean fileNameAsAltTagAndCaption) {

    this.fileNameAsAltTagAndCaption = fileNameAsAltTagAndCaption;
  }
}
