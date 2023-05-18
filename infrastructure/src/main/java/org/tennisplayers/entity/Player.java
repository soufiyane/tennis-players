package org.tennisplayers.entity;

import com.sun.xml.bind.v2.runtime.unmarshaller.IntArrayData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.h2.util.IntArray;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String shortname;

    private char sex;

    private String countrypicture;

    private String countrycode;

    private String picture;

    private Integer datarank;

    private Integer datapoints;

    private Integer dataweight;

    private Integer dataheight;

    private Integer dataage;

  //  @ElementCollection
    //@Column(name = "last")
    //private List<Integer> last;

   private Integer datalast0;

   private Integer datalast1;

   private Integer datalast2;

  private Integer datalast3;

  private Integer datalast4;


  //  private Country country;

  //  private AditData data;
}