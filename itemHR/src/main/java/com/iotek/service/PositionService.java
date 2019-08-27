package com.iotek.service;

import com.iotek.model.Page;
import com.iotek.model.Position;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PositionService {
    boolean addPosition(Position position);
    boolean delePosition(int id);
    boolean updatePosition(Position position);
    List<Position> queryPosition(Position position);
    Page queryPositionByPage(int pageNo);
}
