package com.statlineguessr.config;

import com.statlineguessr.model.Player;
import com.statlineguessr.model.Statline;
import com.statlineguessr.repository.PlayerRepository;
import com.statlineguessr.repository.StatlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final PlayerRepository playerRepository;
    private final StatlineRepository statlineRepository;

    public DataSeeder(PlayerRepository playerRepository, StatlineRepository statlineRepository) {
        this.playerRepository = playerRepository;
        this.statlineRepository = statlineRepository;
    }

    @Override
    public void run(String... args) {
        if (playerRepository.count() > 0) return;

        Player lebron   = playerRepository.save(new Player(null, "LeBron James",              "NBA", "Los Angeles Lakers",   "SF"));
        Player durant   = playerRepository.save(new Player(null, "Kevin Durant",               "NBA", "Phoenix Suns",         "SF"));
        Player curry    = playerRepository.save(new Player(null, "Stephen Curry",              "NBA", "Golden State Warriors","PG"));
        Player giannis  = playerRepository.save(new Player(null, "Giannis Antetokounmpo",      "NBA", "Milwaukee Bucks",      "PF"));
        Player harden   = playerRepository.save(new Player(null, "James Harden",               "NBA", "Los Angeles Clippers", "PG"));
        Player jokic    = playerRepository.save(new Player(null, "Nikola Jokic",               "NBA", "Denver Nuggets",       "C"));
        Player embiid   = playerRepository.save(new Player(null, "Joel Embiid",                "NBA", "Philadelphia 76ers",   "C"));
        Player luka     = playerRepository.save(new Player(null, "Luka Doncic",                "NBA", "Dallas Mavericks",     "PG"));
        Player tatum    = playerRepository.save(new Player(null, "Jayson Tatum",               "NBA", "Boston Celtics",       "SF"));
        Player booker   = playerRepository.save(new Player(null, "Devin Booker",               "NBA", "Phoenix Suns",         "SG"));
        Player lillard  = playerRepository.save(new Player(null, "Damian Lillard",             "NBA", "Milwaukee Bucks",      "PG"));
        Player butler   = playerRepository.save(new Player(null, "Jimmy Butler",               "NBA", "Miami Heat",           "SF"));
        Player kawhi    = playerRepository.save(new Player(null, "Kawhi Leonard",              "NBA", "Los Angeles Clippers", "SF"));
        Player pg13     = playerRepository.save(new Player(null, "Paul George",                "NBA", "Philadelphia 76ers",   "SG"));
        Player ad       = playerRepository.save(new Player(null, "Anthony Davis",              "NBA", "Los Angeles Lakers",   "C"));

        List<Statline> statlines = List.of(
                // LeBron James
                new Statline(lebron,  LocalDate.of(2023, 11, 10), 35, 8,  12, 2, 1, bd(38.5)),
                new Statline(lebron,  LocalDate.of(2023, 12,  1), 28, 11,  9, 1, 0, bd(36.0)),
                new Statline(lebron,  LocalDate.of(2024,  1, 15), 40,  9,  8, 2, 2, bd(39.0)),
                new Statline(lebron,  LocalDate.of(2024,  2, 20), 22, 10, 11, 3, 0, bd(35.0)),

                // Kevin Durant
                new Statline(durant,  LocalDate.of(2023, 11,  5), 38,  5,  7, 1, 2, bd(37.0)),
                new Statline(durant,  LocalDate.of(2023, 12, 15), 42,  4, 10, 0, 3, bd(40.5)),
                new Statline(durant,  LocalDate.of(2024,  1, 22), 31,  6,  8, 2, 1, bd(36.5)),
                new Statline(durant,  LocalDate.of(2024,  3,  1), 27,  7,  9, 1, 2, bd(34.0)),

                // Stephen Curry
                new Statline(curry,   LocalDate.of(2023, 11, 12), 45,  7,  5, 3, 0, bd(38.0)),
                new Statline(curry,   LocalDate.of(2023, 12,  8), 32, 10,  4, 2, 0, bd(35.5)),
                new Statline(curry,   LocalDate.of(2024,  1, 30), 54,  5,  6, 4, 0, bd(40.0)),
                new Statline(curry,   LocalDate.of(2024,  2, 14), 28,  9,  7, 1, 0, bd(33.0)),

                // Giannis Antetokounmpo
                new Statline(giannis, LocalDate.of(2023, 11,  8), 37,  7, 15, 1, 3, bd(36.0)),
                new Statline(giannis, LocalDate.of(2023, 12, 20), 43,  9, 12, 2, 2, bd(38.5)),
                new Statline(giannis, LocalDate.of(2024,  1, 18), 30,  5, 18, 0, 4, bd(35.0)),
                new Statline(giannis, LocalDate.of(2024,  2, 28), 34,  8, 14, 1, 3, bd(37.0)),

                // James Harden
                new Statline(harden,  LocalDate.of(2023, 11, 14), 27, 12,  5, 2, 0, bd(36.0)),
                new Statline(harden,  LocalDate.of(2023, 12,  5), 33,  9,  7, 3, 0, bd(38.5)),
                new Statline(harden,  LocalDate.of(2024,  1, 25), 22, 14,  4, 2, 0, bd(34.0)),
                new Statline(harden,  LocalDate.of(2024,  3,  5), 29, 10,  6, 1, 1, bd(35.5)),

                // Nikola Jokic
                new Statline(jokic,   LocalDate.of(2023, 11, 10), 28, 12, 14, 2, 1, bd(34.0)),
                new Statline(jokic,   LocalDate.of(2023, 12, 12), 32, 15, 10, 1, 2, bd(37.0)),
                new Statline(jokic,   LocalDate.of(2024,  1, 20), 25, 10, 16, 3, 0, bd(35.5)),
                new Statline(jokic,   LocalDate.of(2024,  2, 25), 38, 11, 12, 2, 1, bd(38.0)),

                // Joel Embiid
                new Statline(embiid,  LocalDate.of(2023, 11, 18), 42,  4, 12, 0, 3, bd(37.0)),
                new Statline(embiid,  LocalDate.of(2023, 12, 10), 35,  6,  9, 1, 2, bd(34.5)),
                new Statline(embiid,  LocalDate.of(2024,  1, 28), 51,  3, 11, 2, 4, bd(40.0)),
                new Statline(embiid,  LocalDate.of(2024,  2, 15), 29,  5, 13, 0, 3, bd(35.0)),

                // Luka Doncic
                new Statline(luka,    LocalDate.of(2023, 11, 20), 45,  8, 12, 2, 1, bd(38.5)),
                new Statline(luka,    LocalDate.of(2023, 12, 18), 38, 11, 10, 3, 0, bd(37.0)),
                new Statline(luka,    LocalDate.of(2024,  1, 12), 33, 13,  9, 1, 1, bd(36.0)),
                new Statline(luka,    LocalDate.of(2024,  2, 22), 50,  7, 13, 2, 0, bd(41.0)),

                // Jayson Tatum
                new Statline(tatum,   LocalDate.of(2023, 11, 25), 40,  5, 10, 2, 1, bd(38.0)),
                new Statline(tatum,   LocalDate.of(2023, 12, 14), 32,  8,  7, 1, 0, bd(35.5)),
                new Statline(tatum,   LocalDate.of(2024,  1,  8), 28,  6,  9, 3, 2, bd(34.0)),
                new Statline(tatum,   LocalDate.of(2024,  2, 10), 44,  4, 11, 0, 1, bd(39.5)),

                // Devin Booker
                new Statline(booker,  LocalDate.of(2023, 11, 22), 35,  7,  4, 2, 0, bd(36.0)),
                new Statline(booker,  LocalDate.of(2023, 12,  9), 41,  6,  5, 1, 0, bd(38.0)),
                new Statline(booker,  LocalDate.of(2024,  1, 16), 28,  9,  6, 2, 0, bd(34.5)),
                new Statline(booker,  LocalDate.of(2024,  2, 18), 38,  8,  4, 3, 0, bd(37.0)),

                // Damian Lillard
                new Statline(lillard, LocalDate.of(2023, 11,  7), 36, 11,  3, 1, 0, bd(37.0)),
                new Statline(lillard, LocalDate.of(2023, 12, 22), 41,  8,  5, 2, 0, bd(38.5)),
                new Statline(lillard, LocalDate.of(2024,  1,  5), 27, 12,  4, 1, 0, bd(35.0)),
                new Statline(lillard, LocalDate.of(2024,  2,  5), 44,  7,  6, 3, 0, bd(39.0)),

                // Jimmy Butler
                new Statline(butler,  LocalDate.of(2023, 11, 15), 28,  7,  7, 3, 1, bd(38.0)),
                new Statline(butler,  LocalDate.of(2023, 12, 28), 34,  6,  8, 4, 0, bd(39.5)),
                new Statline(butler,  LocalDate.of(2024,  1, 10), 24,  9,  9, 2, 0, bd(36.0)),
                new Statline(butler,  LocalDate.of(2024,  2,  8), 36,  8,  6, 3, 1, bd(37.5)),

                // Kawhi Leonard
                new Statline(kawhi,   LocalDate.of(2023, 11, 19), 29,  4,  8, 3, 1, bd(35.0)),
                new Statline(kawhi,   LocalDate.of(2023, 12, 16), 36,  5, 10, 2, 0, bd(37.5)),
                new Statline(kawhi,   LocalDate.of(2024,  1, 14), 27,  3,  7, 4, 2, bd(34.0)),
                new Statline(kawhi,   LocalDate.of(2024,  2, 24), 33,  6,  9, 3, 1, bd(36.0)),

                // Paul George
                new Statline(pg13,    LocalDate.of(2023, 11,  9), 31,  5,  6, 3, 0, bd(36.0)),
                new Statline(pg13,    LocalDate.of(2023, 12, 24), 27,  7,  8, 2, 1, bd(35.5)),
                new Statline(pg13,    LocalDate.of(2024,  1, 17), 38,  6,  5, 4, 0, bd(38.0)),
                new Statline(pg13,    LocalDate.of(2024,  2, 20), 22,  4,  7, 2, 0, bd(33.0)),

                // Anthony Davis
                new Statline(ad,      LocalDate.of(2023, 11, 17), 35,  2, 15, 1, 3, bd(38.0)),
                new Statline(ad,      LocalDate.of(2023, 12,  6), 28,  4, 12, 2, 4, bd(36.5)),
                new Statline(ad,      LocalDate.of(2024,  1, 22), 42,  3, 16, 0, 5, bd(40.5)),
                new Statline(ad,      LocalDate.of(2024,  2, 12), 30,  5, 14, 1, 2, bd(37.0))
        );

        statlineRepository.saveAll(statlines);
    }

    private BigDecimal bd(double val) {
        return BigDecimal.valueOf(val);
    }
}
