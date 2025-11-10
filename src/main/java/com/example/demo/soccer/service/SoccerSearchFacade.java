package com.example.demo.soccer.service;

import org.springframework.stereotype.Service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.player.service.PlayerService;
import com.example.demo.soccer.schedule.service.ScheduleService;
import com.example.demo.soccer.stadium.service.StadiumService;
import com.example.demo.soccer.team.service.TeamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SoccerSearchFacade {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final StadiumService stadiumService;
    private final ScheduleService scheduleService;

    /**
     * 퍼사드 패턴을 사용한 통합 검색 메서드
     * 타입에 따라 적절한 서비스의 findByKeyword를 호출
     * 
     * @param type    검색할 엔티티 타입 (player, team, stadium, schedule)
     * @param keyword 검색어
     * @return 검색 결과
     */
    public Messenger searchByKeyword(String type, String keyword) {
        System.out.println("=== SoccerSearchFacade: 통합 검색 시작 ===");
        System.out.println("검색 타입: " + type);
        System.out.println("검색어: " + keyword);

        Messenger result;

        switch (type.toLowerCase()) {
            case "player":
                System.out.println(">>> Player 검색 실행");
                result = playerService.findByKeyword(keyword);
                break;
            case "team":
                System.out.println(">>> Team 검색 실행");
                result = teamService.findByKeyword(keyword);
                break;
            case "stadium":
                System.out.println(">>> Stadium 검색 실행");
                result = stadiumService.findByKeyword(keyword);
                break;
            case "schedule":
                System.out.println(">>> Schedule 검색 실행");
                result = scheduleService.findByKeyword(keyword);
                break;
            default:
                System.out.println(">>> 알 수 없는 타입: " + type);
                result = Messenger.builder()
                        .code(400)
                        .message("Unknown search type: " + type)
                        .build();
        }

        System.out.println("=== SoccerSearchFacade: 통합 검색 완료 ===");
        return result;
    }
}
