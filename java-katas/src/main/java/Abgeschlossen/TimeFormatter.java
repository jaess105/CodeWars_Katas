package Abgeschlossen;

public class TimeFormatter {

  public static String formatDuration(int seconds) {
    if(seconds == 0)
      return "now";
    int yearInSec = 31536000, dayInSec = 86400, hourInSec = 3600, minuteInSec = 60;
    String converted = new StringBuilder()
        .append(format(seconds / yearInSec, "year"))
        .append(format(seconds % yearInSec / dayInSec, "day"))
        .append(format(seconds % dayInSec / hourInSec, "hour"))
        .append(format(seconds % hourInSec / minuteInSec, "minute"))
        .append(format(seconds % 60, "second"))
        .toString()
        .replaceAll("(, $)", "");
    return replaceLast(converted, ","," and");
  }

  static String format(int time, String timeDeclarer) {
    return time < 1 ? "" : time + " " + (time == 1 ? timeDeclarer + ", " : timeDeclarer + "s, ");
  }

  static String replaceLast(String text, String regex, String replacement) {
    return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
  }


    /*public static String formatDuration(int seconds) {
        // your code goes here
        int year=31536000,day=86400, hour=3600, minute =60;
        int [] time={0,0,0,0,0};
        int elements=0;
        if(seconds==0)return "now";
        time[3]=seconds/minute;
        time[4]=seconds-minute*time[3];
        time[2]=time[3]/60;
        time[3]-=60*time[2];
        time[1]=time[2]/24;
        time[2]-=24*time[1];
        time[0]=time[1]/365;
        time[1]-=365*time[0];
        return ausgabe(time, seconds);
    }
    private static String ausgabe(int[] time, int seconds){
        String [] times={"year","day","hour","minute","second"};
        String ausgabe="";
        int alreadyElement=0;
        for(int i=times.length-1;i>=0;i--){
            if(time[i]>1&&alreadyElement==0){
                ausgabe+=time[i]+" "+times[i]+"s"+ausgabe;
                alreadyElement++;
            }
            else if(time[i]==1&&alreadyElement==0){
                ausgabe+=time[i]+" "+times[i];
                alreadyElement++;
            }
            else if(time[i]>1&&alreadyElement==1){
                ausgabe=time[i]+" "+times[i]+"s and "+ausgabe;
                alreadyElement++;
            }
            else if(time[i]==1&&alreadyElement==1){
                ausgabe=time[i]+" "+times[i]+" and "+ausgabe;
                alreadyElement++;
            }
            else if(time[i]>1&&alreadyElement>1){
                ausgabe=time[i]+" "+times[i]+"s, "+ausgabe;
                alreadyElement++;
            }
            else if(time[i]==1&&alreadyElement>1){
                ausgabe=time[i]+" "+times[i]+", "+ausgabe;
                alreadyElement++;
            }
        }
        return ausgabe;
    }*/
}

 /*
        time[0]=seconds/year;
        seconds-=year*time[0];
        time[1]=seconds/day;
        seconds-=day*time[1];
        time[2]=seconds/hour;
        seconds-=hour*time[2];
        time[3]=seconds/minute;
        seconds-=minute*time[3];
        time[4]=seconds;
        */
