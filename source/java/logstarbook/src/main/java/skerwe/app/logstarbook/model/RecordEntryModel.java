package skerwe.app.logstarbook.model;

import lombok.Getter;
import lombok.Setter;

public class RecordEntryModel {

  @Getter
  @Setter
  private String id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private int value;
}
