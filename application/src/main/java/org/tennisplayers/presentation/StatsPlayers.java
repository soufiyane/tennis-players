package org.tennisplayers.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsPlayers {

    String BigRatio;
    Double IMCMoyen;
    Double TailleMediane;
}
