/* This is the console executable, that makes us of the BullCow Class
This acts as the view in a MVC pattern, and is responsible for all user
interaction. For game logic see the FBullCowGame class.
*/
#include <iostream>
#include <string>
#include <stdio.h>
#include "FBullCowGame.h"

using FText = std::string; // Type Alias
using int32 = int; // primitive type so dont need std


void PrintIntro();
void PlayGame();
FText GetValidGuess();
bool AskToPlayAgain();
void PrintGameSummary();

FBullCowGame BCGame; // instantiate a game


int main() {

	bool bPlayAgain = false;
	do {
		PrintIntro();
		PlayGame();
		bPlayAgain = AskToPlayAgain();
	} while (bPlayAgain);

	return 0;
}

void PrintIntro() {
	// introduce the game
	std::cout << "\n\nWelcome to Bulls and Cows\n";

	std::cout << "                   ________________________     \n";
 	std::cout << "          (__)    |                        |    \n";         
	std::cout << "          (oo)    |  Bulls    &     Cows!  |   \n";
	std::cout << "   /-------00  --'|________________________|    \n";
	std::cout << "  / |     ||                                    \n";
	std::cout << " *  ||----||                                    \n";
	std::cout << "    ^^    ^^ \n\n";

	std::cout << "Can you guess the " << BCGame.GetHiddenWordLength();
	std::cout << " letter isogram I'm thinking of?\n\n";
	return;
}

void PlayGame() {
	BCGame.Reset();
	int32 MaxTries = BCGame.GetMaxTries();

	// loop asking for guesses while the game is NOT won
	// and there are still tries remaining
	while (!BCGame.IsGameWon() && BCGame.GetCurrentTry() <= MaxTries) {
		FText Guess = GetValidGuess();


		FBullCowCount BullCowCount = BCGame.SubmitValidGuess(Guess);

		std::cout << "Bulls = " << BullCowCount.Bulls;
		std::cout << ". Cows = " << BullCowCount.Cows << std::endl;
		std::cout << std::endl;
	}
	PrintGameSummary();
}

// loop continually until the user gives a valid guess
FText GetValidGuess() { 
	FText Guess = "";
	EGuessStatus Status = EGuessStatus::Invalid_Status;
	do {
		// get a guess from the player
		int32 TryNumber = BCGame.GetCurrentTry();
		std::cout << "Try " << TryNumber << " of " << BCGame.GetMaxTries();
		std::cout << ". Enter your guess: ";
		std::getline(std::cin, Guess);

		Status = BCGame.CheckGuessValidity(Guess);

		switch (Status){
		case EGuessStatus::Wrong_Length:
			std::cout << "Please enter a " << BCGame.GetHiddenWordLength() << " letter word. \n\n";
			break;
		case EGuessStatus::Not_Isogram:
			std::cout << "Please enter a word without repeating letters.\n\n";
			break;
		case EGuessStatus::Not_Lowercase:
			std::cout << "Please enter all lowercase letters.\n\n";
			break;
		default:
			break;
		}
		std::cout << std::endl;
	} while (Status != EGuessStatus::OK); // keep looking until we get no errors
	return Guess;



}

bool AskToPlayAgain() {
	std::cout << "Do you want to play again? ";
	FText Response = "";
	getline(std::cin, Response);

	return  (Response[0] == 'y' || Response[0] == 'Y');
}

void PrintGameSummary(){
	if (BCGame.IsGameWon()) {
		std::cout << "WELL DONE - YOU WIN!\n\n";
	}
	else {
		std::cout << "Better luck next time!\n\n";
	}

}


