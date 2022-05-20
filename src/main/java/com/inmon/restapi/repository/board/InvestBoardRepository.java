package com.inmon.restapi.repository.board;


import com.inmon.restapi.entity.board.InvestBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestBoardRepository extends JpaRepository<InvestBoard, Long> {

}
