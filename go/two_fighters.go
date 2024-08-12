package kata

type Fighter struct {
	Name            string
	Health          int
	DamagePerAttack int
}

func DeclareWinner(fighter1 Fighter, fighter2 Fighter, firstAttacker string) string {
	var first *Fighter = nil
	var second *Fighter = nil
	if firstAttacker == fighter1.Name {
		first = &fighter1
		second = &fighter2
	} else {
		first = &fighter2
		second = &fighter1
	}

	if second.Health <= 0 {
		return first.Name
	}

	if first.Health <= 0 {
		return second.Name
	}

	for {
		second.Health -= first.DamagePerAttack
		if second.Health <= 0 {
			return first.Name
		}

		second.Health -= first.DamagePerAttack
		if first.Health <= 0 {
			return second.Name
		}
	}
}
