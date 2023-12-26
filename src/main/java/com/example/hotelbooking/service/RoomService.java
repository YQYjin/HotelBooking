package com.example.hotelbooking.service;

import com.example.hotelbooking.bean.Rooms;
import com.example.hotelbooking.mapper.RoomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomsMapper roomsMapper;

    public String changeRoomStatus(int roomNo, int status){
        Rooms room=roomsMapper.selectById(roomNo);
        room.setStatus(status);
        int rowsAffected=roomsMapper.updateById(room);
        if(rowsAffected==1)
            return "true";
        else
            return "false";
    }
    public int getRoom(){
        List<Rooms> rooms=roomsMapper.selectList(null);
        for(Rooms room:rooms){
            int status=room.getStatus();
            if(status==0) {
                int roomNo=room.getId();
                roomNo=roomNo+1;
                return roomNo;
            }
        }
        return -1;
    }
}
