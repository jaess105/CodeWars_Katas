def abbrev_name(name):
    nameList = name.split(" ")
    ergebnis = ""
    for i in range(0,len(nameList)):        
        ergebnis += nameList[i][:1].upper()
        if len(nameList)>i+1:
            ergebnis+="."
    return ergebnis

print(abbrev_name("Jannik Esser"))