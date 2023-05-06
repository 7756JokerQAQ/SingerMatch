package com.yupi.yupao.service;

import com.yupi.yupao.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupao.model.domain.User;
import com.yupi.yupao.model.dto.TeamQuery;
import com.yupi.yupao.model.request.TeamJoinRequest;
import com.yupi.yupao.model.request.TeamQuitRequest;
import com.yupi.yupao.model.request.TeamUpdateRequest;
import com.yupi.yupao.model.vo.TeamUserVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2022-12-25 14:53:48
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     * @param team
     * @return
     */
    long addTeam(Team team, User loginUser);

    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 修改队伍信息
     * @param teamUpdateRequest
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);
    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */

    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);
    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    TeamUserVO getTeamById(long id, boolean isAdmin, User loginUser);

    boolean deleteTeam(long id, User loginUser);
}
