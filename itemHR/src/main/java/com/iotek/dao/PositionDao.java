package com.iotek.dao;

import com.iotek.model.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionDao {
    void addPosition(Position position);
    void delePosition(int id);
    void updatePosition(Position position);
    List<Position> queryPosition(Position position);
    List<Position> queryPositionByPage(int start,int end);
    int getTotalRows();
}
