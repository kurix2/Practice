#include "FBullCowGame.h"
#include <map>

//to make syntax Unreal friendly
#define TMap std::map

FBullCowGame::FBullCowGame() {Reset(); } // constructor

void FBullCowGame::Reset(){
	constexpr int32 MAX_TRIES = 5;
	
	const FString HIDDEN_WORD = "planet";
	MyHiddenWord = HIDDEN_WORD;

	MyCurrentTry = 1;
	bGameIsWon = false;
	return;
}

int32 FBullCowGame::GetCurrentTry() const {return MyCurrentTry;}
int32 FBullCowGame::GetHiddenWordLength() const {return MyHiddenWord.length();}
bool FBullCowGame::IsGameWon() const {return bGameIsWon;}

int32 FBullCowGame::GetMaxTries() const { 
	TMap<int32, int32> WordLengthToMaxTries{ {3,5}, {4,5}, {5,6}, {6,10} };
	return WordLengthToMaxTries[MyHiddenWord.length()]; 
}


EGuessStatus FBullCowGame::CheckGuessValidity(FString Guess) const{
	
	if (!IsIsoGram(Guess)) // if the guess isn't an isogram
	{
		return EGuessStatus::Not_Isogram;
	}
	else if (!IsLowerCase(Guess)) // if the guess isn't all lowercase
	{
		return EGuessStatus::Not_Lowercase;
	}
	else if (Guess.length() != GetHiddenWordLength()){ // if the guess length is wrong
		return EGuessStatus::Wrong_Length;
	}
	else{
		return EGuessStatus::OK;
	}
}

// receives a valid count, increments and return turns
FBullCowCount FBullCowGame::SubmitValidGuess(FString Guess)
{
	MyCurrentTry++;
	FBullCowCount BullCowCount;

	// loop through all letters in the hidden word
	int32 WordLength = MyHiddenWord.length(); // assuming the same length as guess

	for (int32 MHWChar = 0; MHWChar < WordLength; MHWChar++) {
		// compare letters against the guess
		for (int32 GChar = 0; GChar < WordLength; GChar++) {
			// if they match then
			if (Guess[GChar] == MyHiddenWord[MHWChar]) {
				if (MHWChar == GChar) { // if they're in the same place
					BullCowCount.Bulls++; // incriment bulls
				}
				else {
					BullCowCount.Cows++; // must be a cow
				}
			}
		}
	}

	if (BullCowCount.Bulls == WordLength){
		bGameIsWon = true;
	}
	else {
		bGameIsWon = false;
	}
	return BullCowCount;
}

bool FBullCowGame::IsIsoGram(FString Word) const {
	// treat 0 and 1 letter words as isograms
	if (Word.length() <= 1) { return true; }

	// setup map
	TMap<char, bool> LetterSeen;
	for (auto Letter : Word) {	// for all letter of the word. Range based For statement
		Letter = tolower(Letter);
		if (LetterSeen[Letter]) {
			return false; // No isogram at this stage
		}
		else {
			LetterSeen[Letter] = true;
		}
	}
	return true; // for example in cases where /0 is entered
}

bool FBullCowGame::IsLowerCase(FString Word) const
{
	for (auto Letter : Word) {
		if(!islower(Letter)){
			return false;
		}
	}
	return true;
}
