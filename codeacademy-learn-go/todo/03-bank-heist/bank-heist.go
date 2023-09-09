package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())

	isHeistOn := true
	eludedGuards := rand.Intn(100)

	if eludedGuards >= 50 {
		fmt.Println("Looks like you've managed to make it past the guards. Good job, but remember, this is the first step.")
	} else {
		isHeistOn = false
		fmt.Println("Plan a better disguise next time?")
	}

	leftSafely := rand.Intn(5)

	if openedVault := rand.Intn(100); isHeistOn && openedVault >= 70 {
		fmt.Println("Grab and GO!")
	} else if isHeistOn {
		isHeistOn = false
		fmt.Println("Vault can't pe opened.")
	}

	if isHeistOn {
		switch leftSafely {
		case 0:
			isHeistOn = false
			fmt.Print("Turns out vault doors don't open from the inside...")
		case 1:
			isHeistOn = false
			fmt.Print("Turns out vault doors don't open from the inside...")
		case 2:
			isHeistOn = false
			fmt.Print("Turns out vault doors don't open from the inside...")
		case 3:
			isHeistOn = false
			fmt.Print("Turns out vault doors don't open from the inside...")
		default:
			fmt.Print("Start the getaway car!")
		}
	}

	if isHeistOn {
		amtStolen := 10000 + rand.Intn(1000000)
		fmt.Println(amtStolen)
	}

	fmt.Println(isHeistOn)
}
