package org.tennisplayers.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataDto {

    private Integer rank;

    private Integer points;

    private Integer weight;

    private Integer height;

    private Integer age;

    private Integer[] last;
}