package vn.iotstar.webcourse.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.webcourse.model.User;
import vn.iotstar.webcourse.model.Video;
import vn.iotstar.webcourse.service.VideoService;
import vn.iotstar.webcourse.service.impl.VideoServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet("/upload-video")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 50,       // 50MB
        maxRequestSize = 1024 * 1024 * 100    // 100MB
)
public class VideoUploadController extends HttpServlet {
    public static final String SAVE_DIRECTORY = "uploads";
    private final VideoService videoService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/upload-video.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        String uploadPath = getServletContext().getRealPath("") + File.separator + SAVE_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            String fileName = "";
            for (Part part : request.getParts()) {
                String extracted = getFileName(part);
                if (!extracted.isEmpty()) {
                    fileName = extracted;
                    part.write(uploadPath + File.separator + fileName);
                }
            }

            HttpSession session = request.getSession(false);
            User currentUser = (session != null) ? (User) session.getAttribute("account") : null;

            if (currentUser != null && !fileName.isEmpty()) {
                Video video = new Video();
                video.setTitle(title);
                video.setDescription(description);
                video.setFilePath(SAVE_DIRECTORY + "/" + fileName);
                video.setUser(currentUser);
                videoService.insert(video);
            }

            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }

        getServletContext().getRequestDispatcher("/views/upload-video.jsp").forward(request, response);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }
}