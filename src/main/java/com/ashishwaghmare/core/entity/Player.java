package com.ashishwaghmare.core.entity;

import com.ashishwaghmare.core.entity.Grid.State;
import lombok.Builder;
import lombok.Data;

@Data
public class Player {

  private String name;
  private final Grid.State symbol;

  public Player(State symbol) {
    this.symbol = symbol;
  }
}
