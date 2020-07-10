package Kata;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
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
    }
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
