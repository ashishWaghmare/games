package com.ashishwaghmare.core.entity;


import com.ashishwaghmare.core.entity.Grid.State;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Game {

  private Grid grid;
  Map<State, Player> symbol2Player = new HashMap<>();
  private State currentSymbol;

  public Game() {
    this(3, 3);
  }

  public Game(int rows, int columns) {
    grid = new Grid(rows, columns);
    symbol2Player.put(State.EMPTY, new Player(State.EMPTY));//Empty is taken by Judge
    currentSymbol = State.O;//TODO pick first player
  }

  public Player getPlayer(String name, State symbol) {
    if (!symbol2Player.containsKey(symbol)) {
      Player newPlayer = new Player(symbol);
      newPlayer.setName(name);
      symbol2Player.put(symbol, newPlayer);
      return newPlayer;
    }
    return null; // No way to join more
  }

  public Player getActivePlayer() {
    return symbol2Player.get(currentSymbol);
  }

  public boolean move(int position) {
    return move(position / grid.getRows(), position % grid.getColumns());
  }

  public boolean simulate(int... moves) {
    for (int position : moves) {
      if (!move(position / grid.getRows(), position % grid.getColumns())) {
        return false;
      }
    }
    grid.isDone(currentSymbol);
    nextTurn();
    return true;
  }

  public boolean move(int row, int column) {
    return grid.mark(row, column, currentSymbol);
  }

  public void nextTurn() {
    switch (currentSymbol) {
      case O:
        currentSymbol = State.X;
        return;
      case X:
        currentSymbol = State.O;
        return;
      default:
        //Do nothing
    }
  }

  public boolean isDone() {
    return grid.isDone(currentSymbol) || grid.allMarked();
  }

  public String getRemainingSymbol() {
    StringBuilder builder = new StringBuilder();
    for (State state : State.values()) {
      if (!symbol2Player.containsKey(state)) {
        builder.append(" ").append(state.display);
      }
    }
    return builder.toString();
  }
}
