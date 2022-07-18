package com.project.web_prj.board.repository;

import com.project.web_prj.board.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bri")
@Log4j2
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public boolean save(Board board) {
        log.info("save process with jdbc - {}", board);
        String sql = "INSERT INTO tbl_board " +
                    "(board_no, writer, title, content) " +
                    "VALUES (seq_tbl_board.nextval, ?, ?, ?)";
        return template.update(sql
                , board.getWriter()
                , board.getTitle()
                , board.getContent()
        ) == 1;
    }

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM tbl_board " +
                    "ORDER BY board_no DESC";
        return template.query(sql, (rs, rn) -> new Board(rs));
    }

    @Override
    public Board findOne(Long boardNo) {
        return null;
    }

    @Override
    public boolean remove(Long boardNo) {
        return false;
    }

    @Override
    public boolean modify(Board board) {
        return false;
    }
}
