package com.statlineguessr.service;

import com.statlineguessr.dto.GuessRequest;
import com.statlineguessr.dto.GuessResult;
import com.statlineguessr.model.Guess;
import com.statlineguessr.model.Player;
import com.statlineguessr.model.Statline;
import com.statlineguessr.repository.GuessRepository;
import com.statlineguessr.repository.StatlineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuessServiceImpl implements GuessService {
    private final StatlineRepository statlineRepository;
    private final GuessRepository guessRepository;

    public GuessServiceImpl(StatlineRepository statlineRepository, GuessRepository guessRepository) {
        this.statlineRepository = statlineRepository;
        this.guessRepository = guessRepository;
    }

    @Override
    public GuessResult submitGuess(GuessRequest request) {
        Optional<Statline> statlineOpt = statlineRepository.findById(request.statlineId());
        if (statlineOpt.isEmpty()) {
            return new GuessResult(false, null, null, null, null, "Stat line not found.");
        }

        Statline statline = statlineOpt.get();
        Player actual = statline.getPlayer();
        String guessed = request.guessedPlayerName().trim();
        boolean correct = actual.getName().equalsIgnoreCase(guessed);

        guessRepository.save(new Guess(statline, guessed, correct, 0));

        return new GuessResult(
                correct,
                actual.getName(),
                actual.getTeam(),
                actual.getPosition(),
                actual.getSport(),
                correct ? "Correct! Great job!" : "Wrong! Keep trying."
        );
    }
}
