package org.churchsource.churchservices.services.songs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.churchsource.churchservices.model.ChurchServiceEntity;
import org.churchsource.churchservices.services.LastChosenServiceViewModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class SongItemFullViewModel implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  private LastChosenServiceViewModel lastChosenService;

  private Integer timesChosenInLastMonth;

  private Integer timesChosenInLastThreeMonths;

  private Integer timesChosenInLastYear;

  private Integer timesChosenInTotal;

  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItem")
  public SongItemFullViewModel(String songCode, int songOrder, Boolean deleted) {
    this.songCode = songCode;
    this.songOrder = songOrder;
  }
}

