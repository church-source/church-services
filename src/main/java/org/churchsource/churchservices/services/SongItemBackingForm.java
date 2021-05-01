package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.churchsource.churchservices.model.ChurchServiceEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString(callSuper = true/*, exclude="service"*/)
@EqualsAndHashCode(callSuper = true/*, exclude="service"*/)
@NoArgsConstructor
public class SongItemBackingForm extends ChurchServiceEntity<Long> implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItemBackingForm")
  public SongItemBackingForm(Long id, Date created, Date modified/*, ChurchService service*/, String songCode, int songOrder, Boolean deleted) {
    super(id, created, modified, deleted);
//    this.service = service;
    this.songCode = songCode;
    this.songOrder = songOrder;
  }

}

