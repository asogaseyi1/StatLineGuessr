# StatLineGuessr
# 🏀🏈 StatLineGuessr

**StatLineGuessr** is a full-stack sports guessing game that challenges users to identify NBA and NFL players based on stat lines and iconic moments. Think Wordle, but for sports fans — with daily challenges, streaks, and epic highlight recalls.

---

## 🎯 Concept

StatLineGuessr combines two game modes into one addictive platform:

1. **Stat Line Guess**
   - Guess the player from their game stat line.
   - Get hints (team, date, position) if stuck.
   - Track streaks and accuracy.

2. **Who Scored It?**
   - Guess the player responsible for a famous moment or play.
   - Clues include game context, year, team, and media.
   - Watch the play after guessing via YouTube integration.

---

## 🧩 Core Features

- 🧠 **Stat Line Guessing Game**
- 🎞️ **Moment Guess Mode**
- 📅 **Daily Challenges**
- 🔁 **Streaks, Scores, and Leaderboards**
- 👤 **User Guess Tracking & Stats**
- 🔐 **(Optional) User Accounts via JWT Auth**
- 🛠️ **Admin Panel for Adding Moments/Stats**
- 📺 **Embedded Highlights & Recaps**

---

## 🛠️ Tech Stack

### 🔙 Backend (Spring Boot + PostgreSQL)
- RESTful API (Guess submission, stats, admin tools)
- PostgreSQL relational database
- JWT Auth with Spring Security
- Data seeders for player stat lines and moments

### 🌐 Frontend (React + TypeScript)
- Game UI with guess input, feedback, hint system
- Responsive layout with animations and charts
- Stats and leaderboard pages
- Admin dashboard (private)

---

## 📡 Data Sources

| Source          | Use Case                    | Status |
|-----------------|-----------------------------|--------|
| [balldontlie.io](https://www.balldontlie.io/) | NBA stat lines              | ✅ Free |
| Custom CSV/DB   | NFL/NBA iconic moments      | ✅ Manual Seed |
| YouTube Data API| Highlights & clip previews  | ✅ Free tier (optional) |

---

## 📁 Project Structure (Planned)
/backend
└── src
└── main
├── controllers
├── services
├── models
├── repositories
└── config

/frontend
└── src
├── components
├── pages
├── services (API calls)
└── utils

## 🧪 MVP Scope (Phase 1)

- [ ] Stat Line Guess Game Mode
- [ ] React UI with guessing flow
- [ ] Backend API for fetching stat lines
- [ ] Guess evaluation + local stats tracking
- [ ] 50+ seeded NBA stat lines (via `balldontlie` or CSV)

---

## 🚀 Future Plans

- [ ] Add Who Scored It? mode with iconic NFL/NBA moments
- [ ] Daily Challenge system (1 per day per mode)
- [ ] Leaderboard (weekly & all-time)
- [ ] Account system (email + JWT)
- [ ] User-submitted stat lines/moments
- [ ] Year-in-Review for your guesses + accuracy
- [ ] Expand to include Soccer e.g Premier Leage/ La Liga or Champions League stats

---

## 🧠 Ideas for Later

- Multiplayer head-to-head guessing
- Time attack mode (guess as many in 60s)
- “Mystery Grid” mode (like Immaculate Grid)
- Integration with real-time APIs for live stat games

---

## 🤝 Contributions

This is a personal side project, but pull requests and ideas are welcome! Start by opening an issue or discussion if you'd like to help expand StatLineGuessr.

---

## 📜 License

MIT License — feel free to use, remix, and expand this idea with credit.

---

## 📌 Author

Built by Oluwaseyi Asoga, inspired by games like Wordle, NBA/NFL fandom, and a love for creative full-stack projects.

