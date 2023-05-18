package org.tennisplayers.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto {

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

    private Integer datalast0;

    private Integer datalast1;

    private Integer datalast2;

    private Integer datalast3;

    private Integer datalast4;


    //private List<Integer> last;

    // private CountryDto country;

    // private DataDto data;
}