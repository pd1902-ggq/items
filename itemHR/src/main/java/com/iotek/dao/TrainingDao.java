package com.iotek.dao;

import com.iotek.model.Training;

import java.util.List;

public interface TrainingDao {
    void addTraining(Training training);
    void deleTraining(int id);
    void updateTraining(Training training);
    List<Training> queryTraining(Training training);
    List<Training> queryTrainingByPageWithEid(int start,int end,int eid);
    List<Training> queryTrainingByPage(int start,int end);
}
