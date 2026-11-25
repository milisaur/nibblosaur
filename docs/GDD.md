# Nibblosaur

**Game Design Document (GDD)**  
**Version:** 0.4  
**Date:** November 23, 2026  
**Project:** milisaur / Nibblosaur  
**Phase:** Prototyping / early concept development  
**Document status:** Living document

---

## 1. Project Overview

Nibblosaur is an experimental Java game project centered on a small dinosaur named Heinrich. It began as a deliberately manageable terminal-based virtual pet: a character with needs, moods, and a few ways to interact with it. The prototype also serves as a practical way to learn Java, object-oriented programming, and eventually game development.

The idea has since expanded beyond a conventional Tamagotchi-style game. A jungle environment, minigames, a Pomodoro timer, and collectible tokens are possible directions. It has not yet been decided which of these will become part of the actual game.

**Nibblosaur is not being developed from a fixed feature list.** Individual mechanics should be explored, understood, and evaluated based on how well they work in practice. The project's scope, balance between genres, and final form remain open for now.

### Project Information

| Area | Current status |
|---|---|
| Working title / current name | **Nibblosaur** |
| Developer identity | **milisaur** |
| Main character | **Heinrich** |
| Current prototype | Interactive Java terminal game |
| In-game language | English |
| Technical foundation | Java 25, Maven, Git |
| Visual direction | Jungle environment, natural greens, warm lighting |
| Possible art style | 2D pixel art |
| Possible graphics framework | JavaFX — still to be evaluated |
| Target platform / release | Undecided |

The name has been selected provisionally. A conclusive trademark clearance has not been completed.

## 2. Development Approach

Nibblosaur is both a game and a learning project. These goals are compatible: development should remain understandable without excluding interesting technical or creative experiments.

The process is intentionally iterative:

1. Select a specific idea.
2. Build the smallest useful playable or visible implementation.
3. Evaluate its behavior, presentation, and technical implementation.
4. Keep, revise, or discard it.

There is no reason to design comprehensive inventory, economy, quest, or world systems at this stage. Such structures become relevant only when actual mechanics create a need for them.

**The measure of progress is not the number of features, but whether an experiment is technically sound and works in the game.**

## 3. Current Development Status

This section reflects features implemented or discussed during development. It is not a fresh audit of the GitHub repository.

### Implemented or previously confirmed foundations

- Maven project using Java 25.
- Interactive terminal menu for feeding, playing, sleeping, and viewing status.
- A `Dino` object named Heinrich.
- Three needs: `satiety`, `energy`, and `happiness`.
- Values from 0 to 100; higher values consistently indicate a better condition.
- Mood-dependent states using the `Mood` enum (`HAPPY`, `HUNGRY`, `TIRED`, `BORED`).
- Mood derived from needs rather than stored separately.
- Randomized responses based on the current mood.
- Initial terminal animations using frames, timing intervals, and animation types.
- Git version control and publication on GitHub during earlier development.

### Prototype limitations

The current animations primarily serve as technical experiments. The ASCII character is not yet visually convincing and is not intended as Heinrich's final design.

Existing need values and thresholds are provisional. There is no established balancing model, designed progression system, or defined long-term gameplay loop. That is acceptable at this stage.

Before any release, the actual repository must be checked to confirm that its name, files, and CI configuration match the latest decisions.

## 4. Game Concept and Possible Direction

Heinrich remains the central character. He should be more than a visual representation of three numbers. His mood and responses should become recognizable through behavior and animation.

The intended environment is a living jungle: plants, ferns, large leaves, moss, wood, stone, small clearings, and natural light. It remains undecided whether this will be a single customizable location, a collection of scenes, or an environment that can eventually be explored.

One possible extension combines the virtual pet with focus sessions and short games. Nibblosaur could run alongside studying or programming without becoming an intrusive productivity system.

**The relative importance of these elements remains open.** Nibblosaur does not need to define itself exclusively as a virtual pet, focus game, or minigame collection at this point.

## 5. Heinrich: State and Behavior

### 5.1 Needs

The current prototype uses three values:

| Attribute | 0 | 100 |
|---|---|---|
| `satiety` | Extremely hungry | Fully fed |
| `energy` | Exhausted | Fully rested |
| `happiness` | Very unhappy | Very happy |

The consistent meaning of these values is a deliberate design choice: **higher values always represent a better condition in the corresponding category.** This makes the model easier to read and the logic more consistent.

### 5.2 Moods

The `Mood` enum currently defines `HAPPY`, `HUNGRY`, `TIRED`, and `BORED`. Mood is derived from the character's needs. It is not stored as an independent value that could become inconsistent with the underlying state.

The current order of condition checks determines which mood takes priority when several conditions are met at once. Whether this priority order makes sense in gameplay still needs to be evaluated.

### 5.3 Personality and Animation

Heinrich should develop a recognizable personality through his reactions. Possible behaviors include blinking, looking around, sleeping, jumping, playing, and occasional unexpected actions.

The immediate goal is a small number of well-executed animations rather than as many animation types as possible. A consistent character design, readable movement, and a clear relationship between actions and state matter most.

His final appearance, dinosaur species, proportions, and defining behavioral traits have not been established.

## 6. Art Direction

### 6.1 General Direction

**Jungle rather than mint minimalism.** The visual world should feel denser, more natural, and more alive: deep greens, varied vegetation, warm highlights, and earthy materials.

The environment can be cozy without looking sterile or excessively polished. Visual hierarchy remains important: Heinrich must stand out clearly from the background, and important interactions should not get lost among decorative elements.

### 6.2 Provisional Color Palette

| Role | Name | Hex |
|---|---|---|
| Dark background | Jungle Night | `#10271C` |
| Shadows / surfaces | Canopy Green | `#234F32` |
| Vegetation | Fern Green | `#417D47` |
| Bright leaves / accents | Tropical Leaf | `#76AA55` |
| Moss / transitions | Moss | `#A0A66B` |
| Light / potential rewards | Sunlit Gold | `#E0B85B` |
| Stone / earth / wood | Sandstone | `#D6BE91` |
| Light text | Ivory | `#F2EAD2` |

This palette is a starting point, not a binding color specification. It needs to be evaluated using actual sprites, UI elements, and a coherent scene.

### 6.3 Graphics and Interface

2D pixel art is the preferred direction for upcoming experiments. Sprite resolution, perspective, animation scope, typography, and environmental detail remain undecided.

The logo and wordmark are also open. `Nibblosaur` is the current project name; `a milisaur game` may serve as a subtle developer credit. A final tagline is not necessary at this point.

## 7. Possible Game Systems

**This section is a collection of ideas, not a roadmap.** None of the systems below is fully specified or committed to implementation.

### 7.1 Minigames

Small standalone games could provide additional ways to interact. Possible mechanics include dexterity challenges, collecting, reaction-based gameplay, and puzzles.

An important open question is whether minigames should remain independent or affect Heinrich, resources, or the jungle environment.

The first minigame should work as a small, isolated experiment before introducing a larger minigame framework.

### 7.2 Pomodoro and Focus Features

A focus timer could accompany studying or programming. Basic functionality might include starting, pausing, resetting, and selecting a session duration.

It may also be interesting to explore how Heinrich or his environment reacts during a focus session. This does not necessarily require a reward system.

**The timer should remain optional and must not introduce another obligation.** Whether it becomes a central feature or a minor addition should be decided through prototyping.

### 7.3 Tokens and Long-Term Progression

Collectible tokens could support long-term progression, potentially earned through playing or completing focus sessions. Possible uses include decorations, plants, toys, or other visible changes to the environment.

Token sources, distribution, uses, and persistence are not yet defined. It is also open whether an in-game currency is necessary at all.

Tokens would be an internal game resource only, not a cryptocurrency or real-money system.

### 7.4 A Changing Jungle Environment

An environment that changes over time could give Nibblosaur additional depth. Possible additions include new plants, objects, areas, and interactions.

A world map, crafting system, or complex inventory architecture is not required at present and should not be designed in advance.

## 8. Intended Experience and Design Boundaries

Nibblosaur should be a game worth returning to. Interactions with Heinrich and his surroundings should remain interesting without artificially punishing absence.

This suggests the following provisional guidelines:

- No mandatory daily tasks introduced solely to drive retention.
- No harsh streak penalties assumed as a core mechanic.
- No unnecessary complexity before its value is clear.
- No feature added simply because other games commonly include it.
- Short, observable experiments before designing long-term systems.

These guidelines do not rule out deeper or more complex systems later. They describe the experience currently being explored.

## 9. Technical Direction

### 9.1 Current Foundation

- **Java 25** as the programming language.
- **Maven** as the build system.
- **Git / GitHub** for version control.
- **Terminal rendering** as the prototype's current runtime interface.

### 9.2 Graphics

JavaFX is a reasonable candidate for the next graphical prototype. A decision should follow a small practical experiment: open a window, display Heinrich, and implement one movement or interaction.

The terminal prototype should remain available for learning and testing until a graphical alternative actually works.

### 9.3 Code Organization

Game logic should remain as independent from presentation as reasonably possible. A `Dino` object should manage its needs and game rules without needing to know whether Heinrich is rendered as terminal text or a sprite.

Additional classes, interfaces, and abstractions should be introduced only when concrete requirements justify them. Building an extensive architecture in advance would not be useful at the current stage.

Implementation should remain understandable and verifiable: working intermediate versions, meaningful Git commits, and tests where specific game rules can be checked. Source code is written without comments; technical explanations belong in the project documentation.

## 10. Open Questions

The following questions remain deliberately unresolved:

- What role will the virtual pet system play in the long term?
- How important will minigames, a timer, and tokens actually become?
- What form will Heinrich's jungle environment take?
- Will the environment be customizable, explorable, or both?
- Will additional characters be introduced?
- How will time pass in the game, particularly while the application is closed?
- Which states and progression data need to be saved?
- Which visual style and technical platform work best in practice?
- Which platforms and release formats might become relevant?
- What kind of progression is interesting without becoming an obligation?

Leaving these questions open is not a lack of planning. The current prototype does not yet provide enough evidence to settle them sensibly.

## 11. Next Experiments

The most obvious next area to explore is Heinrich's visual presentation:

1. Develop a convincing character design and initial consistent animation frames.
2. Experiment with a small graphical scene that captures the jungle atmosphere.
3. Display Heinrich in that scene and make him respond to an input.
4. Evaluate the technical and gameplay direction based on the result.

This order is a working assumption, not a binding milestone plan. Priorities can change if another part of the project becomes more interesting or more useful for learning.

## 12. Document Maintenance and Decisions

This GDD records the current state, not a guaranteed final product. New ideas should initially remain open. They become project decisions only after a deliberate choice or a successful experiment.

| Label | Meaning |
|---|---|
| **Implemented** | Developed during the project; must be reverified before release |
| **Provisional** | Currently preferred direction, subject to change |
| **Idea** | Potential approach without an implementation commitment |
| **Open** | No sufficiently grounded decision yet |
| **Discarded / superseded** | No longer authoritative; record the reason when useful |

Major changes should remain traceable through a date and a brief explanation. Small observations and spontaneous experiments do not require a formal decision process.

### Revision History

| Version | Date | Change |
|---|---|---|
| 0.1 | 2026-11-23 | Initial outline of the project and possible development directions |
| 0.2 | 2026-11-23 | More personal wording; still used first-person perspective |
| 0.3 | 2026-11-23 | Professional, impersonal revision; clearer distinction between current state, direction, and open ideas |
| **0.4** | **2026-11-23** | **English-language revision of v0.3; scope and decision status retained** |

---

**Guiding principle:** Nibblosaur should have a recognizable direction without restricting its future development to a fixed scope or a predetermined type of game.
