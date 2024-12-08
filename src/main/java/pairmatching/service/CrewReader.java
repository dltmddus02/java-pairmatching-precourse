package pairmatching.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import pairmatching.domain.Crew;

public class CrewReader {

    private static final String BACKEND_CREW_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";


    public static void loadCrewsFromFile(Crew crew) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(BACKEND_CREW_PATH))) {
                readProductLines(br, crew, "backend");
            }
            try (BufferedReader br = new BufferedReader(new FileReader(FRONTEND_CREW_PATH))) {
                readProductLines(br, crew, "frontend");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readProductLines(BufferedReader br, Crew crew, String crewType) throws IOException {
        String line;
        if (crewType.equals("backend")) {
            while ((line = br.readLine()) != null) {
                crew.addBackend(line);
            }
        } else {
            while ((line = br.readLine()) != null) {
                crew.addFrontend(line);
            }
        }
    }

}
