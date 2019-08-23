package com.iotek.dao;

import com.iotek.model.Training;

import java.util.List;

public interface TrainingDao {
    void addTraining(Training training);
    void deleTraining(int id);
    void updateTraining(Training training);
    List<Training> queryTraining(Training training);
}
