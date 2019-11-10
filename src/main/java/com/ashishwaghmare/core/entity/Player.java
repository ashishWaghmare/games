package com.ashishwaghmare.core.entity;

import lombok.Data;

@Data
public class Player {

  private String name;
  private Grid.State symbol;

  public boolean move(int row, int column) {
    //TODO
    return false;
  }
}
