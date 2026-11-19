package vn.iotstar.webcourse.service.impl;

import vn.iotstar.webcourse.dao.VideoDao;
import vn.iotstar.webcourse.dao.impl.VideoDaoImpl;
import vn.iotstar.webcourse.model.Video;
import vn.iotstar.webcourse.service.VideoService;
import java.util.List;

public class VideoServiceImpl implements VideoService {
    private final VideoDao videoDao = new VideoDaoImpl();

    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    @Override
    public List<Video> findAll(int page, int pageSize) {
        return videoDao.findAll(page, pageSize);
    }

    @Override
    public long count() {
        return videoDao.count();
    }
}