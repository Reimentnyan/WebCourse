package vn.iotstar.webcourse.service;

import vn.iotstar.webcourse.model.Video;
import java.util.List;

public interface VideoService {
    void insert(Video video);
    List<Video> findAll(int page, int pageSize);
    long count();
}