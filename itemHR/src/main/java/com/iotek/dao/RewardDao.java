package com.iotek.dao;

import com.iotek.model.Reward;

import java.util.List;

public interface RewardDao {
    void addReward(Reward reward);
    void deleReward(int id);
    void updateReward(Reward reward);
    List<Reward> queryReward(Reward reward);
    List<Reward> queryRewardByPageWithEid(int start,int end,int eid);
    int getTotalRowsWithEid(int eid);
    List<Reward> queryRewardByPage(int start,int end);
    int getTotalRows();
}
