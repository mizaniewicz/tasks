package com.crud.tasks.domain.trellobadges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloAttachment {
    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;
}
