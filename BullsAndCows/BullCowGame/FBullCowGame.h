#pragma once

#include<string>

// to make syntax Unreal Engine friendly
using FString = std::string; // alias
using int32 = int; // primitive type so dont need std


struct FBullCowCount {
	int32 Bulls = 0;
	int32 Cows = 0;
};

enum class EGuessStatus {
	Invalid_Status,
	OK,
	Not_Isogram,
	Wrong_Length,
	Not_Lowercase,
};


// Never use namesapce inside of a header fil

class FBullCowGame {
public:
	FBullCowGame(); // constructor

	void Reset(); 
	int32 GetMaxTries() const;
	int32 GetCurrentTry() const;
	int32 GetHiddenWordLength() const;
	bool IsGameWon() const;
	EGuessStatus CheckGuessValidity(FString) const;
	
	// couts bulls and cows and increases try number assuming valid guess

	FBullCowCount SubmitValidGuess(FString);

private:
	int32 MyCurrentTry = 1;
	int32 MyMaxTries = 3;
	FString MyHiddenWord;
	bool bGameIsWon;

	bool IsIsoGram(FString Word) const;
	bool IsLowerCase(FString Word) const;
};