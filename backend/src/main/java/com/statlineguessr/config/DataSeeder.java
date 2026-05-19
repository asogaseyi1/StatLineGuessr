package com.statlineguessr.config;

import com.statlineguessr.model.Player;
import com.statlineguessr.model.Statline;
import com.statlineguessr.repository.PlayerRepository;
import com.statlineguessr.repository.StatlineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    private final PlayerRepository playerRepository;
    private final StatlineRepository statlineRepository;

    public DataSeeder(PlayerRepository playerRepository, StatlineRepository statlineRepository) {
        this.playerRepository = playerRepository;
        this.statlineRepository = statlineRepository;
    }

    @Override
    public void run(String... args) {
        if (statlineRepository.count() > 0) {
            log.info("Database already seeded — skipping.");
            return;
        }

        Player lebron   = playerRepository.save(new Player("LeBron James",          "NBA", "Los Angeles Lakers",    "SF"));
        Player durant   = playerRepository.save(new Player("Kevin Durant",           "NBA", "Phoenix Suns",          "SF"));
        Player curry    = playerRepository.save(new Player("Stephen Curry",          "NBA", "Golden State Warriors", "PG"));
        Player giannis  = playerRepository.save(new Player("Giannis Antetokounmpo",  "NBA", "Milwaukee Bucks",       "PF"));
        Player jokic    = playerRepository.save(new Player("Nikola Jokic",           "NBA", "Denver Nuggets",        "C"));
        Player luka     = playerRepository.save(new Player("Luka Doncic",            "NBA", "Dallas Mavericks",      "PG"));
        Player embiid   = playerRepository.save(new Player("Joel Embiid",            "NBA", "Philadelphia 76ers",    "C"));
        Player tatum    = playerRepository.save(new Player("Jayson Tatum",           "NBA", "Boston Celtics",        "SF"));
        Player booker   = playerRepository.save(new Player("Devin Booker",           "NBA", "Phoenix Suns",          "SG"));
        Player ad       = playerRepository.save(new Player("Anthony Davis",          "NBA", "Los Angeles Lakers",    "C"));

        List<Statline> statlines = List.of(
                new Statline(lebron,  LocalDate.of(2023, 11, 10), 35,  8, 12, 2, 1, bd(38.5)),
                new Statline(lebron,  LocalDate.of(2023, 12,  1), 28, 11,  9, 1, 0, bd(36.0)),
                new Statline(lebron,  LocalDate.of(2024,  1, 15), 40,  9,  8, 2, 2, bd(39.0)),
                new Statline(lebron,  LocalDate.of(2024,  2, 20), 32, 10, 11, 3, 0, bd(35.0)),
                new Statline(durant,  LocalDate.of(2023, 11,  5), 38,  5,  7, 1, 2, bd(37.0)),
                new Statline(durant,  LocalDate.of(2023, 12, 15), 42,  4, 10, 0, 3, bd(40.5)),
                new Statline(durant,  LocalDate.of(2024,  1, 22), 31,  6,  8, 2, 1, bd(36.5)),
                new Statline(durant,  LocalDate.of(2024,  3,  1), 27,  7,  9, 1, 2, bd(34.0)),
                new Statline(curry,   LocalDate.of(2023, 11, 12), 45,  7,  5, 3, 0, bd(38.0)),
                new Statline(curry,   LocalDate.of(2023, 12,  8), 32, 10,  4, 2, 0, bd(35.5)),
                new Statline(curry,   LocalDate.of(2024,  1, 30), 54,  5,  6, 4, 0, bd(40.0)),
                new Statline(curry,   LocalDate.of(2024,  2, 14), 28,  9,  7, 1, 0, bd(33.0)),
                new Statline(giannis, LocalDate.of(2023, 11,  8), 37,  7, 15, 1, 3, bd(36.0)),
                new Statline(giannis, LocalDate.of(2023, 12, 20), 43,  9, 12, 2, 2, bd(38.5)),
                new Statline(giannis, LocalDate.of(2024,  1, 18), 30,  5, 18, 0, 4, bd(35.0)),
                new Statline(giannis, LocalDate.of(2024,  2, 28), 34,  8, 14, 1, 3, bd(37.0)),
                new Statline(jokic,   LocalDate.of(2023, 11, 10), 28, 12, 14, 2, 1, bd(34.0)),
                new Statline(jokic,   LocalDate.of(2023, 12, 12), 32, 15, 10, 1, 2, bd(37.0)),
                new Statline(jokic,   LocalDate.of(2024,  1, 20), 25, 10, 16, 3, 0, bd(35.5)),
                new Statline(jokic,   LocalDate.of(2024,  2, 25), 38, 11, 12, 2, 1, bd(38.0)),
                new Statline(luka,    LocalDate.of(2023, 11, 20), 45,  8, 12, 2, 1, bd(38.5)),
                new Statline(luka,    LocalDate.of(2023, 12, 18), 38, 11, 10, 3, 0, bd(37.0)),
                new Statline(luka,    LocalDate.of(2024,  1, 12), 33, 13,  9, 1, 1, bd(36.0)),
                new Statline(luka,    LocalDate.of(2024,  2, 22), 50,  7, 13, 2, 0, bd(41.0)),
                new Statline(embiid,  LocalDate.of(2023, 11, 18), 42,  4, 12, 0, 3, bd(37.0)),
                new Statline(embiid,  LocalDate.of(2023, 12, 10), 35,  6,  9, 1, 2, bd(34.5)),
                new Statline(embiid,  LocalDate.of(2024,  1, 28), 51,  3, 11, 2, 4, bd(40.0)),
                new Statline(embiid,  LocalDate.of(2024,  2, 15), 29,  5, 13, 0, 3, bd(35.0)),
                new Statline(tatum,   LocalDate.of(2023, 11, 25), 40,  5, 10, 2, 1, bd(38.0)),
                new Statline(tatum,   LocalDate.of(2023, 12, 14), 32,  8,  7, 1, 0, bd(35.5)),
                new Statline(tatum,   LocalDate.of(2024,  1,  8), 28,  6,  9, 3, 2, bd(34.0)),
                new Statline(tatum,   LocalDate.of(2024,  2, 10), 44,  4, 11, 0, 1, bd(39.5)),
                new Statline(booker,  LocalDate.of(2023, 11, 22), 35,  7,  4, 2, 0, bd(36.0)),
                new Statline(booker,  LocalDate.of(2023, 12,  9), 41,  6,  5, 1, 0, bd(38.0)),
                new Statline(booker,  LocalDate.of(2024,  1, 16), 28,  9,  6, 2, 0, bd(34.5)),
                new Statline(booker,  LocalDate.of(2024,  2, 18), 38,  8,  4, 3, 0, bd(37.0)),
                new Statline(ad,      LocalDate.of(2023, 11, 17), 35,  2, 15, 1, 3, bd(38.0)),
                new Statline(ad,      LocalDate.of(2023, 12,  6), 28,  4, 12, 2, 4, bd(36.5)),
                new Statline(ad,      LocalDate.of(2024,  1, 22), 42,  3, 16, 0, 5, bd(40.5)),
                new Statline(ad,      LocalDate.of(2024,  2, 12), 30,  5, 14, 1, 2, bd(37.0))
        );

        statlineRepository.saveAll(statlines);
        log.info("Seeded {} stat lines.", statlines.size());
    }

    private BigDecimal bd(double val) {
        return BigDecimal.valueOf(val);
    }
}
