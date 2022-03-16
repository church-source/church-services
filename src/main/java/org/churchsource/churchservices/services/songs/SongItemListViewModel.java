package org.churchsource.churchservices.services.songs;

import lombok.*;
import org.churchsource.churchservices.services.LastChosenServiceViewModel;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class SongItemListViewModel implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItem")
  public SongItemListViewModel(String songCode, int songOrder, Boolean deleted) {
    this.songCode = songCode;
    this.songOrder = songOrder;
  }
}

