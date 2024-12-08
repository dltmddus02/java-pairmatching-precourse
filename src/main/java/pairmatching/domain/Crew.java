package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Crew {
    private List<String> backends;
    private List<String> frontends;

    public Crew() {
        backends = new ArrayList<>();
        frontends = new ArrayList<>();
    }

    public List<String> getBackends() {
        return backends;
    }

    public List<String> getFrontends() {
        return frontends;
    }

    public void addBackend(String backend) {
        backends.add(backend);
    }

    public void addFrontend(String frontend) {
        frontends.add(frontend);
    }

    public void shuffleBackends() {
        backends = Randoms.shuffle(backends);
    }

    public void shuffleFrontends() {
        frontends = Randoms.shuffle(frontends);
    }
}
