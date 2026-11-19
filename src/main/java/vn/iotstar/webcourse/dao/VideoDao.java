package vn.iotstar.webcourse.dao;

import vn.iotstar.webcourse.model.Video;
import java.util.List;

public interface VideoDao {
    void insert(Video video);
    List<Video> findAll(int page, int pageSize);
    long count();
}