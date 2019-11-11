package com.ashishwaghmare.core.entity;

import com.ashishwaghmare.core.entity.Grid.State;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerX {

  private String name;
  private final Grid.State symbol;

  public PlayerX(State symbol) {
    this.symbol = symbol;
  }

  public boolean move(int row, int column) {
    //TODO
    return false;
  }
}
