package com.iotek.dao;

import com.iotek.model.Attendence;

import java.util.List;

public interface AttendenceDao {
    void addAttendence(Attendence attendence);
    void deleAttendence(int id);
    void updateAttendence(Attendence attendence);
    List<Attendence> queryAttendence(Attendence attendence);
    List<Attendence> queryAttendenceBypage(int start,int end);
    int getTotalRows();
    List<Attendence> queryAttendenceBypagewithEID(int start,int end,int eid);
    int getTotalRowswithEID(int eid);
}
