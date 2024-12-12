package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;

public class NameReader {
    private static final String BACKEND_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_PATH = "src/main/resources/frontend-crew.md";
    private static final String FILE_LOAD_ERROR = "[ERROR] 크루원 목록을 불러오는 중 오류가 발생했습니다.";

    public static void storeBackendCrew() {
        try (BufferedReader br = new BufferedReader(new FileReader(BACKEND_FILE_PATH))) {
            readProductLines(br, "backend");
        } catch (IOException e) {
            System.err.println(FILE_LOAD_ERROR + ": " + e.getMessage());
        }
    }

    public static void storeFrontendCrew() {
        try (BufferedReader br = new BufferedReader(new FileReader(FRONTEND_FILE_PATH))) {
            readProductLines(br, "frontend");
        } catch (IOException e) {
            System.err.println(FILE_LOAD_ERROR + ": " + e.getMessage());
        }
    }


    private static void readProductLines(BufferedReader br, String type) throws IOException {
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            processEachProductLine(line, type);
        }
    }

    private static void processEachProductLine(String line, String type) {
        Crew crew = new Crew(line);
        CrewRepository.addCrew(crew);
        if (type.equals("backend")) {
            CrewRepository.addBackEndCrew(line);
            return;
        }
        CrewRepository.addFrontEndCrew(line);
    }
}
