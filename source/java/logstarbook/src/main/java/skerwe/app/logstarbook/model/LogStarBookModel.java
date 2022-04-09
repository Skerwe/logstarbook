package skerwe.app.logstarbook.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

public class LogStarBookModel {

  @Getter
  @Setter
  private String id;

  @Getter
  @Setter
  private String title;

  @Getter
  @Setter
  private List<RecordEntryModel> recordEntries;

  @Getter
  @Setter
  private int marker;
}
