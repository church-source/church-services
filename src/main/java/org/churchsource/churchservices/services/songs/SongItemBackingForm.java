package org.churchsource.churchservices.services.songs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.churchsource.churchservices.model.ChurchServiceEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class SongItemBackingForm implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItemBackingForm")
  public SongItemBackingForm(String songCode, int songOrder) {
    this.songCode = songCode;
    this.songOrder = songOrder;
  }

}

