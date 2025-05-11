# SUST Life

A Java-based game developed by Mehedi and Ataur from CSE, SUST, Bangladesh.

## Description

SUST Life is a 2D game that simulates life at SUST (Shahjalal University of Science and Technology). The game features a character that can navigate through the university environment, interacting with various elements and playing mini-games.

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven (for building and running the project)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/Liquid-Luck.git
cd Liquid-Luck
```

2. Navigate to the project directory:
```bash
cd SUST_Life
```

## Running the Game

To run the game, use Maven:
```bash
mvn compile exec:java
```

## Controls

The game uses the following keyboard controls:
- `W` - Move Up
- `S` - Move Down
- `A` - Move Left
- `D` - Move Right

## Project Structure

```
SUST_Life/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── liquid_luck/
│   │   │       ├── sust_life/        # Main game classes
│   │   │       ├── tile/             # Tile management
│   │   │       ├── miniGamePong/     # Pong mini-game
│   │   │       └── sprites/          # Game sprites
│   │   └── resources/                # Game assets
│   │       ├── *.png                 # Image files
│   │       └── startScreen.txt       # Map layout
└── pom.xml                          # Maven configuration
```

## Features

- 2D character movement
- Collision detection
- Tile-based map system
- Mini-games (including Pong)
- Custom sprites and graphics

## Development

The game is built using:
- Java Swing for the GUI
- Maven for dependency management and building
- Custom game engine implementation

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Authors

- Mehedi and Ataur
- CSE, SUST
- Bangladesh

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- SUST (Shahjalal University of Science and Technology)
- All contributors and testers 