package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SongLastChosenDateDTO {
    @Id
    private String songCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate serviceDate;
}
