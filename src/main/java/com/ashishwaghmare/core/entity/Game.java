package com.ashishwaghmare.core.entity;

import static com.ashishwaghmare.core.entity.Grid.*;

import com.ashishwaghmare.core.entity.Grid.State;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Game {

  private Grid grid;
  Map<State, Player> symbol2Player = new HashMap<>();

  public Game() {
    this(3, 3);
  }

  public Game(int rows, int columns) {
    grid = new Grid(rows, columns);
    symbol2Player.put(State.EMPTY, new Player());//Empty is taken by Judge
  }

  public Player getPlayer(int i) {
    Player newPlayer = new Player();
    for (State state : State.values()) {
      if (!symbol2Player.containsKey(state)) {
        newPlayer.setSymbol(state);
        symbol2Player.put(state, newPlayer);
      }
    }
    return newPlayer;
  }

  public Player getActivePlayer() {
    //TODO
    return null;
  }

  public boolean isOver() {
    return true;
  }
}
