package com.example.demo.user.repository;

import com.example.demo.common.domain.Messenger;
import com.example.demo.user.domain.UserDTO;
import com.example.demo.user.service.UserService;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public Messenger save(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Messenger update(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Messenger saveAll(List<UserDTO> userDTOs) {
        System.out.println("=== UserRepository: 데이터 저장 시작 ===");
        System.out.println("총 " + userDTOs.size() + "개의 레코드가 저장됩니다.");
        System.out.println("================================================");

        for (int i = 0; i < userDTOs.size(); i++) {
            UserDTO user = userDTOs.get(i);
            System.out.println("--- 레코드 " + (i + 1) + " ---");
            System.out.println("승객ID: " + user.getPassengerId());
            System.out.println("생존여부: " + user.getSurvived());
            System.out.println("클래스: " + user.getPclass());
            System.out.println("이름: " + user.getName());
            System.out.println("성별: " + user.getGender());
            System.out.println("나이: " + user.getAge());
            System.out.println("형제자매/배우자: " + user.getSibSp());
            System.out.println("부모/자녀: " + user.getParch());
            System.out.println("티켓번호: " + user.getTicket());
            System.out.println("요금: " + user.getFare());
            System.out.println("객실: " + user.getCabin());
            System.out.println("탑승항구: " + user.getEmbarked());
            System.out.println("----------------------------------------");
        }

        System.out.println("=== UserRepository: 데이터 저장 완료 ===");
        System.out.println("총 " + userDTOs.size() + "건의 데이터가 성공적으로 저장되었습니다.");

        // 성공 시 Messenger에 담아서 리턴
        Messenger messenger = new Messenger();
        messenger.setMessage("데이터 저장 성공");
        messenger.setCode(200);
        return messenger;
    }

}
