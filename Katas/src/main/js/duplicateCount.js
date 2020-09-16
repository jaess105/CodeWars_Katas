function duplicateCount(text){
    let existingChars = new Map();
    let ausgabe=0;
    text=text.toLowerCase()
    for(let i=0; i< text.length;i++){
        var string = new RegExp(text.charAt(i), 'g');
        var count = (text.match(string) || []).length;
        console.log(count)
        ausgabe--;
        ausgabe+=count;        
    }
    return ausgabe;
}

        /*

    for(let i=0; i< text.length;i++){
        if(existingChars.has(text.charAt(i))){
            existingChars.set(text.charAt(i),existingChars.get(text.charAt(i))+1);
        }
        else{
            existingChars.set(text.charAt(i),0);
        }           
    }
    for(let key of existingChars.keys()){
        let element=existingChars.get(key);
        if(element>=1){
          ausgabe++;
        }
      }
      return ausgabe;
}
/*



        if(existingChars.has(text.charAt(i))){
            existingChars.set(text.charAt(i),existingChars.get(text.charAt(i))+1);
        }
        else{
            existingChars.set(text.charAt(i),0);
        }
    }
    for(let key of existingChars.keys()){
      let element=existingChars.get(key);
      if(element>highestAccurance){
        highestAccurance=element;
      }
    }
  
    return highestAccurance;
}
*/